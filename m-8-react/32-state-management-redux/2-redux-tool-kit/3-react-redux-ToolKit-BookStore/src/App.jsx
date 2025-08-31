import React from 'react';
import './App.css';
import BookList from './components/BookList';
import AddBook from './components/AddBook';

function App() {
  return (
    <div className="App">
      <h1>Bookstore</h1>
      <AddBook />
      <BookList />
    </div>
  );
}

export default App;
