import React  from 'react'
import heart from '../assets/heart.svg'
const LikeCounter = (props) => {
  
  return (
    <div>
      <button onClick={props.handleClick}>
        <h1>{props.like}</h1><img src={heart}></img>
      </button>
    </div>
  )
}

export default LikeCounter
