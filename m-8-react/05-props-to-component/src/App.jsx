import { useState } from 'react'
import './App.css'
import UserCard from './components/UserCard'
import brijeshPic from './assets/brijesh.png'
import gemsPic from './assets/gems.png'
import bajarnePic from './assets/bajarne.png'

function App() {
  const [count, setCount] = useState(0)

  return (
    <>
     <div className='container'>
        {/* component should be render here with : name role designation and image fields*/}
        <UserCard  name='Bajarne' imageSrc={bajarnePic} role="SDE"  designation="C++ Developer"/>
        <UserCard  name='Gems Goslim' imageSrc={gemsPic}  role="SDE" designation="Java Developer"/>
        <UserCard  name='Brijesh' imageSrc={brijeshPic} role="SDE" designation="Java FullStack Developer" />
     </div>
    </>
  )
}

export default App
