import React from 'react'
import './UserCard.css'
const UserCard = (props) => {
  return (
    <div className='user-container'>
       <p>{props.name}</p>
       <img src={props.image} alt='Nishad'></img>
       <p>{props.role}</p>
       <p>{props.designation}</p>
    </div>
  )
}

export default UserCard
