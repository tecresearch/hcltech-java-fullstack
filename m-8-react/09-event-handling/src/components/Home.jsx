import React, { useState } from 'react';

const Home = () => {
    const [inputValue, setInputValue] = useState('');
    const [isDisabled, setIsDisabled] = useState(true);

    // Event for button click
    const handleClick = (e) => {
        const info = {
            "message": "Clicked ",
            "Event": e
        };
        console.log(info);
    }

    // Event for mouse over
    const handleMouseOver = (e) => {
        setIsDisabled(false);
        console.log({
            "message": "Mouse Overed ",
            "Event": e
        });
    }

    // Event for mouse out
    const handleMouseOut = (e) => {
        setIsDisabled(true);
        console.log({
            "message": "Mouse Out ",
            "Event": e
        });
    }

    // Event for input change
    const handleChange = (e) => {
        setInputValue(e.target.value);
        console.log({
            "message": "Input Changed", 
            "value": e.target.value
        });
    }

    // Event for input focus
    const handleFocus = () => {
        console.log({ "message": "Input Focused" });
    }

    // Event for input blur
    const handleBlur = () => {
        console.log({ "message": "Input Blurred" });
    }

    // Event for form submission
    const handleSubmit = (e) => {
        e.preventDefault(); // Prevent the default form submission
        console.log({
            "message": "Form Submitted",
            "inputValue": inputValue
        });
        // Here you can handle form data (send to server, etc.)
        setInputValue(''); // Reset the input field after submission
    }

    return (
        <>  
            <button onClick={handleClick}>Click Me</button>
            <button
                value="Value"
                onMouseOver={handleMouseOver}
                onMouseOut={handleMouseOut}
                disabled={isDisabled}
            >
                Mouse Over/Out
            </button>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    value={inputValue}
                    onChange={handleChange}
                    onFocus={handleFocus}
                    onBlur={handleBlur}
                    placeholder="Type something..."
                />
                <button type="submit">Submit</button>
            </form>
        </>
    );
};

export default Home;
