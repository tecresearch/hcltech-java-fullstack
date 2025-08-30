import React from 'react';

class EmployeeList extends React.Component {
  render() {
    const { emps, onDelete, onEdit } = this.props;
    return (
      <div>
        <table className="table table-bordered">
          <thead>
            <tr>
              <th>EmployeeId</th>
              <th>Name</th>
              <th>Email</th>
              <th>DOB</th>
              <th>Salary</th>
              <th>Action</th>
            </tr>
          </thead>
          <tbody>
            {emps.map((e) => (
              <tr key={e.empid}>
                <td>{e.empid}</td>
                <td>{e.name}</td>
                <td>{e.email}</td>
                <td>{e.dob}</td>
                <td>{e.salary}</td>
                <td>
                  <button className="btn btn-link" onClick={() => onEdit(e)}>
                    Edit
                  </button>
                  <button
                    className="btn btn-link"
                    onClick={() => onDelete(e.empid)}
                  >
                    Delete
                  </button>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
      </div>
    );
  }
}

export default EmployeeList;



// function EmployeeList({ emps, onDelete, onEdit }) {
//   return (
//     <div>
//       <table className="table table-bordered">
//         <thead>
//           <tr>
//             <th>EmployeeId</th>
//             <th>Name</th>
//             <th>Email</th>
//             <th>DOB</th>
//             <th>Salary</th>
//             <th>action</th>
//           </tr>
//         </thead>
//         <tbody>
//           {emps.map((e) => (
//             <tr key={e.empid}>
//               <td>{e.empid}</td>
//               <td>{e.name}</td>
//               <td>{e.email}</td>
//               <td>{e.dob}</td>
//               <td>{e.salary}</td>
//               <td>
//                 <button className="btn btn-link" onClick={() => onEdit(e)}>
//                   Edit
//                 </button>
//                 <button
//                   className="btn btn-link"
//                   onClick={() => onDelete(e.empid)}
//                 >
//                   Delete
//                 </button>
//               </td>
//             </tr>
//           ))}
//         </tbody>
//       </table>
//     </div>
//   );
// }

// export default EmployeeList;
