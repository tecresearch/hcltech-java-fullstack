import React from "react";
import "@testing-library/jest-dom/extend-expect";
import { render, screen, fireEvent } from "@testing-library/react";
import FitnessTracker from "./components/FitnessTracker";

describe("Fitness Tracker Tests", () => {
  test("1. Initial all input boxes are empty", () => {
    render(<FitnessTracker />);
    expect(screen.getByTestId("input-exerciseType").value).toBe("");
    expect(screen.getByTestId("input-duration").value).toBe("");
    expect(screen.getByTestId("input-caloriesBurned").value).toBe("");
  });

  test("2. Should add log entry only after entering valid values in all fields", () => {
    render(<FitnessTracker />);

    // Enter valid inputs
    fireEvent.change(screen.getByTestId("input-exerciseType"), {
      target: { value: "Running" },
    });
    fireEvent.change(screen.getByTestId("input-duration"), {
      target: { value: "30" },
    });
    fireEvent.change(screen.getByTestId("input-caloriesBurned"), {
      target: { value: "300" },
    });

    // Click the "Log Activity" button
    fireEvent.click(screen.getByTestId("btn-logActivity"));

    // Check if a log entry was added
    const logEntries = screen.getAllByTestId("log-entry");
    expect(logEntries.length).toBe(1);

    // Verify the content of the log entry
    expect(logEntries[0].textContent).toContain("Running");
    expect(logEntries[0].textContent).toContain("30 minutes");
    expect(logEntries[0].textContent).toContain("300 kcal");
  });

  test("3. Should increase the total number of logs by 1 when a new log is added", () => {
    render(<FitnessTracker />);

    // First log entry
    fireEvent.change(screen.getByTestId("input-exerciseType"), {
      target: { value: "Cycling" },
    });
    fireEvent.change(screen.getByTestId("input-duration"), {
      target: { value: "45" },
    });
    fireEvent.change(screen.getByTestId("input-caloriesBurned"), {
      target: { value: "400" },
    });
    fireEvent.click(screen.getByTestId("btn-logActivity"));

    // Second log entry
    fireEvent.change(screen.getByTestId("input-exerciseType"), {
      target: { value: "Swimming" },
    });
    fireEvent.change(screen.getByTestId("input-duration"), {
      target: { value: "60" },
    });
    fireEvent.change(screen.getByTestId("input-caloriesBurned"), {
      target: { value: "500" },
    });
    fireEvent.click(screen.getByTestId("btn-logActivity"));

    // Check if two log entries are present
    const logEntries = screen.getAllByTestId("log-entry");
    expect(logEntries.length).toBe(2);

    // Verify the content of the log entries
    expect(logEntries[0].textContent).toContain("Cycling");
    expect(logEntries[0].textContent).toContain("45 minutes");
    expect(logEntries[0].textContent).toContain("400 kcal");

    expect(logEntries[1].textContent).toContain("Swimming");
    expect(logEntries[1].textContent).toContain("60 minutes");
    expect(logEntries[1].textContent).toContain("500 kcal");
  });

  test("4. If any of the field is empty and Log Activity button is clicked, it should do nothing", () => {
    render(<FitnessTracker />);
    fireEvent.change(screen.getByTestId("input-exerciseType"), {
      target: { value: "Running" },
    });
    fireEvent.change(screen.getByTestId("input-duration"), {
      target: { value: "" },
    });
    fireEvent.click(screen.getByTestId("btn-logActivity"));
    expect(screen.queryAllByTestId("log-entry").length).toBe(0);
  });

  test("5. Should clear all the logs when reset log button is clicked", () => {
    render(<FitnessTracker />);
    // Add a log
    fireEvent.change(screen.getByTestId("input-exerciseType"), {
      target: { value: "Running" },
    });
    fireEvent.change(screen.getByTestId("input-duration"), {
      target: { value: "30" },
    });
    fireEvent.change(screen.getByTestId("input-caloriesBurned"), {
      target: { value: "300" },
    });
    fireEvent.click(screen.getByTestId("btn-logActivity"));

    fireEvent.click(screen.getByTestId("btn-resetLog"));
    expect(screen.queryAllByTestId("log-entry").length).toBe(0);
  });

  test("6. No functionality is changed if Reset log button is clicked without any existing logs", () => {
    render(<FitnessTracker />);
    fireEvent.click(screen.getByTestId("btn-resetLog"));
    expect(screen.queryAllByTestId("log-entry").length).toBe(0);
  });

  test("7. All the input fields should be empty after the log is added to Activity log", () => {
    render(<FitnessTracker />);
    fireEvent.change(screen.getByTestId("input-exerciseType"), {
      target: { value: "Running" },
    });
    fireEvent.change(screen.getByTestId("input-duration"), {
      target: { value: "30" },
    });
    fireEvent.change(screen.getByTestId("input-caloriesBurned"), {
      target: { value: "300" },
    });
    fireEvent.click(screen.getByTestId("btn-logActivity"));

    expect(screen.getByTestId("input-exerciseType").value).toBe("");
    expect(screen.getByTestId("input-duration").value).toBe("");
    expect(screen.getByTestId("input-caloriesBurned").value).toBe("");
  });

  test("8. Should display error message for empty Exercise type", () => {
    render(<FitnessTracker />);

    // Enter invalid input
    fireEvent.change(screen.getByTestId("input-exerciseType"), {
      target: { value: "" },
    });
    fireEvent.click(screen.getByTestId("btn-logActivity"));

    // Verify error message
    expect(screen.getByTestId("error-message")).toBeInTheDocument();
    expect(screen.getByTestId("error-message")).toHaveTextContent(
      "Exercise type must not be empty."
    );
  });

  test("9. Should display error message for invalid Duration", () => {
    render(<FitnessTracker />);

    // Enter invalid input
    fireEvent.change(screen.getByTestId("input-exerciseType"), {
      target: { value: "Running" },
    });

    fireEvent.change(screen.getByTestId("input-duration"), {
      target: { value: "" },
    });
    fireEvent.click(screen.getByTestId("btn-logActivity"));

    // Verify error message
    expect(screen.getByTestId("error-message")).toBeInTheDocument();
    expect(screen.getByTestId("error-message")).toHaveTextContent(
      "Duration must be a positive number."
    );
  });

  test("10. Should display error message for invalid Calories", () => {
    render(<FitnessTracker />);

    // Enter invalid input
    fireEvent.change(screen.getByTestId("input-exerciseType"), {
      target: { value: "Running" },
    });

    fireEvent.change(screen.getByTestId("input-duration"), {
      target: { value: "10" },
    });

    fireEvent.change(screen.getByTestId("input-caloriesBurned"), {
      target: { value: "" },
    });
    fireEvent.click(screen.getByTestId("btn-logActivity"));

    // Verify error message
    expect(screen.getByTestId("error-message")).toBeInTheDocument();
    expect(screen.getByTestId("error-message")).toHaveTextContent(
      "Calories must be a positive number."
    );
  });

  test("11. Should clear error message when reset button is clicked", () => {
    render(<FitnessTracker />);

    // Enter invalid input
    fireEvent.change(screen.getByTestId("input-exerciseType"), {
      target: { value: "" },
    });
    fireEvent.click(screen.getByTestId("btn-logActivity"));

    // Verify error message
    expect(screen.getByTestId("error-message")).toBeInTheDocument();

    // Click Reset Log button
    fireEvent.click(screen.getByTestId("btn-resetLog"));

    // Verify error message is cleared
    expect(screen.queryByTestId("error-message")).toBeNull();
  });
});
