import React from "react";
import {
  addEmployee,
  deleteEmployee,
  getAllEmployee,
  updateEmployee,
} from "../EmployeeAPI";
import EmployeeList from "./EmployeeList";
import EmployeeForm from "./EmployeeForm";
import { Outlet } from "react-router-dom";

class EmployeeHome extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      employees: [],
      editEmployee: null,
    };
  }

  componentDidMount() {
    this.fetchEmployees();
  }

  fetchEmployees = async () => {
    const response = await getAllEmployee();
    this.setState({ employees: response.data });
  };

  handleSaveEmployee = async (emp) => {
    if (this.state.editEmployee) {
      // Update employee
      await updateEmployee(emp);
      this.setState({ editEmployee: null });
    } else {
      // Create employee
      await addEmployee(emp);
    }
    this.fetchEmployees();
  };

  handleDeleteEmployee = async (eid) => {
    await deleteEmployee(eid);
    this.fetchEmployees();
  };

  handleEditEmployee = (emp) => {
    this.setState({ editEmployee: emp });
  };

  render() {
    const { employees, editEmployee } = this.state;
    return (
      <div>
        <EmployeeForm onSave={this.handleSaveEmployee} editEmployee={editEmployee} />
        <EmployeeList
          emps={employees}
          onDelete={this.handleDeleteEmployee}
          onEdit={this.handleEditEmployee}
        />
        <Outlet />
      </div>
    );
  }
}

export default EmployeeHome;


// import React, { useEffect, useState } from "react";
// import {
//   addEmployee,
//   deleteEmployee,
//   getAllEmployee,
//   updateEmployee,
// } from "../EmployeeAPI";
// import EmployeeList from "./EmployeeList";
// import EmployeeForm from "./EmployeeForm";
// import { Outlet } from "react-router-dom";

// function EmployeeHome() {
//   const [employees, setEmployees] = useState([]);
//   const [editEmployee, setEditEmployee] = useState(null);

//   const fetchEmployees = async () => {
//     const response = await getAllEmployee();
//     setEmployees(response.data);
//   };

//   useEffect(() => {
//     fetchEmployees();
//   }, []);

//   const handleSaveEmployee = async (emp) => {
//     if (editEmployee) {
//       //updateEmployee
//       await updateEmployee(emp);
//       setEditEmployee(null);
//     } else {
//       //createEmployee
//       await addEmployee(emp);
//     }
//     fetchEmployees();
//   };

//   const handleDeletEmployee = async (eid) => {
//     await deleteEmployee(eid);
//     fetchEmployees();
//   };

//   const handleEditEmployee = async (emp) => {
//     setEditEmployee(emp);
//   };
//   return (
//     <div>
//       <EmployeeForm onSave={handleSaveEmployee} editEmployee={editEmployee} />
//       <EmployeeList
//         emps={employees}
//         onDelete={handleDeletEmployee}
//         onEdit={handleEditEmployee}
//       ></EmployeeList>
//       <Outlet/>
//     </div>
//   );
// }

// export default EmployeeHome;
