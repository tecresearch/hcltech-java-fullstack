import React, { useEffect, useState } from 'react';
import { createUser, deleteUser, fetchUser, patchUser, updateUser } from './api';
import 'bootstrap/dist/css/bootstrap.min.css';
import UserNotFound from './UserNotFound';

const UserUpdateProfile = () => {
    const [name, setName] = useState("");
    const [email, setEmail] = useState("");
    const [country, setCountry] = useState("");
    const [loading, setLoading] = useState(true);
    const [id, setId] = useState(2);
    const [userNotFound, setUserNotFound] = useState(false);

    // Example usage
    const userId = 1;
    const newUser = { name: "John Doe", email: "john@example.com" };

    createUser(newUser).then(response => {
        console.log("Created User:", response.data);
    });

    fetchUser(userId).then(response => {
        console.log("Fetched User:", response.data);
    });

    updateUser(userId, { name: "Jane Doe" }).then(response => {
        console.log("Updated User:", response.data);
    });

    deleteUser(userId).then(response => {
        console.log(`Deleted User with ID ${userId}`);
    });

    patchUser(userId, { email: "jane@example.com" }).then(response => {
        console.log("Patched User:", response.data);
    });


    const handleIdInputToFetch = () => {
        setLoading(true); // set loading to true before fetching

        fetchUser(id)
            .then((response) => {
                const data = response.data;
                setName(data.name || "");
                setEmail(data.email || "");
                setCountry(data.address?.city || "");
            })
            .catch((err) => {
                console.log("something went wrong " + err);

                setUserNotFound(true); // Set not found state
                return;

            })
            .finally(() => setLoading(false));

    }


    const UpdateUserHandle = (e) => {
        e.preventDefault();
        const formData = new FormData(e.target);
        const data = Object.fromEntries(formData);
        console.log(data);
        localStorage.setItem("userProfile", JSON.stringify(data)); // Ensure key is 'userProfile' for consistency
        alert("Updated User Profile");
    };

    return (
        <div>

            {loading ? (

                <div>

                    <input type='number' name='id' placeholder="ID to be updated"
                        value={id}
                        onChange={(e) => setId(Number(e.target.value))} // Convert to number
                    />
                    <button className='btn btn-warning ' onClick={handleIdInputToFetch}>Data Load</button>
                </div>

            ) : userNotFound ? (
                <UserNotFound id={id} />
            ) : (
                <div className='container mt-4' style={{ color: 'green' }}>
                    <h1 className='mb-4 ' style={{ color: 'green' }}>User Profile Found</h1>
                    <form onSubmit={UpdateUserHandle}>
                        <input className='form-control' type='text' name="name" value={name} onChange={(e) => setName(e.target.value)} placeholder='name' style={{ color: 'green' }} />
                        <input className='form-control' type='email' name="email" value={email} onChange={(e) => setEmail(e.target.value)} placeholder='email' style={{ color: 'green' }} />
                        <input className='form-control' type='text' name="country" value={country} onChange={(e) => setCountry(e.target.value)} placeholder='country' style={{ color: 'green' }} />
                        <button type="submit" className='btn btn-primary'>Update</button>
                    </form>
                </div>
            )}
        </div>
    );
};

export default UserUpdateProfile;
