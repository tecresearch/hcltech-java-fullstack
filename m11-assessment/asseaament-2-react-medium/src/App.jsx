import { useState } from 'react'
import './App.css'
import UserCard from './components/UserCard'
import brijeshPic from './assets/brijesh.png'
import gemsPic from './assets/gems.png'
import bajarnePic from './assets/bajarne.png'
import LikeCounter from './components/LikeCounter'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
     <div className='container'>
      <UserCard name="Bajarne" image={bajarnePic} role="SDE" designation="C++ Developer"/>
      <UserCard name="Gems Goslim" image={gemsPic} role="SDE" designation="Java  Developer"/>
      <UserCard name="Brijesh Nishad" image={brijeshPic} role="SDE" designation="Java FullStack Developer"/>
     </div>
     <div className='container'>
        <LikeCounter/>
     </div>
    </>
  )
}

export default App
