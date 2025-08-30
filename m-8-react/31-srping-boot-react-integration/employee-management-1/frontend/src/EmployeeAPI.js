import axios from "axios";

const api_url = "http://localhost:8080/employees";
export const getAllEmployee = () => axios.get(api_url);
export const addEmployee = (employee) => axios.post(api_url, employee);
export const updateEmployee = (employee) => axios.put(api_url, employee);
export const deleteEmployee = (eid) => axios.delete(`${api_url}/${eid}`); // http://localhost:8080/employees/12


// const api_url = "http://localhost:8080/employees";

// export const getAllEmployee = async () => {
//     const response = await fetch(api_url);
//     return await response.json();
// };

// export const addEmployee = async (employee) => {
//     const response = await fetch(api_url, {
//         method: 'POST',
//         headers: { 'Content-Type': 'application/json' },
//         body: JSON.stringify(employee)
//     });
//     return await response.json();
// };

// export const updateEmployee = async (employee) => {
//     const response = await fetch(api_url, {
//         method: 'PUT',
//         headers: { 'Content-Type': 'application/json' },
//         body: JSON.stringify(employee)
//     });
//     return await response.json();
// };

// export const deleteEmployee = async (eid) => {
//     const response = await fetch(`${api_url}/${eid}`, {
//         method: 'DELETE'
//     });
//     return response.ok; // Returns true if the deletion was successful.
// };

