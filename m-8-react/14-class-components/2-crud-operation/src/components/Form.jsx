import React, { Component } from 'react';
import TaskList from './TaskList';

export default class Form extends Component {
    constructor() {
        super();
        this.state = {
            task: '',
            data: []
        };
    }

    handleTaskInput = (e) => {
        this.setState({ task: e.target.value });
        console.log(this.state.task);
    }

    handleSubmit = (e) => {
        e.preventDefault();
        const { task, data } = this.state;
        if (task) {
            console.log('Before adding, current data:', data);
            this.setState({
                data: [...data, task],
                task: ''
            }, () => {
                console.log('After adding, updated data:', this.state.data);
            });
        }
    };

    updateTask = (index, newTask) => {
        this.setState(prevState => {
            const updatedData = [...prevState.data];
            updatedData[index] = newTask;
            return { data: updatedData };
        });
    };

    removeTask = (index) => {
        this.setState(prevState => {
            const updatedData = prevState.data.filter((_, i) => i !== index);
            return { data: updatedData };
        });
    };

    render() {
        const { task, data } = this.state;

        return (
            <div>
                <form onSubmit={this.handleSubmit} className='flex justify-center flex-col mx-12 p-4 gap-4'>
                    <input
                        className='border-2 border-gray-300 rounded-2xl p-3 focus:border-green-500 focus:outline-none'
                        type='text'
                        name='task'
                        placeholder='Enter your task'
                        value={task}
                        onChange={this.handleTaskInput}
                    />
                    <button type='submit' className='border bg-green-500 text-white font-semibold rounded-2xl py-2 px-4 hover:bg-green-600 transition duration-200'>Add Task</button>
                </form>

                <TaskList data={data} updateTask={this.updateTask} removeTask={this.removeTask} />
            </div>
        );
    }
}
