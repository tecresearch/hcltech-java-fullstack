import React, { useEffect, useState } from 'react'
import CustomerList from './CustomerList'
import List from '../List';

function SearchCustomer() {
  const [filteredList, setFilteredList] = useState([]);
  const [input, setInput] = useState("");
  useEffect(()=>{
    const filterCustomers = List.filter((customer) => {
      return customer.name.startsWith(input) || customer.location.startsWith(input);
    });
    setFilteredList(filterCustomers);
  },[input]);

  return (
    <>
      <div className='layout-row align-items-center justify-content-center mt-30'>
        <input
          type='text'
          className='large mx-20 w-20'
          data-testid='search-input'
          value={input}
          placeholder='Enter search term (Eg: Phil)'
          onChange={(e)=>setInput(e.target.value)}
        />
      </div>
      <CustomerList customers={input===""?List:filteredList} />
    </>
  )
}

export default SearchCustomer