import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import UserUpdateProfile from './components/UserUpdateProfile'
import UserProfileDisplay from './components/DisplayUserProfile'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
     <UserUpdateProfile/>
   
    </>
  )
}

export default App
