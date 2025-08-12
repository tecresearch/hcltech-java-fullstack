import React from 'react'
import './UserCard.css'
const UserCard = ({name,imageSrc,role,designation}) => {
  return (
    <div className='user-container'>
      <h2>{name}</h2>
      <img src={imageSrc} alt='Bajarne'/>
      <h2>{role}</h2>
      <p>{designation}</p>
    </div>
  )
}

export default UserCard
