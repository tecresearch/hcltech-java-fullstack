import React from 'react'
import { useParams } from 'react-router-dom';

const Student = () => {
    const {id,code}=useParams();
   
  return (
    <div>
        <p>Param: {id}</p>
        <p>Code: {code}</p>
    </div>
  )
}

export default Student
