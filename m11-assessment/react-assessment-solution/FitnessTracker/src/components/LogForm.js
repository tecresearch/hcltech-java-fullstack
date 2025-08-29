import React from "react";

const LogForm = () => {
  return (
    <div className="layout column justify-content-center align-items-center">
      <form data-testid="log-form">
        <div className="mb-10">
          <label>
            Exercise Type:
            <input
              type="text"
              name="exerciseType"
              value={`Running`}
              placeholder="e.g., Running"
              className="ml-50"
              data-testid="input-exerciseType"
              required
            />
          </label>
        </div>
        <div className="mb-10">
          <label>
            Duration (minutes):
            <input
              type="number"
              name="duration"
              value={`2`}
              placeholder="e.g., 30"
              className="ml-10"
              data-testid="input-duration"
              required
            />
          </label>
        </div>
        <div className="mb-10">
          <label>
            Calories Burned:
            <input
              type="number"
              name="caloriesBurned"
              value={`100`}
              placeholder="e.g., 300"
              className="ml-30"
              data-testid="input-caloriesBurned"
              required
            />
          </label>
        </div>
        <button type="submit" data-testid="btn-logActivity" className="mr-10">
          Log Activity
        </button>
        <button type="button" data-testid="btn-resetLog">
          Reset Log
        </button>
      </form>
      {/* <p data-testid="error-message" style={{ color: "red" }}>
        Exercise type must not be empty.
      </p> */}
    </div>
  );
};

export default LogForm;
