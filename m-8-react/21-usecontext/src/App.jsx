import { createContext, useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import UserProfile from './components/UserProfile';
const UserContext = createContext();
const ThemeContext = createContext();
function App() {

  const [user, setUser] = useState({
    username: "Brijesh Nishad",
    password: "Tca@admin"
  });
  const [theme,setTheme]=useState('light');


  return (
    <>
      <UserContext.Provider value={{ user, setUser }} >
        <ThemeContext.Provider value={{theme,setTheme}}>
          <div id='container' style={{
            backgroundColor:theme==='light'?'white':'black'
          }}>
            <UserProfile />
          </div>
        </ThemeContext.Provider>
      </UserContext.Provider>
    </>
  )
}

export default App
export { UserContext }
export { ThemeContext }
