import React from 'react'
import './UserCard.css'
import brijeshPic from '../assets/brijesh.png'
const UserCard = () => {
  return (
    <div className='user-container'>
        <p>Brijesh Nishad</p>
       <img src={brijeshPic} alt='Nishad'></img>
       <p>Software Development Engineer</p>
       <p>(Java FullStack Developer)</p>
   
    </div>
  )
}

export default UserCard
