import React from 'react';
import { NavLink } from 'react-router-dom';

const NavBar = () => {
  return (
    <div className='bg-gray-800'> {/* Tailwind CSS background color */}  
      <nav className='flex justify-between p-4'> {/* Flexbox layout for navbar */}  
        <div className='text-white font-bold'>My Website</div> {/* Logo or Title */}  
        <div className='space-x-4'> {/* Space between links */}  
          <NavLink
            to='/'
            className={({ isActive }) => 
              isActive ? 'text-white font-bold hover:text-gray-300' : 'text-black hover:text-green-300'
            }
          >
            Home
          </NavLink>
          <NavLink
            to='/about'
            className={({ isActive }) => 
              isActive ? 'text-white font-bold hover:text-gray-300' : 'text-black hover:text-green-300'
            }
          >
            About
          </NavLink>
          <NavLink
            to='/contact'
            className={({ isActive }) => 
              isActive ? 'text-white font-bold hover:text-gray-300' : 'text-black hover:text-green-300'
            }
          >
            Contact
          </NavLink>
        </div>
      </nav>
    </div>
  );
};

export default NavBar;
