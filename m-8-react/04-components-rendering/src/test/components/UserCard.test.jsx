import React from 'react'; // Import React
import { render, screen } from '@testing-library/react';
import { describe, it, expect, test } from 'vitest';
import UserCard from '../../components/UserCard'; // Ensure the path is correct

describe('Component Rendering Test', () => {
    it('should render the usercard and Brijesh Nishad must be present in the dom', () => {
        render(<UserCard />);
        expect(screen.getByText('Brijesh Nishad')).toBeInTheDocument();
        
    });
});

describe('Component Rendering Test', () => {
    it('should render the usercard and Software Development Engineer must be present in the dom', () => {
        render(<UserCard />);
        expect(screen.getByText('Software Development Engineer')).toBeInTheDocument();
    });
});

describe('Component Rendering Test', () => {
    test('should render the usercard and (Java FullStack Developer) must be present in the dom', () => {
        render(<UserCard />);
        expect(screen.getByText('(Java FullStack Developer)')).toBeInTheDocument();
        
    });
});

describe('Component Rendering Test', () => {
    // Array of titles you want to test
    const titles = [
        '(Java FullStack Developer)',
        'Software Development Engineer',
        'Brijesh Nishad',
        // Add more titles if needed
    ];

    test.each(titles)('should render the usercard and %s must be present in the DOM', (title) => {
        render(<UserCard />);
        expect(screen.getByText(title)).toBeInTheDocument();
    });
});