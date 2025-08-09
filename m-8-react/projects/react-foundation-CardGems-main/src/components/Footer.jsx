import React, { useContext } from 'react';
import { Link } from 'react-router-dom';
import { DataContext, AgeContext, PhoneContext } from '../App';

function Footer() {
  // Consuming age context using useContext
  const age = useContext(AgeContext);

  return (
    <footer className="bg-gray-800 p-4 mt-8">
      <div className="container mx-auto text-center text-white">
        <div className="flex justify-center mb-4">
          <Link to="/" className="px-4 hover:underline">Home</Link>
          <Link to="/about" className="px-4 hover:underline">About</Link>
          <Link to="/products" className="px-4 hover:underline">Products</Link>
        </div>
        <div>
        <p className="text-sm text-gray-400">
          © {new Date().getFullYear()} Your Company. All rights reserved.
        </p>
        
        {/* Displaying name using DataContext.Consumer */}
        <DataContext.Consumer>
          {name => <p>Name: {name}</p>}
        </DataContext.Consumer>

        {/* Displaying age using useContext */}
        <p>Age: {age}</p>

        {/* Displaying phone using PhoneContext.Consumer */}
        <PhoneContext.Consumer>
          {phone => <p>Phone: {phone}</p>}
        </PhoneContext.Consumer>
        </div>
      </div>
    </footer>
  );
}

export default Footer;
