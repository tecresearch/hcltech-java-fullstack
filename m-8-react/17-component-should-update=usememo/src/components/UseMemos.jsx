import React, { useMemo, useState } from 'react'

const UseMemos = () => {

    const [number,setNumber]=useState(0);

    const doubleNumber=useMemo(()=>{
        console.log("Calculating.....");
        return number*2;
    },[number]);
    const calCulate=(e)=>{
        setNumber(parseInt(e.target.value)||0);
    }
  return (
    <div>
    <h1>useMemo Example </h1>
      <input 
      value={number}
      type='number' 
      onChange={calCulate}/>
      <h1>Double: {doubleNumber}</h1>
    </div>

  )
}

export default UseMemos
