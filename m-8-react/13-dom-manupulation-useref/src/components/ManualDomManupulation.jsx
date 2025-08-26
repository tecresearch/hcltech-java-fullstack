import React, { useEffect } from 'react'

const ManualDomManupulation = () => {
    useEffect(() => {
    const input = document.getElementById('manualInput');
    const output = document.getElementById('outputBox');

    const handleKeyDown = (e) => {
      const key = e.key;
      const code = e.code;
      const keyCode = e.keyCode;

      console.log(`Key: ${key}, Code: ${code}, KeyCode: ${keyCode}`);

      // Alt + Enter
      if (e.altKey && key === 'Enter') {
        output.textContent = 'You pressed Alt + Enter';
        output.style.backgroundColor = 'lightblue';
      }

      // Escape
      if (key === 'Escape') {
        input.value = '';
        output.textContent = 'Input cleared with Escape';
        output.style.backgroundColor = 'lightcoral';
      }

      // Enter
      if (key === 'Enter' && !e.altKey) {
        output.textContent = `You pressed Enter. Value: ${input.value}`;
        output.style.backgroundColor = 'lightgreen';
        input.value = '';
      }

      // Ctrl + Shift + Z
      if (e.ctrlKey && e.shiftKey && key.toLowerCase() === 'z') {
        output.textContent = 'Shortcut: Ctrl + Shift + Z';
        output.style.backgroundColor = 'orange';
      }
    };

    input.addEventListener('keydown', handleKeyDown);

    // Cleanup
    return () => {
      input.removeEventListener('keydown', handleKeyDown);
    };
  }, []);

  return (
    <div>
    <h1>Dom Manupulation : Manual</h1>
      <input
        type="text"
        id="manualInput"
        placeholder="Type and press keys"
      />
      <div
        id="outputBox"
        style={{
          marginTop: '20px',
          padding: '10px',
          border: '1px solid #ccc',
          minHeight: '50px',
        }}
      >
        Output will appear here
      </div>
    </div>
  );
}

export default ManualDomManupulation
