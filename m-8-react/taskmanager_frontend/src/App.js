import React from 'react'

import Home from './pages/Home'
import AllTasks from './pages/AllTasks'
import CompletedTasks from './pages/CompletedTasks'
import ImportantTasks from './pages/ImportantTasks'
import IncompletedTask from './pages/IncompletedTask'
import {BrowserRouter as Router ,Routes,Route} from 'react-router-dom'
import Signup from './pages/Signup'
import Login from './pages/Login'

function App() {
  return (
    <div className="bg-gray-900 text-white h-screen p-2 relative ">
     <Router>
        <Routes>
          <Route exact path="/" element={<Home/>} >
              <Route index element={<AllTasks/>}/>
              <Route path="/completedTasks" element={<CompletedTasks/>}/>
              <Route path="/importantTasks" element={<ImportantTasks/>}/>
              <Route path="/incompletedTasks" element={<IncompletedTask/>}/>
          </Route>
          <Route path="/signup" element={<Signup/>}/> 
          <Route path="/login" element={<Login/>}/> 
        </Routes>
      </Router>
    </div>
  )
}

export default App