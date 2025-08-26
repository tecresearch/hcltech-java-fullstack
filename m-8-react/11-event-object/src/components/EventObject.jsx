import React from 'react'

const EventObject = () => {
    {
        /**
         * Property/Method	Description
    e.target	The actual DOM element that triggered the event
    e.currentTarget	The element the event handler is attached to
    e.type	Type of the event (e.g., "click", "change")
    e.preventDefault()	Prevents default browser behavior
    e.stopPropagation()	Stops the event from bubbling up
    e.nativeEvent	Access the original browser event
         */
    }



    const handleEvents = (e) => {
        const eventType = e.type
        const target = e.target
        const currentTarget = e.currentTarget

        console.log('Event type:', eventType); // e.g., "click"
        console.log('Target element value:', target); // DOM element that triggered the event
        console.log('Current target:', currentTarget); // Element the handler is bound to
        e.preventDefault(); // Prevent default behavior

        switch(eventType){
            case 'click':
                console.log('Clicked: ',target.textContent);
                break;
            case 'change':
                console.log('Changed Value: ',target.value);
                break;
            case 'keydown':
                console.log('Key Pressed', e.key);
                break;
            case 'submit':
                e.preventDefault();

                const formData=new FormData(e.target);
                const data=Object.fromEntries(formData.entries());
                console.log('Form submitted with data: ',data);
                break;
            default:
                console.log('Unhandled event: ',eventType);
        }

    }

    return (
        <>
            <h1>All About Event Object</h1>


            {/* Click Event */}
            <button onClick={handleEvents}>Click Me</button>

            {/* Change & Keydown Events */}
            <input
                type="text"
                onChange={handleEvents}
                onKeyDown={handleEvents}
                placeholder="Type something"
            />

            {/* Submit Event */}
            <form onSubmit={handleEvents}>
                <input type="text" name="username" />
                <input type="password" name="password" />
                <button type="submit">Submit</button>
            </form>



        </>
    )
}

export default EventObject
