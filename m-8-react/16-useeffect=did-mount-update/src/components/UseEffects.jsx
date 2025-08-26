import React, { useEffect, useState } from 'react'

const UseEffects = () => {

    const [users,setUsers]=useState([]);
    const [loading,setLoading]=useState(true);

    useEffect(()=>{
        async function fetchUsers(){
            try {
                const res=await fetch("https://jsonplaceholder.typicode.com/users");
                const data=await res.json();
                setUsers(data);

            } catch (error) {
                console.log(error);
            }finally{
               setLoading(false);
            }
        }
        fetchUsers();
    },[])

    if(loading)return <p>Loading users.....</p>;

  return (
    <>
        <h1>useEffect Example</h1>
        <ul>
            {users?.map(user=><li key={user.id}>{user.name}</li>)}
        </ul>
    </>
  )
}

export default UseEffects
