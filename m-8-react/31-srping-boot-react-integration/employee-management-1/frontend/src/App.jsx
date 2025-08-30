import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import NavBar from './NavBar'
import { Route, Routes } from 'react-router-dom'
 

import EmployeeHome from './components/EmployeeHome'
 

function App() {


  return (
    <>
      <NavBar />
      <Routes>
        
        <Route path="home" element={<EmployeeHome />}></Route>
         
      </Routes>
    </>
  )
}

export default App
