import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import NavBar from './components/NavBar'
import { Route, Routes } from 'react-router-dom'
import Home from './components/Home'
import NotFound from './components/NotFound'
import About from './components/About'
import Contact from './components/Contact'
import Leader from './components/contacts-components/Leader'
import Member from './components/contacts-components/Member'

function App() {

  return (
    <>
      <NavBar />
      <Routes>
        <Route path='*' element={<NotFound />} />
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
        <Route path="/contact" element={<Contact />}>
            <Route path='team/leader' element={<Leader/>}/>
            <Route path='team/members' element={<Member/>}/>
        </Route>
      </Routes>

    </>
  )
}

export default App
