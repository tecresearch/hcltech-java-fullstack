import React from "react";
import LogForm from "./LogForm";
import LogList from "./LogList";

const FitnessTracker = () => {
  return (
    <div className="pa-20">
      <h1>Track Your Fitness</h1>
      <LogForm />
      <LogList />
    </div>
  );
};

export default FitnessTracker;
