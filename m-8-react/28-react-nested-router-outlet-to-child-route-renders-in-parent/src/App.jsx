import React from 'react'
import { createBrowserRouter, RouterProvider } from 'react-router-dom'
import Home from './components/Home'
import Contact from './components/Contacts'
import About from './components/About'
import Dashboard from './components/Dashboard'
import Navbar from './components/Navbar'
import StudentList from './components/StudentList'
import Student from './components/Student'
 const router=createBrowserRouter(
  [
    {
      path:"/",
      element:<div>
        <Navbar/>
        <Home/>
      </div>
    },
    {
      path:"/about",
      element:<div>
        <Navbar/>
        <About/>
      </div>
    },
    {
      path:"/contact",
      element:<div>
        <Navbar/>
        <Contact/>
      </div>
    },
    {
      path:"/dashboard",
      element:<div>
        <Navbar/>
        <Dashboard/>
      </div>,
      children:[
        {
          path:"students",
          element:<StudentList/>
        },
        {
          path:"student",
          element:<Student/>
        }
      ]
    }
  ]
)
const App = () => {
  return (
    <div>
      <RouterProvider router={router}/>
    </div>
  )
}

export default App
