import React, { useState } from 'react';

export function Card({ title="Brijesh", description="About", imageUrl="null", like="50" }) {
  const [count, setCount] = useState(0);

  return (
    <div className="w-[300px] rounded-md border">
      <img
        src={imageUrl}
        alt={title}
        className="h-[200px] w-full rounded-md object-cover"
      />
      <div className="p-4">
        <h1 className="text-lg font-semibold">{title}</h1>
        <p className="mt-3 text-sm text-gray-600">
          {description}
        </p>
        <button
          type="button"
          onClick={() => setCount(count + 1)}
          className="mt-4 rounded-sm bg-black px-2.5 py-1 text-[10px] font-semibold text-white shadow-sm hover:bg-black/80"
        >
          Likes {count}
        </button>
      </div>
    </div>
  );
}
