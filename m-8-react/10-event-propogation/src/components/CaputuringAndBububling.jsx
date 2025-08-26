import React from 'react';

const CapturingAndBubbling = () => {
  const handleBubble = (e) => {
    console.log('Bubbling Phase');
    console.log('target:', e.target.getAttribute('data-value'));
    console.log('currentTarget:', e.currentTarget.getAttribute('data-value'));
  };

  const handleCapture = (e) => {
    console.log('Capturing Phase');
    console.log('target:', e.target.getAttribute('data-value'));
    console.log('currentTarget:', e.currentTarget);
  };

  return (
    <div>
      <div
        onClick={handleBubble}
        onClickCapture={handleCapture}
        style={{ padding: '20px', border: '2px solid blue' }}
        data-value="Parent Div"
      >
        <button
          onClick={handleBubble}
          onClickCapture={handleCapture}
          style={{ padding: '10px' }}
          data-value="Button"
        >
          Click Me
        </button>
      </div>
    </div>
  );
};

export default CapturingAndBubbling;
