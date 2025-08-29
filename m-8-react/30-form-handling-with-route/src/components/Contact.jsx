import React from 'react'
import { Outlet } from 'react-router-dom'

const Contact = () => {
  return (
    <div>
      <h1 className='text-3xl'>Contact</h1>
      <Outlet/>
    </div>
  )
}

export default Contact
