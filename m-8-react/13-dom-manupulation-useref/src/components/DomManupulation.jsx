import React, { useRef } from 'react'

const DomManupulation = () => {
  const inputRef = useRef(null);
  const boxRef = useRef(null);

  const handleKeyDown = (e) => {
    const key = e.key;
    const code = e.code;'Enter'
    const keyCode = e.keyCode;

    console.log(`Key: ${key}, Code: ${code}, KeyCode: ${keyCode}`);

    // DOM Manipulation: Change background on Enter
    if (key === 'Enter') {
      boxRef.current.style.backgroundColor = 'lightgreen';
      boxRef.current.textContent = `You pressed Enter. Value: ${inputRef.current.value}`;
      inputRef.current.value = ''; // Clear input
    }

     if (e.shiftKey) {
      boxRef.current.style.backgroundColor = 'pink';
      boxRef.current.textContent = `You pressed shift . Value: ${inputRef.current.value}`;
      inputRef.current.value = 'Shift'; // Clear input
    }

    // DOM Manipulation: Reset on Escape
    if (key === 'Escape') {
      boxRef.current.style.backgroundColor = 'lightcoral';
      boxRef.current.textContent = 'Input cleared with Escape';
      inputRef.current.value = '';
    }

    // Example: Ctrl + Shift + Z
    if (e.ctrlKey && e.shiftKey && key.toLowerCase() === 'z') {
      boxRef.current.style.backgroundColor = 'lightblue';
      boxRef.current.textContent = 'Shortcut: Ctrl + Shift + Z';
    }
  };

  return (
    <div>
    <h1>Dom Manupulation : useRef Hook</h1>
      <input
        type="text"
        ref={inputRef}
        onKeyDown={handleKeyDown}
        placeholder="Press any key"
      />
      <div
        ref={boxRef}
        style={{
          marginTop: '20px',
          padding: '10px',
          border: '1px solid #ccc',
          minHeight: '50px',
        }}
      >
        Press a key to see DOM changes
      </div>
    </div>
  );
}

export default DomManupulation
