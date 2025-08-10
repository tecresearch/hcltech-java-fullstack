import { useState } from 'react'
import './App.css'
import UserCard from './components/UserCard'
import brijeshPic from './assets/brijesh.png'
import gemsPic from './assets/gems.png'
import bajarnePic from './assets/bajarne.png'
import LikeCounter from './components/LikeCounter'

function App() {

  const [count1, setCount1] = useState(0);
  const [count2, setCount2] = useState(0);
  const [count3, setCount3] = useState(0);

  function handleLike1(){
    setCount1(count1+1);
  }
   function handleLike2(){
    setCount2(count2+1);
  }
   function handleLike3(){
    setCount3(count3+1);
  }
  return (
    <>
      <div className='container'>
        <UserCard name="Bajarne" image={bajarnePic} role="SDE" designation="C++ Developer">
          <p1>
            <hr />
            C++ Founder  {/* JSX as props */}
            <hr />
          </p1>
          {/* component and function as props */}
          <LikeCounter handleClick={handleLike1}  like={count1}/>
        </UserCard>

        <UserCard name="Gems Goslim" image={gemsPic} role="SDE" designation="Java  Developer">
          <p1><hr />
            Java Founder {/* JSX as props */}
            <hr />
          </p1>
            {/* component and function as props */}
           <LikeCounter handleClick={handleLike2}  like={count2}/>
        </UserCard>
        <UserCard name="Brijesh Nishad" image={brijeshPic} role="SDE" designation="Java FullStack Developer">
          <p1>
            <hr />
            C++ and Java Developer {/* JSX as props */}
            <hr />
          </p1>
            {/* component and function as props */}
            <LikeCounter handleClick={handleLike3}  like={count3}/>
        </UserCard>
      </div>

    </>
  )
}

export default App
