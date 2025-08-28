import React, { useEffect, useState } from 'react';
import UserUpdateProfile from './UserUpdateProfile';

const UserNotFound = ({ id }) => {


    return (
        <div className='container mt-4'>
            <h1 className='text-danger'>User Not Found</h1>
            <p>No user found with ID: <strong>{id}</strong></p>
        </div>
    );
};

export default UserNotFound;
