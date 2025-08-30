import axios from "axios";

const api_url = "http://localhost:8080/employees";
export const getAllEmployee = () => axios.get(api_url);
export const addEmployee = (employee) => axios.post(api_url, employee);
export const updateEmployee = (employee) => axios.put(api_url, employee);
export const deleteEmployee = (eid) => axios.delete(`${api_url}/${eid}`); // http://localhost:8080/employees/12
