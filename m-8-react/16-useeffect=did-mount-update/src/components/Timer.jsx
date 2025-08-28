import React, { useState } from 'react'
import { useEffect } from 'react';

const Timer = () => {

    const [seconds,setSeconds]=useState(0);

    useEffect(()=>{

        const intervalId=setInterval(()=>{
            console.log("setInterval Executed");
            setSeconds((prevs)=>prevs+1);
        },1000);

        return ()=>{
            console.log("Stop Timer");
            clearInterval(intervalId);
        };
       
    },[]);

  return (
    <div>
      <h1>{seconds}</h1>
    </div>
  )
}

export default Timer
