import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import EventObject from './components/EventObject'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
    <EventObject/>
    </>
  )
}

export default App
