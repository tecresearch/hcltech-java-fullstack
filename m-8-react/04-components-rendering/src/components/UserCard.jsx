import React from 'react'
import './UserCard.css'

import brijesh from "../assets/brijesh.png"
 
const UserCard = () => {
  return (
    <div className='user-container'>
        <h2>Brijesh Nishad</h2>
        <img src={brijesh} />
        <p>Software Development Engineer</p>
        <p>(Java FullStack Developer)</p>


    </div>
  )
}

export default UserCard
