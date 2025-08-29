import React from 'react';
import './App.css';
import 'h8k-components';
import SearchCustomer from './components/SearchCustomer';
const title = "Customer Search";

const App = () => {
    return (
        <div className="App">
            <h8k-navbar header={title}></h8k-navbar>
            <SearchCustomer />
        </div>
    );
}

export default App;
