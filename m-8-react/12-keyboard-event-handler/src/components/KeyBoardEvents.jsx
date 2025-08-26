import React from 'react'

const KeyBoardEvents = () => {

    const handleEnter = (e) => {
        if (e.code === 'Enter') {
            alert("Your message is: " + e.target.value);
        }

        if (e.code === 'Escape') {
            alert("Are you sure you don't want to submit?");
        }
    };


    const handleEvents = (e) => {

        if (e.type === 'keydown') {


            const key = e.key;
            const value = e.target.value;
            const ctrl = e.ctrlKey;
            const shift = e.shiftKey;
            const alt = e.altKey;
            const meta = e.metaKey; // Cmd on Mac

            console.log(`Key Pressed: ${key}`);
            console.log(`Target Value: ${value}`);
            console.log(`Modifiers: Ctrl=${ctrl}, Shift=${shift}, Alt=${alt}, Meta=${meta}`);


            console.log('Key:', e.key);           // e.g., "a", "Enter", "Shift"
            console.log('Code:', e.code);         // e.g., "KeyA", "Enter", "ShiftLeft"
            console.log('KeyCode:', e.keyCode);   // Legacy numeric code (0–255)
            console.log('Ctrl:', e.ctrlKey);
            console.log('Alt:', e.altKey);
            console.log('Shift:', e.shiftKey);
            console.log('Meta:', e.metaKey);      // Cmd on Mac


            // Example: Detect Ctrl + Shift + Z
            if (e.ctrlKey && e.shiftKey && e.key.toLowerCase() === 'z') {
                console.log('Shortcut: Ctrl + Shift + Z');
            }

            // Example: Escape key
            if (e.key === 'Escape') {
                console.log('Escape pressed — clearing input');
                e.target.value = ''; // Clears the input box directly
            }


            // Example: Ctrl + S
            if (ctrl && key.toLowerCase() === 's') {
                e.preventDefault();
                console.log('Shortcut: Ctrl + S');
            }


            // Example: Shift + A
            if (shift && key.toLowerCase() === 'a') {
                console.log('Shortcut: Shift + A');
            }

            // Example: Alt + Enter
            if (alt && key === 'Enter') {
                console.log('Shortcut: Alt + Enter');
            }


            // Example: Just Enter
            if (!ctrl && !shift && !alt && key === 'Enter') {
                console.log('Enter pressed without modifiers');
            }


            if (key === 'Escape') {

                console.log('Escape pressed ')

            }

        }
    }




    return (
        <div>
            <h2>Enter your messege</h2>
            <input type='text' name="messege" onChange={(e) => console.log(e.target.value)}
                onKeyDown={handleEnter}
            />


            <input
                type="text"
                onKeyDown={handleEvents}
                placeholder="Try Ctrl+S, Shift+A, Alt+Enter"
            />

        </div>
    )
}

export default KeyBoardEvents
