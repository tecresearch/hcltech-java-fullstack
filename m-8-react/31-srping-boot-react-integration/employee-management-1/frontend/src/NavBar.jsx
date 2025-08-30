import React from 'react'
import { Link } from 'react-router-dom'
import '/node_modules/bootstrap/dist/css/bootstrap.min.css'
const NavBar = () => {
  return (
    <div>
      <ul className="nav nav-tabs">

        <ul>
          <li>
            <Link to="/home" className="nav-link">Home</Link>
            <Link to="/home/count" className="nav-link">Counter</Link>
          </li>
        </ul>

      </ul>
    </div>
  )
}

export default NavBar
