import React, { useState } from 'react'

const Login = (props) => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const HandleLogin = (event) => {
    event.preventDefault()
    console.log(event)
    console.log(event.target[0].value)
    props.setUser(
      {
        username,
        password
      }
    )

    props.setLoggedInt(true);

  }
  return (
    <div>

      <form onSubmit={HandleLogin}>
        <caption><sup>{username}</sup></caption>
        <input type='text' placeholder="Username" value={username} onChange={(e) => setUsername(e.target.value)} />
        <br></br>
        <input type='password' placeholder="Password" value={password} onChange={(e) => setPassword(e.target.value)} /><br></br>
        <button >Submit</button>
      </form>

    </div>
  )
}

export default Login
