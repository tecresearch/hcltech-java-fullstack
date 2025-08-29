import React from 'react';

const UserProfile = ({ formData, sortedData ,mapData}) => {
    console.log(sortedData);
    return (
        <div className='mt-4 p-4 border rounded-lg bg-gray-100'>
            <h2 className='text-xl font-bold'>User Profile</h2>
            <p><strong>Username:</strong> {formData.username}</p>
            <p><strong>Email:</strong> {formData.email}</p>
            {/* Optionally avoid showing password */}
            <p><strong>Password:</strong> *********</p>
            <p>Sorted Attribute</p>
           {
            sortedData?.map((attribute,index)=>{
                return <p key={index}>
                <p><strong>[{index}]</strong> {attribute}</p>

            </p>
            })
           }
              <p>mapData </p>
           {
            mapData?.map((attribute,index)=>{
                return <p key={index}>
                <p><strong>[{index}]</strong> {attribute}</p>

            </p>
            })
           }
        </div>
    );
};

export default UserProfile;
