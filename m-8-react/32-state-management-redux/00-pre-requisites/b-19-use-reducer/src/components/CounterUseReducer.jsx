import React, { useReducer } from 'react';
import 'bootstrap/dist/css/bootstrap.min.css';

// Initial state
const initialState = { count: 0 };

// Reducer function to handle state changes
const reducer = (state, action) => {
    switch (action.type) {
        case 'increment':
            return { count: state.count + 1 };
        case 'decrement':
            return { count: state.count - 1 };
        case 'reset':
            return { count: 0 };
        default:
            throw new Error();
    }
};

const CounterUseReducer = () => {
    // Use useReducer instead of useState
    const [state, dispatch] = useReducer(reducer, initialState);

    return (
        <div>
            <h1>Using UseReducer</h1>
            <h1 className='text-decoration-underline text-primary '>Count: {state.count}</h1>
            <button className='btn btn-primary' onClick={() => dispatch({ type: 'increment' })}>Increment</button>
            <button className='btn btn-danger' onClick={() => dispatch({ type: 'decrement' })}>Decrement</button>
            <button className='btn btn-warning' onClick={() => dispatch({ type: 'reset' })}>Reset</button>
        </div>
    );
};

export default CounterUseReducer;
