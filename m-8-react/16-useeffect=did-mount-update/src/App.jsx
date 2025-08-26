import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import UseEffects from './components/UseEffects'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
      <UseEffects/>
    </>
  )
}

export default App
