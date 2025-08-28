import React, { useEffect, useState } from 'react'

const DataFetcher = () => {
    const [data,setData]=useState([]);
    const [loading,setLoading]=useState(true);
    useEffect(()=>{
        fetch('https://jsonplaceholder.typicode.com/posts')
        .then(response=>response.json())
        .then(data=>{
            setData(data);
            setLoading(false);
        }).catch((err)=>console.log("failed to fetch "+err));
    },[]);
  return (
    <div>
      {
        loading ? (
            <h1>loading...</h1>
        ) : (
            <ul>{
                data.map(post=>{
                   
                   return  ( 
                    <div key={post.id}>
                        <li >{post.title}</li>
                    </div>
                   )
                     
                })
            }</ul>
        )
      }
    </div>
  )
}

export default DataFetcher
