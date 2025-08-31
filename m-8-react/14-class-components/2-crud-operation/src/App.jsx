import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Form from './components/Form'

function App() {
 

  return (
    <>
   
   <div >
      <h1 className='text-2xl flex justify-center font-bold'>Task Manager</h1>
      <Form/>
      
   </div>
      
    </>
  )
}

export default App
