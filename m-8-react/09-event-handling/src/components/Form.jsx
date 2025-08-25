import React, { useState } from 'react';

const Home = () => {
    const [formData, setFormData] = useState({
        firstName: '',
        lastName: '',
        email: ''
    });
    const [isDisabled, setIsDisabled] = useState(true);

    // Inline styles for buttons and input fields
    const buttonStyle = {
        padding: '10px 15px',
        margin: '5px',
        backgroundColor: '#007bff',
        color: '#fff',
        border: 'none',
        borderRadius: '5px',
        cursor: 'pointer'
    };

    const inputStyle = {
        width: '100%',
        padding: '10px',
        margin: '5px 0',
        border: '1px solid #ccc',
        borderRadius: '4px'
    };

    const handleClick = (e) => {
        const info = { "message": "Clicked ", "Event": e };    
        console.log(info);
    }

    const handleMouseOver = (e) => {
        setIsDisabled(false);
        console.log({ "message": "Mouse Overed ", "Event": e });
    }

    const handleMouseOut = (e) => {
        setIsDisabled(true);
        console.log({ "message": "Mouse Out ", "Event": e });
    }

    // Event for managing input changes (manual setting)
    const handleChange = (e) => {
        const { name, value } = e.target;
        // setFormData({...setFormData,[name]:value})
        if (name === 'firstName') {
            setFormData({ firstName: value, lastName: formData.lastName, email: formData.email });
        } else if (name === 'lastName') {
            setFormData({ firstName: formData.firstName, lastName: value, email: formData.email });
        } else if (name === 'email') {
            setFormData({ firstName: formData.firstName, lastName: formData.lastName, email: value });
        }
        console.log({ "message": "Input Changed", "field": name, "value": value });
    }

    const handleSubmit = (e) => {
        e.preventDefault(); // Prevent default form submission
        console.log({
            "message": "Form Submitted",
            "formData": formData
        });
        // Reset form data after submission
        setFormData({ firstName: '', lastName: '', email: '' });
    }

    return (
        <>  
            <button style={buttonStyle} onClick={handleClick}>Click Me</button>
            <button
                value="Value"
                onMouseOver={handleMouseOver}
                onMouseOut={handleMouseOut}
                disabled={isDisabled}
                style={buttonStyle}
            >
                Mouse Over/Out
            </button>
            <form onSubmit={handleSubmit}>
                <input
                    type="text"
                    name="firstName"
                    value={formData.firstName}
                    onChange={handleChange}
                    placeholder="First Name"
                    style={inputStyle}
                />
                <input
                    type="text"
                    name="lastName"
                    value={formData.lastName}
                    onChange={handleChange}
                    placeholder="Last Name"
                    style={inputStyle}
                />
                <input
                    type="email"
                    name="email"
                    value={formData.email}
                    onChange={handleChange}
                    placeholder="Email Address"
                    style={inputStyle}
                />
                <button type="submit" style={buttonStyle}>Submit</button>
            </form>
        </>
    );
};

export default Home;
