import React, { useCallback, useMemo, useState } from 'react'
/**
 * 
 * @returns The useCallback hook allows you to control when a function
 *  is re-created, which can replace some of the functionality of the
 *  shouldComponentUpdate lifecycle method in class components by optimizing 
 * performance in functional components.

How It Works
Preventing Unnecessary Re-renders: In class components, shouldComponentUpdate allows you to define whether a 
component
 should re-render based on state or prop changes. In functional components, useCallback can be used to memoize 
functions that get passed to child components, preventing their re-renders unless specified dependencies change.
 */
const UseCallBack = () => {

   const [count, setCount] = useState(0);

    const increment = useCallback(() => {
        setCount((prevCount) => prevCount + 1);
    }, []); // Dependencies array is empty, so it will not change

    return (
        <div>
            <p>Count: {count}</p>
            <button onClick={increment}>Increment</button>
        </div>
    );


}

export default UseCallBack
