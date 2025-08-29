import React from "react";
import "./App.css";
import "h8k-components";
import "./components/FitnessTracker";
import FitnessTracker from "./components/FitnessTracker";

const title = "Fitness Tracker";

const App = () => {
  return (
    <div className="App">
      <h8k-navbar header={title}></h8k-navbar>
      <div className="flex justify-content-center">
        <FitnessTracker />
      </div>
    </div>
  );
};

export default App;
