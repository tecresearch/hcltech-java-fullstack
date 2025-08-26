import { useState } from 'react'
import './App.css'
import UseCallBack from './components/UseCallBack'
import UseCallBackD from './components/UseCallBackD';


function App() {

  const [count, setCount] = useState(0);

  return (
    <div>
      <h1>Performance Optimization with useCallback with dependencies</h1>
      <UseCallBackD value={count} />
      <button onClick={() => setCount(count + 1)}>Increment Count</button>
       <h1>Performance Optimization with useCallback without dependencies</h1>
      <UseCallBack/>
    </div>
  );

}

export default App
