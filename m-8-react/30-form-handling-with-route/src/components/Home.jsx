import React, { useState } from 'react'
import UserProfile from './UserProfile';

const Home = () => {

  const [formData, setFormData] = useState({
    username: '',
    email: '',
    password: ''

  })

    const [searchQuery, setSearchQuery] = useState('');
    const [sortedData,setSortedData]=useState([]);
    const [mapData,setMapData]=useState([]);

  const handleChange = (e) => {

    console.log(e.target);
    const { name, value } = e.target;
    setFormData({ ...formData, [name]: value });
  }

  const handleSearchChange = (e) => {
    setSearchQuery(e.target.value);
  };

  const handleSubmit = (e) => {
    e.preventDefault();
    console.log(e.target);
    console.log("submited form data:", formData);

    Object.entries(formData).forEach(([key, value]) => {
      console.log(`Key is ${key}: value is ${value}`)
    });

    Object.keys(formData).forEach((key) => {
      console.log(`${key}: ${formData[key]}`);
    })
    console.log("Submitted form data :", formData);
    for (let key in formData) {
      if (formData.hasOwnProperty(key)) { // Check if the key is a property of formData
        console.log(`${key}: ${formData[key]}`);
      }
    }


     // Iterate and filter the formData based on search query
    Object.entries(formData).forEach(([key, value]) => {
      if (value.toString().toLowerCase().includes('brijesh')) {
        console.log(`Matching ${key}: ${value}`);
      }
    });



    // Operations
    // 1. Filtering based on search query
    console.log('Filtered Results:');
    Object.entries(formData).forEach(([key, value]) => {
      if (value.toString().toLowerCase().includes(searchQuery.toLowerCase())) {
        console.log(`Matching ${key}: ${value}`);
      }
    });

    // 2. Sorting the keys of formData
    const sortedKeys = Object.keys(formData).sort();
    setSortedData(sortedKeys);
    console.log('Sorted Keys:', sortedKeys);

    // 3. Mapping formData to an array
    const mappedData = Object.entries(formData).map(([key, value]) => {
      return `${key.toUpperCase()}: ${value}`;
    });
    setMapData(mappedData);
    console.log('Mapped Data:', mappedData);

    // 4. Removing a specific key (e.g., password)
    const { password, ...remainingData } = formData;
    console.log('Data After Removing Password:', remainingData);

    // 5. Updating a value (e.g., appending a suffix to username)
    const updatedFormData = {
      ...formData,
      username: formData.username + ' (updated)',
    };
    console.log('Updated Form Data:', updatedFormData);
  }

  return (
    <div className='p-10'>
      <div className='max-w-md mx-auto p-4 border rounded-lg shadow-md bg-white'>
        <h2 className='text-xl font-bold mb-4'>Sign Up</h2>
        <form onSubmit={handleSubmit}>
          <div className='mb-4'>
            <label className='block text-gray-700'>Username:</label>
            <input
              type='text'
              name='username'
              value={formData.username}
              onChange={handleChange}
              required
              className='mt-1 block w-full p-2 border border-gray-300 rounded focus:outline-none focus:ring focus:ring-blue-400'
            />
          </div>
          <div className='mb-4'>
            <label className='block text-gray-700'>Email:</label>
            <input
              type='email'
              name='email'
              value={formData.email}
              onChange={handleChange}
              required
              className='mt-1 block w-full p-2 border border-gray-300 rounded focus:outline-none focus:ring focus:ring-blue-400'
            />
          </div>
          <div className='mb-4'>
            <label className='block text-gray-700'>Password:</label>
            <input
              type='password'
              name='password'
              value={formData.password}
              onChange={handleChange}
              required
              className='mt-1 block w-full p-2 border border-gray-300 rounded focus:outline-none focus:ring focus:ring-blue-400'
            />
          </div>
          <div className='mb-4'>
          <label className='block text-gray-700'>Search:</label>
          <input
            type='text'
            value={searchQuery}
            onChange={handleSearchChange}
            placeholder='Search form data...'
            className='mt-1 block w-full p-2 border border-gray-300 rounded focus:outline-none focus:ring focus:ring-blue-400'
          />
        </div>
          <button
            type='submit'
            className='w-full bg-blue-500 text-white font-bold py-2 rounded hover:bg-blue-600 transition duration-300'
          >
            Submit
          </button>
        </form>
      </div>
      {/* Render UserProfile if form data is submitted */}
      {formData && <UserProfile formData={formData} sortedData={sortedData} mapData={mapData}/>}
    </div>
  )
}

export default Home
