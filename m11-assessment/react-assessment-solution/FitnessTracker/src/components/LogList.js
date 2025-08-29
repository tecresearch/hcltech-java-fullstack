import React from "react";
import "../App.css";

const LogList = () => {
  return (
    <div data-testid="log-list">
      <h2>Activity Log</h2>
      <ul className="pl-0 log-entry-ul">
        <li data-testid="log-entry" className="log-entry-li mb-10 pa-10">
          <p>
            <strong>Exercise:</strong> {`Jogging`}
          </p>
          <p>
            <strong>Duration:</strong> {`2`} minutes
          </p>
          <p>
            <strong>Calories Burned:</strong> {`100`} kcal
          </p>
        </li>
      </ul>
      {/* <p>No activities logged yet.</p> */}
    </div>
  );
};

export default LogList;
