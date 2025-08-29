import React, { useState } from 'react'

function Search({setInput}) {
  
      const handleSearch=(e)=>{
          setInput(e.target.value);
      }
    return (
      <input
       data-testid="filterInput" 
        className="large"
        placeholder="Enter Country Name"
        onChange={handleSearch}
        />
  	);
}

export default Search;
