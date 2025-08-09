import React, { useState } from 'react';
import { useDispatch } from 'react-redux';
import { addBook } from '../store/bookslice';
import './AddBook.css'; // Import the CSS file

const AddBook = () => {
  const [title, setTitle] = useState('');
  const [author, setAuthor] = useState('');
  const dispatch = useDispatch();

  const handleAddBook = () => {
    if (title && author) {
      dispatch(addBook({ id: Date.now(), title, author }));
      setTitle('');
      setAuthor('');
    }
  };

  return (
    <div className="add-book-container">
      <h2>Add a Book</h2>
      <div className="form-group">
        <input
          type="text"
          value={title}
          onChange={(e) => setTitle(e.target.value)}
          placeholder="Book Title"
          className="input-field"
        />
      </div>
      <div className="form-group">
        <input
          type="text"
          value={author}
          onChange={(e) => setAuthor(e.target.value)}
          placeholder="Author"
          className="input-field"
        />
      </div>
      <button onClick={handleAddBook} className="submit-button">Add Book</button>
    </div>
  );
};

export default AddBook;
