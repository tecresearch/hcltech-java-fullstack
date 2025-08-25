import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Dashboard from './components/Dashboard';
import Login from './components/Login';

function App() {

  const [isLoggedIn, setLoggedInt] = useState(true);
  const [user, setUser] = useState(
    {
      "username": '',
      "password": ''
    }
  )

  if (user.username === '' || user.password === '') {
    return <Login
      setLoggedInt={setLoggedInt}
      setUser={setUser}
    />
  }


  return (
    <>
      {isLoggedIn && (
        <Dashboard
          isLoggedIn={isLoggedIn}
          setLoggedInt={setLoggedInt}
          user={user}
          setUser={setUser}
        />
      )}
      {!isLoggedIn && (
        <Login
          setLoggedInt={setLoggedInt}
          setUser={setUser}
        />
      )}
    </>
  );



  // return (<>
  //   {
  //     isLoggedIn ?
  //                 <Dashboard isLoggedIn={isLoggedIn} setLoggedInt={setLoggedInt} user={user} setUser={setUser}/>
  //                 :<Login isLoggedIn={isLoggedIn} setLoggedInt={setLoggedInt}  user={user} setUser={setUser}/>
  //   }
  //   </>
  // )

  // if(isLoggedIn){
  // return <Dashboard isLoggedIn={isLoggedIn} setLoggedInt={setLoggedInt} user={user} setUser={setUser}/>
  // }else{
  //   return <Login isLoggedIn={isLoggedIn} setLoggedInt={setLoggedInt}  user={user} setUser={setUser}/>
  // }

}

export default App
