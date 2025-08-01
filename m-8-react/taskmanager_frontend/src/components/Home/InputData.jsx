import React from 'react'
import { RxCross2 } from "react-icons/rx";
function InputData({ inputDiv, setInputDiv }) {
  return (
    <>
       <div className={`${inputDiv === "fixed" ? "fixed" : "hidden"} top-0 left-0 bg-gray-800 opacity-80 h-screen w-full`}></div>
       <div className={`${inputDiv === "fixed" ? "fixed" : "hidden"} top-5 left-0 flex items-center justify-center h-screen w-full`}>
      
            <div className={`${inputDiv === "fixed" ? "fixed" : "hidden"} w-3/6 bg-gray-900 p-4 rounded`} >
            <div className="flex justify-end px-4 py-4 ">
                    <button 
                     onClick={() => setInputDiv("hidden")} 
                    className="text-2xl">  <RxCross2 /></button>
           </div>
                 <input
                  type="text"
                  placeholder="Title"
                  name="title"
                  className="px-3 py-2 rounded w-full  bg-gray-700"
                 />
                  <textarea
                  type="text"
                  cols="30"
                  rows="10"
                  placeholder="Description"
                  name="desc"
                  className="px-3 py-2 rounded w-full bg-gray-700 my-3"
                 />
                 <button
                 type="submit"
                 className="px-3 py-2 bg-blue-400 rounded text-black textx-xl hover:bg-blue-500"
                 >Submit</button>
            </div>
            

       </div>
    
    </>
  )
} 

export default InputData