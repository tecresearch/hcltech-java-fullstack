import React from 'react';

const NavBar = ({ wishlistLength, toggleSidebar }) => {
    return (
        <nav className="w-full bg-blue-600 p-4 shadow-md flex justify-between items-center">
            <h1 className="text-white text-3xl font-bold">Book Store</h1>
            <button 
                className="bg-yellow-500 hover:bg-yellow-700 text-white font-semibold px-4 py-2 rounded-lg shadow-md"
                onClick={toggleSidebar}
            >
                Cart ({wishlistLength})
            </button>
        </nav>
    );
};

export default NavBar;
