import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import CounterUseState from './components/CounterUseState'
import CounterUseReducer from './components/CounterUseReducer'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
    
    <CounterUseState/>
    <CounterUseReducer/>
       
    </>
  )
}

export default App
