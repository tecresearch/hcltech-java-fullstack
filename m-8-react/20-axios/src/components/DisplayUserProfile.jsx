import React, { useEffect, useState } from 'react';

const UserProfileDisplay = () => {
    const [userProfile, setUserProfile] = useState(null);

    useEffect(() => {
        // Get user data from localStorage
        const storedUserProfile = localStorage.getItem('userProfile');
        if (storedUserProfile) {
            setUserProfile(JSON.parse(storedUserProfile));
        }
    }, []);

    return (
        <div>
            {userProfile ? (
                <div>
                    <h1>User Profile</h1>
                    <p>Name: {userProfile.name}</p>
                    <p>Email: {userProfile.email}</p>
                    <p>Country: {userProfile.country}</p>
                </div>
            ) : (
                <h1>No User Profile Available</h1>
            )}
        </div>
    );
};

export default UserProfileDisplay;
