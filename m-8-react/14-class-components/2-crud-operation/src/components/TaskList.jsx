import React, { Component } from 'react';

export default class TaskList extends Component {
  constructor(props) {
    super(props);
    this.state = {
      tasks: props.data,
      checkedItems: Array(props.data.length).fill(false),
      editIndex: null,
      editTask: '',
    };
    this.checkBoxRefs = this.createRefs(props.data.length);
    this.listRefs = this.createRefs(props.data.length);
    this.buttonRefs = this.createRefs(props.data.length);
    this.upButtonRefs = this.createRefs(props.data.length);
  }

  componentDidUpdate(prevProps) {
    if (prevProps.data.length !== this.props.data.length) {
      this.setState({ tasks: this.props.data, checkedItems: Array(this.props.data.length).fill(false) });
      this.checkBoxRefs = this.createRefs(this.props.data.length);
      this.listRefs = this.createRefs(this.props.data.length);
      this.buttonRefs = this.createRefs(this.props.data.length);
      this.upButtonRefs = this.createRefs(this.props.data.length);
    }
  }

  createRefs = (length) => {
    return Array(length).fill(null).map(() => React.createRef());
  }

  handleCheckBox = (index) => {
    const checkboxRef = this.checkBoxRefs[index];
    if (checkboxRef && checkboxRef.current) {
      const isChecked = checkboxRef.current.checked;

      this.setState(prevState => {
        const updatedCheckedItems = Array(this.props.data.length).fill(false);
        updatedCheckedItems[index] = isChecked;
        return { checkedItems: updatedCheckedItems };
      });

      if (isChecked) {
        this.buttonRefs[index].current.textContent = 'Completing...';
        this.listRefs[index].current.style.textDecoration = 'line-through';
          this.listRefs[index].current.style.backgroundColor = 'green';
          this.listRefs[index].current.style.opacity = '0.6';
          this.listRefs[index].current.style.color = 'white';
        checkboxRef.current.disabled = true;
        setTimeout(() => {
           this.buttonRefs[index].current.textContent = 'Completed';
          checkboxRef.current.style.display = 'none';
        }, 2000);
      } else {
        this.buttonRefs[index].current.textContent = 'Mark as Completed';
        this.listRefs[index].current.style.textDecoration = 'none';
        checkboxRef.current.disabled = false;
      }
    } else {
      console.error(`Checkbox reference for index ${index} is null`);
    }
  };

  handleEditChange = (e) => {
    this.setState({ editTask: e.target.value });
  };

  handleUpdateTask = (index) => {
    const { editTask } = this.state;
    
    if (editTask) {
      this.props.updateTask(index, editTask);
     
      this.setState({ editIndex: null, editTask: '' });
    }
  };

  render() {
    const { tasks, checkedItems, editIndex, editTask } = this.state;
    return (
      <div>
        {tasks.length === 0 ? (
          <p className='flex justify-center'>No task available here!</p>
        ) : (
          <ul className='flex justify-center flex-col items-center space-y-2 p-4 bg-gray-100 rounded shadow-md'>
            {tasks.map((task, index) => (
              <div className='flex justify-between w-full' key={index}>
                <li ref={this.listRefs[index]} className='flex justify-between w-full hover:bg-gray-200 transition duration-200 p-2 rounded' style={{ textDecoration: editIndex === index ? 'none' : checkedItems[index] ? 'line-through' : 'none' }}>
                  {editIndex === index ? (
                    <input 
                      type='text'
                      value={editTask}
                      onChange={this.handleEditChange}
                      className='rounded p-1 w-full'
                    />
                  ) : (
                    <p>{task}</p>
                  )}
                </li>
                <div className='flex gap-2 items-center'>
                  <button 
                    ref={this.upButtonRefs[index]} 
                    className="bg-green-500 text-white font-semibold py-2 px-4 rounded hover:bg-green-600 transition duration-200" 
                    onClick={() => {
                      if (editIndex === index) {
                        this.handleUpdateTask(index);
                      } else {
                        this.setState({ editIndex: index, editTask: task });
                      }
                    }}
                  >
                    {editIndex === index ? 'Update' : 'Edit'}
                  </button>
                  <button 
                    className="bg-red-500 text-white font-semibold py-2 px-4 rounded hover:bg-red-600 transition duration-200" 
                    onClick={() => this.props.removeTask(index)}
                  >
                    Remove
                  </button>
                  <button ref={this.buttonRefs[index]} className="bg-blue-500 text-white font-semibold py-2 px-4 rounded hover:bg-blue-600 transition duration-200">Mark as completed</button>
                  <input ref={this.checkBoxRefs[index]} type='checkbox' onChange={() => this.handleCheckBox(index)} checked={checkedItems[index]} className='h-5 w-5 border-gray-300 rounded' />
                </div>
              </div>
            ))}
          </ul>
        )}
      </div>
    );
  }

}
