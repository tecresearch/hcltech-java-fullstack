import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import NavBar from './NavBar'
import { Route, Routes } from 'react-router-dom'
 

import EmployeeHome from './components/EmployeeHome'
import StateClassComponent from './components/StateClassComponent'
 

function App() {


  return (
    <>
      <NavBar />
      <Routes>
        
        <Route path="/home" element={<EmployeeHome />}>
          <Route path="count" element={<StateClassComponent/>}/>
        </Route>
         
      </Routes>
    </>
  )
}

export default App
