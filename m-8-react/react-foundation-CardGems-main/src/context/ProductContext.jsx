import React, { createContext, useState } from 'react';

// Create a Context for the product ID
export const ProductContext = createContext();

export const ProductProvider = ({ children }) => {
  const [productId, setProductId] = useState('');

  return (
    <ProductContext.Provider value={{ productId, setProductId }}>
      {children}
    </ProductContext.Provider>
  );
};
