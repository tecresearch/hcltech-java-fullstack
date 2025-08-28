import React, { useState } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';
const CounterUseState = () => {
    // Initialize state with useState
    const [count, setCount] = useState(0);

    return (
        <div>
            <h1>Using UseState</h1>
            <h1 className='text-decoration-underline text-primary '>Count: {count}</h1>
            <button className='btn btn-primary' onClick={() => setCount(count + 1)}>Increment</button>
            <button className='btn btn-danger' onClick={() => setCount(count - 1)}>Decrement</button>
            <button className='btn btn-warning' onClick={() => setCount(0)}>Reset</button>
        </div>
    );
};

export default CounterUseState;
