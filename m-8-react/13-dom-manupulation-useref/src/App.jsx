import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import DomManupulation from './components/DomManupulation'
import ManualDomManupulation from './components/ManualDomManupulation'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <DomManupulation/>
      <ManualDomManupulation/>
    </>
  )
}

export default App
