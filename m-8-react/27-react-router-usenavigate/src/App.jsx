import React from 'react'
import { createBrowserRouter, RouterProvider } from 'react-router-dom'
import Home from './components/Home'
import Contact from './components/Contacts'
import About from './components/About'
import Dashboard from './components/Dashboard'
import Navbar from './components/Navbar'
import NotFound from './components/NotFound'
import QuickLinks from './components/QuickLinks'
const router = createBrowserRouter(
  [
    {
      path: "/",
      element: <div>
        <Navbar />
        <Home />
        <QuickLinks />
      </div>
    },
    {
      path: "/about",
      element: <div>
        <Navbar />
        <About />
        <QuickLinks />
      </div>
    },
    {
      path: "/contact",
      element: <div>
        <Navbar />
        <Contact />
        <QuickLinks />
      </div>
    },
    {
      path: "/dashboard",
      element: <div>
        <Navbar />
        <Dashboard />
        <QuickLinks />
      </div>
    },
    {
      path: "/*",
      element:
        <div>
          <NotFound />
          <QuickLinks />
        </div>


    }
  ]
)
const App = () => {
  return (
    <div>
      <RouterProvider router={router} />
    </div>
  )
}

export default App
