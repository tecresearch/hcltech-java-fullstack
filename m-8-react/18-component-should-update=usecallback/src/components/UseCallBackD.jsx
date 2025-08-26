import React, { useCallback } from 'react'

// Child component that only re-renders when its props change
const ChildComponent = React.memo(({ value }) => {
    console.log('ChildComponent rendered');
    return <div>Value: {value}</div>;
});

const UseCallBackD = ({value}) => {
 // useCallback to memoize the function that returns the value
    const memoizedValue = useCallback(() => value, [value]);

    return <ChildComponent value={memoizedValue()} />
}

export default UseCallBackD
