import React, { useState } from 'react'
import Cards from '../components/Home/Cards'
import { MdAddTask } from "react-icons/md";
import InputData from '../components/Home/InputData';
function AllTasks() {
  const [inputDiv,setInputDiv]=useState("hidden");
  return (
   <>
    <div>
      <div className="w-full flex justify-end px-4 py-4">
      
   <button onClick={() => setInputDiv(inputDiv === "hidden" ? "fixed" : "hidden")}>
  <MdAddTask className="text-4xl   hover:cursor-pointer transition-all duration-300" />
  </button>

      </div>
      <Cards home={"true"} setInputDiv={setInputDiv}/>
    </div>
  {/* Pass the state and setter to InputData */}
  <InputData inputDiv={inputDiv} setInputDiv={setInputDiv} />
   </>
  )
}

export default AllTasks