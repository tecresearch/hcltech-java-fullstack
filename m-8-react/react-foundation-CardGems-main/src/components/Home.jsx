import React, { useContext, useState } from 'react';
import { useNavigate } from 'react-router-dom';
import { ProductContext } from '../context/ProductContext';

function Home() {
  const navigateTo = useNavigate();
  const { setProductId } = useContext(ProductContext);
  const [id, setId] = useState('');

  const goToAbout = () => {
    if (id.trim()) {
      setProductId(id.trim()); // Update the context state
      navigateTo('/about');
    } else {
      alert('Please enter a valid ID');
    }
  };

  return (
    <div 
      className="container mx-auto flex items-center justify-center h-screen bg-cover bg-center" 
      style={{ backgroundImage: 'url(https://example.com/your-image.jpg)' }}
    >
      <div className="text-center bg-opacity-75 bg-black p-8 rounded-md">
        <h1 className="text-4xl font-bold text-white mb-4">Welcome to Our Website</h1>
        <p className="text-lg text-gray-300 mb-6">Discover amazing products and services tailored just for you.</p>
        <div className="mb-4">
          <input
            type="text"
            placeholder="Enter ID"
            value={id}
            onChange={(e) => setId(e.target.value)}
            className="p-2 border rounded"
          />
          <button
            onClick={goToAbout}
            className="bg-blue-500 text-white px-6 py-3 rounded-lg hover:bg-blue-700 transition duration-300"
          >
            Get Started
          </button>
        </div>
      </div>
    </div>
  );
}

export default Home;
