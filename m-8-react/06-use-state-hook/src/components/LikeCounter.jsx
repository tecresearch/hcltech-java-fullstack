import React, { useState } from 'react'
import heart from '../assets/heart.svg'
const LikeCounter = () => {
    const [count,setCount]=useState(0);
  return (
    <div>
      <button onClick={()=>{setCount((count)=>count+1)}}>
        <h1>{count}</h1><img src={heart}></img>
      </button>
    </div>
  )
}

export default LikeCounter
