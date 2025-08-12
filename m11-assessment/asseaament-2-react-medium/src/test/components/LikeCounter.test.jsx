import React from 'react';
import { render, screen, fireEvent } from '@testing-library/react';
import LikeCounter from '../../components/LikeCounter';

test('increments count on button click', () => {
    render(<LikeCounter />);

    // Select the button
    const button = screen.getByRole('button');

    // Check initial count is 0
    expect(screen.getByText(/0/i)).toBeInTheDocument();

    // Click the button
    fireEvent.click(button);

    // Verify count increments to 1
    expect(screen.getByText(/1/i)).toBeInTheDocument();

    // Click the button again
    fireEvent.click(button);

    // Verify count increments to 2
    expect(screen.getByText(/2/i)).toBeInTheDocument();
});

