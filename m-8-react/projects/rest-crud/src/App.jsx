import React, { useState } from 'react';
import { v4 as uuidv4 } from 'uuid';

const App = () => {
    const [items, setItems] = useState([]);
    const [currentItem, setCurrentItem] = useState(null);
    const [inputValue, setInputValue] = useState('');

    const addItem = (e) => {
        e.preventDefault();
        if(inputValue.trim() === '') return;
        const newItem = { id: uuidv4(), name: inputValue };
        setItems([...items, newItem]);
        setInputValue('');
    };

    const deleteItem = (id) => {
        setItems(items.filter(item => item.id !== id));
    };

    const selectItem = (item) => {
        setCurrentItem(item);
        setInputValue(item.name);
    };

    const updateItem = (e) => {
        e.preventDefault();
        if(inputValue.trim() === '' || !currentItem) return;
        const updatedItems = items.map((item) =>
            item.id === currentItem.id ? { ...item, name: inputValue } : item
        );
        setItems(updatedItems);
        setInputValue('');
        setCurrentItem(null);
    };

    return (
        <div style={{ padding: '20px',display: 'flex', justifyContent: 'center', alignItems: 'center',flexDirection: 'column' }}>
            <h1>CRUD App</h1>
            <form onSubmit={currentItem ? updateItem : addItem} style={{ marginBottom: '20px' }}>
                <input
                    type="text"
                    value={inputValue}
                    onChange={(e) => setInputValue(e.target.value)}
                    placeholder="Enter item name"
                    required
                />
                <button type="submit">{currentItem ? 'Update Item' : 'Add Item'}</button>
            </form>
            <h2>Items List</h2>
            <ul style={{ listStyleType: 'none', paddingLeft: 0 }}>
                {items.map(item => (
                    <li key={item.id} style={{ marginBottom: '10px' }}>
                        {item.name}
                        <button onClick={() => selectItem(item)} style={{ marginLeft: '10px' }}>Edit</button>
                        <button onClick={() => deleteItem(item.id)} style={{ marginLeft: '10px' }}>Delete</button>
                    </li>
                ))}
            </ul>
        </div>
    );
};

export default App;