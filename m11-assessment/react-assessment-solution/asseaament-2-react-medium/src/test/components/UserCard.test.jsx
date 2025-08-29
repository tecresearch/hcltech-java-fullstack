import React from 'react'; // Import React
import { render, screen } from '@testing-library/react';
import { describe, it, expect, test } from 'vitest';
import UserCard from '../../components/UserCard'; // Ensure the path is correct


describe('Component Rendering Test', () => {
    // Combine titles, roles, and designations into a single array of arrays
    const testCases = [
        ['Bajarne', 'SDE', 'C++ Developer'],
        ['Gems Goslim', 'SDE', 'Java Developer'],
        ['Brijesh Nishad', 'SDE', 'Java FullStack Developer'],
    ];

    test.each(testCases)('should render the usercard with name %s, role %s and designation %s', (title, role, designation) => {
        render(<UserCard name={title} role={role} designation={designation} />);
        expect(screen.getByText(title)).toBeInTheDocument();
        expect(screen.getByText(role)).toBeInTheDocument();
        expect(screen.getByText(designation)).toBeInTheDocument();
    });
});