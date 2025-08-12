```
Step-by-Step Testing Setup in React with Vitest
Step 1: Install Required Packages
Install the testing dependencies in your project:
@testing-library/jest-dom: Provides custom matchers for asserting on DOM nodes.
@testing-library/react: Allows testing of React components.
@testing-library/user-event: Simulates user interactions in your tests.
jest-dom: Additional jest matchers for expressive assertions.
jsdom: Enables DOM-like environment for testing.
vitest: Fast test runner for your Vite project.
Step 2: Add Test Script in package.json
Add a script in your package.json:
"scripts": {
    "test": "vitest"
}
Step 3: Create setupTests.js File
Create a setupTests.js file at the root of your project or the specified test folder:
// setupTests.js
import '@testing-library/jest-dom/vitest';
Step 4: Configure Vitest
Create or update your Vitest configuration file (e.g., vitest.config.js):
import { defineConfig } from "vitest/config";

export default defineConfig({
    test: {
        environment: 'jsdom',
        globals: true,
        setupFiles: './setupTests.js', // Ensure setupTests.js is included
    }
});
Step 5: Writing Your Tests
Use the Testing Library functions in your test files. For example:
import { render, screen } from '@testing-library/react';
import MyComponent from './MyComponent';

test('renders MyComponent', () => {
    render(<MyComponent />);
    const linkElement = screen.getByText(/some text/i);
    expect(linkElement).toBeInTheDocument();
});
By organizing your setup in this way, you ensure that Jest matchers are available to all your test files without needing to import them individually.
```