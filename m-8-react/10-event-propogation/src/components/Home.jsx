import React, { useState } from 'react';
import CaputuringAndBububling from './CaputuringAndBububling';


const Home = () => {
    {/*   event propagation refers to how events travel through the DOM tree. 
    React follows the standard DOM event propagation model, which includes three phases:

// 🔁 Event Propagation Phases
// Capturing Phase (also called "trickling down"):

// The event starts from the root and travels down to the target element.
// In React, you can listen to this phase using onClickCapture, onMouseDownCapture, etc.
// Target Phase:

// The event reaches the target element (the one that was actually interacted with).
// Bubbling Phase:

// The event bubbles up from the target element back to the root.
// This is the default phase React listens to using onClick, onMouseDown, etc.*/
    }

    return (
        <>

            <div
                onClick={() => console.log('Parent clicked')}
                onClickCapture={() => console.log('Parent capture')}
            >
                <button
                    onClick={(e) => console.log('Button clicked'+e.stopPropagation())}
                    onClickCapture={() => console.log('Button capture')}
                    
                >
                    Click Me1
                </button>
            </div>
            <CaputuringAndBububling/>

        </>
    )



};

export default Home;
