import React from 'react'

const Dashboard = (props) => {


  const handleLoggedUser = () => {
    props.setLoggedInt(false)
  }
  return (
    <div>
      <h4>{props.user.username} :: Loggedin</h4>
      <button onClick={handleLoggedUser}> LogOut</button>
    </div>
  )
}

export default Dashboard
