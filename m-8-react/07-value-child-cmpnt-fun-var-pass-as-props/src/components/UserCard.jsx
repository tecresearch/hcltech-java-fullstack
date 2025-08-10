import React from 'react'
import './UserCard.css'
const UserCard = (props) => {
  return (
    <div className='user-container'>
       <p>{props.name}</p>
       <img src={props.image} alt={props.children}></img>
       <p>{props.role}</p>
       <p>{props.designation}</p>
        {props.children}
    </div>
  )
}

export default UserCard
