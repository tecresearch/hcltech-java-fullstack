import React, { createContext, useState } from 'react';
import { Routes, Route } from 'react-router-dom';
import Home from './components/Home';
import About from './components/About';
import NavBar from './components/NavBar';
import Footer from './components/Footer';
import NotFound from './components/NotFound';
import Product from './components/Product';

// Creating contexts
export const DataContext = createContext();
export const AgeContext = createContext();
export const PhoneContext = createContext();

function App() {
  const [user, setUser] = useState({
    name: "Brijesh Nishad",
    age: 22,
    phone: "123-456-7890"
  });

  return (
    <div className="p-4">
      <DataContext.Provider value={user.name}>
        <AgeContext.Provider value={user.age}>
          <PhoneContext.Provider value={user.phone}>
            <NavBar />
            <Routes>
              <Route path="/" element={<Home />} />
              <Route path="/about" element={<About />} />
              <Route path="/products" element={<Product />} />
              <Route path="/products/:productId" element={<Product />} />
              <Route path="*" element={<NotFound />} />
            </Routes>
            <Footer />
          </PhoneContext.Provider>
        </AgeContext.Provider>
      </DataContext.Provider>
    </div>
  );
}

export default App;
