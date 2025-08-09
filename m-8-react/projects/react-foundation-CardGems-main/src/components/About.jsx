import React, { useContext } from 'react';
import { ProductContext } from '../context/ProductContext';
import { DataContext, AgeContext, PhoneContext } from '../App';

function About() {
  // Accessing productId from ProductContext
  const { productId } = useContext(ProductContext);

  // Accessing name, age, and phone from their respective contexts
  const name = useContext(DataContext);
  const age = useContext(AgeContext);
  const phone = useContext(PhoneContext);

  return (
    <div className="container mx-auto p-4">
      <h1 className="text-2xl font-bold mb-4">About</h1>
      <p className="text-lg">Received ID: {productId ? productId : 'No ID received'}</p>
      <p className="text-lg">Name: {name}</p>
      <p className="text-lg">Age: {age}</p>
      <p className="text-lg">Phone: {phone}</p>
    </div>
  );
}

export default About;
