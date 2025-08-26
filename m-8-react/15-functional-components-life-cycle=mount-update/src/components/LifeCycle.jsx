import React, { useState, useEffect } from 'react';

const Lifecycle = () => {
  const [count, setCount] = useState(0); // State declaration
  console.log('Function Component: Initializing state');

  useEffect(() => {
    console.log('useEffect: Component is mounted');
    const interval = setInterval(() => {
      incrementCount();
    }, 1000);

    // Cleanup function to run on component unmount
    return () => {
      console.log('useEffect: Cleaning up');
      clearInterval(interval);
    };
  }, []); // Empty dependency array ensures this runs only once (like componentDidMount)

  const incrementCount = () => {
    setCount(prevCount => prevCount + 1);
    console.log('IncrementCount: Count incremented');
  };

  useEffect(() => {
    console.log('useEffect: Component updated');
    console.log('Count changed to:', count);
  }, [count]); // Run this effect whenever `count` changes

  console.log('Render: Rendering the component');
  return <div>Count: {count}</div>;
};

export default Lifecycle;
