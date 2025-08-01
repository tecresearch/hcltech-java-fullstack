// components/NavBar.js

import React, { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';

function NavBar() {
  const [searchId, setSearchId] = useState('');
  const navigate = useNavigate();

  const handleSearch = (event) => {
    event.preventDefault();
    if (searchId.trim()) {
      navigate(`/products/${searchId.trim()}`);
    }
  };

  return (
    <nav className="bg-gray-800 p-4">
      <div className="container mx-auto flex justify-between items-center">
        <div className="text-white text-lg">
          <Link to="/" className="px-4 hover:underline">Home</Link>
          <Link to="/about" className="px-4 hover:underline">About</Link>
          <Link to="/products" className="px-4 hover:underline">Products</Link>
        </div>
        <form onSubmit={handleSearch} className="flex items-center">
          <input
            type="number"
            placeholder="Enter Product ID"
            value={searchId}
            onChange={(e) => setSearchId(e.target.value)}
            className="p-2 border rounded-l"
          />
          <button
            type="submit"
            className="bg-blue-500 text-white p-2 rounded-r hover:bg-blue-700"
          >
            Search
          </button>
        </form>
      </div>
    </nav>
  );
}

export default NavBar;
