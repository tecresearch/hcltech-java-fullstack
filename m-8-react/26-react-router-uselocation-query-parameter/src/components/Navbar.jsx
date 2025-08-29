import React from 'react';
import { NavLink, Link, useLocation } from 'react-router-dom';
import './Navbar.css';

const Navbar = () => {
    const location = useLocation();
    const query = new URLSearchParams(location.search);
    console.log('Current Query Params:', query);
    console.log('Location:', location);
    const status = location.state ? location.state.status : 'unknown';
    // Step 1: Define your base URL and parameters
    const baseUrl = 'http://localhost:5173/dashboard';
    const params = new URLSearchParams({
        id: '258376919',
        name: 'Brijesh',
        address: 'mokalpur,gobrahan,varanasi,up,221104',
    });

    // Step 2: Create the full URL
    const url = `${baseUrl}?${params.toString()}`;
    console.log('Constructed URL:', url);
  
    

    const navigateWithState = () => {
        const state = { status: 'active', userId: 123 };
        localStorage.setItem('userStatus', JSON.stringify(state)); // Save to localStorage
        history.push({ pathname: '/dashboard', state });
    };
  

    return (
        <div className='nav-container'>
            <ul>
                <li>
                    <NavLink to={{ pathname: '/', state: { status: 'active' } }} className={({ isActive }) => isActive ? 'active-link' : ''}>Home</NavLink>
                </li>
                <li>
                    <NavLink to='/about' className={({ isActive }) => isActive ? 'active-link' : ''}>About</NavLink>
                </li>
                <li>
                    <NavLink to='/contact' className={({ isActive }) => isActive ? 'active-link' : ''}>Contact</NavLink>
                </li>
                <li>
                    <NavLink to={url} className={({ isActive }) => isActive ? 'active-link' : ''}>Dashboard</NavLink>
                </li>
            </ul>
            <hr />
            <p>Path: {location.pathname}</p>
            <p>Query ID: {query.get('id')}</p>
            <p>Query Name: {query.get('name')}</p>
            <p>Query Address: {query.getAll('address').join(', ')}</p>
            <p>Constructed URL: {url}</p>
            <p style={{ color: status === 'active' ? 'green' : 'red' }}>State:{status}</p>
            <button onClick={navigateWithState}>Go to Dashboard</button>
        </div>
    );
};

export default Navbar;
