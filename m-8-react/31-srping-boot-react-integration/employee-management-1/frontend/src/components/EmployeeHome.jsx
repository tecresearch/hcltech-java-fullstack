import React, { useEffect, useState } from "react";
import {
  addEmployee,
  deleteEmployee,
  getAllEmployee,
  updateEmployee,
} from "../EmployeeAPI";
import EmployeeList from "./EmployeeList";
import EmployeeForm from "./EmployeeForm";

function EmployeeHome() {
  const [employees, setEmployees] = useState([]);
  const [editEmployee, setEditEmployee] = useState(null);

  const fetchEmployees = async () => {
    const response = await getAllEmployee();
    setEmployees(response.data);
  };

  useEffect(() => {
    fetchEmployees();
  }, []);

  const handleSaveEmployee = async (emp) => {
    if (editEmployee) {
      //updateEmployee
      await updateEmployee(emp);
      setEditEmployee(null);
    } else {
      //createEmployee
      await addEmployee(emp);
    }
    fetchEmployees();
  };

  const handleDeletEmployee = async (eid) => {
    await deleteEmployee(eid);
    fetchEmployees();
  };

  const handleEditEmployee = async (emp) => {
    setEditEmployee(emp);
  };
  return (
    <div>
      <EmployeeForm onSave={handleSaveEmployee} editEmployee={editEmployee} />
      <EmployeeList
        emps={employees}
        onDelete={handleDeletEmployee}
        onEdit={handleEditEmployee}
      ></EmployeeList>
    </div>
  );
}

export default EmployeeHome;
