import React, { useContext } from 'react'
import { UserContext,ThemeContext } from '../App'

const UserProfile = () => {
    const  {user,setUser}=useContext(UserContext);
    const {theme,setTheme}=useContext(ThemeContext);
const toggleTheme=()=>{
    if(theme==='light'){
        setTheme('black');
        setUser({username:'Dark User',
            password:'Dark Password'})
    }else{
        setTheme('light')
         setUser({username:'Light User',
            password:'Light Password'})
    }
}
  return (
    <div  style={{
            color:theme==='light'?'black':'white'
          }}>
    <h4>{user.username}</h4>
     <h4>{user.password}</h4>
      <button onClick={toggleTheme} 
      style={{
            backgroundColor:theme==='light'?'black':'white',
             color:theme==='light'?'white':'black'
          }}
       >Theme {theme}</button>
      
    </div>
  )
}

export default UserProfile
