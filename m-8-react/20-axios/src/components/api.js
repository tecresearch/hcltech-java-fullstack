import axios from "axios";

const api = axios.create({
    baseURL: "https://jsonplaceholder.typicode.com",
    headers: {
        "Content-Type": "application/json",
    },
});

// Fetch user by ID
export const fetchUser = (id) => api.get(`/users/${id}`);

// Create a new user
export const createUser = (userData) => api.post(`/users`, userData);

// Update user by ID
export const updateUser = (id, userData) => api.put(`/users/${id}`, userData);

// Delete user by ID
export const deleteUser = (id) => api.delete(`/users/${id}`);

// Partially update user by ID
export const patchUser = (id, userData) => api.patch(`/users/${id}`, userData);

export default api;
