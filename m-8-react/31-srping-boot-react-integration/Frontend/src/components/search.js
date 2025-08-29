import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import LeaveRequestService from "../../services/LeaveRequestService";
import LeaveTypeService from "../../services/LeaveTypeService";

const AddLeaveRequestUser = ({ employeeId }) => {
  const navigate = useNavigate();
  const [leaveRequest, setLeaveRequest] = useState({
    employeeId: "",
    leaveTypeName: 0,
    startDate: "",
    endDate: "",
    reason: "",
  });
  const [leaveTypes, setLeaveTypes] = useState([]);

  useEffect(() => {
    fetchLeaveTypes();
    setLeaveRequest((prevLeaveRequest) => ({ ...prevLeaveRequest, employeeId }));
  }, [employeeId]);

  const fetchLeaveTypes = () => {
    LeaveTypeService.getAllLeaveTypes()
      .then((response) => {
        console.log(response.data);
        setLeaveTypes(response.data);
      })
      .catch((error) => {
        console.log(error);
      });
  };

  const handleChange = (e) => {
    const { name, value } = e.target;
    const parsedValue = name === 'leaveTypeName' ? parseInt(value) : value;
    setLeaveRequest({ ...leaveRequest, [name]: parsedValue });
  };

  const formatDateString = (dateString) => {
    const date = new Date(dateString);
    const formattedDate = date.toISOString().split("T")[0];
    return formattedDate;
  };

  const addLeaveRequest = (e) => {
    e.preventDefault();
    const { leaveTypeName, startDate, endDate, reason } = leaveRequest;
    const formattedLeaveRequest = {
      employeeId,
      leaveTypeName,
      startDate: formatDateString(startDate),
      endDate: formatDateString(endDate),
      reason,
    };
    LeaveRequestService.saveLeaveRequest(formattedLeaveRequest)
      .then((response) => {
        console.log(response);
        navigate("/user/leaveRequestListUser");
      })
      .catch((error) => {
        console.log(error);
      });
  };

  return (
    <div className="container">
      <h1 className="mb-4">Add Leave Request for Employee ID: {employeeId}</h1>
      <form onSubmit={addLeaveRequest}>
        <div className="form-group">
          <label>Leave Type</label>
          <select
            className="form-control"
            name="leaveTypeName"
            value={leaveRequest.leaveTypeName}
            onChange={handleChange}
            required
          >
            <option value={0}>Select Leave Type</option>
            {leaveTypes.map((leaveType) => (
              <option key={leaveType.typeId} value={leaveType.typeId}>
                {leaveType.typeName}
              </option>
            ))}
          </select>
        </div>
        <div className="form-row">
          <div className="form-group col-md-6">
            <label>Start Date</label>
            <input
              type="date"
              className="form-control"
              name="startDate"
              value={leaveRequest.startDate}
              onChange={handleChange}
              required
            />
          </div>
          <div className="form-group col-md-6">
            <label>End Date</label>
            <input
              type="date"
              className="form-control"
              name="endDate"
              value={leaveRequest.endDate}
              onChange={handleChange}
              required
            />
          </div>
        </div>
        <div className="form-group">
          <label>Reason</label>
          <textarea
            className="form-control"
            name="reason"
            value={leaveRequest.reason}
            onChange={handleChange}
            rows={4}
            required
          ></textarea>
        </div>
        <button type="submit" className="btn btn-primary">
          Submit
        </button>
      </form>
    </div>
  );
};

export default AddLeaveRequestUser;