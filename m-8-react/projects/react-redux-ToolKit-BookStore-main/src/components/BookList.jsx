import React from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { removeBook } from '../store/bookslice';
import './BookList.css'; // Import the CSS file

const BookList = () => {
  const books = useSelector(state => state.books.books);
  const dispatch = useDispatch();

  const handleRemove = (id) => {
    dispatch(removeBook(id));
  };

  return (
    <div className="book-list-container">
      <h2>Book List</h2>
      <ul className="book-list">
        {books.map(book => (
          <li key={book.id} className="book-item">
            <div className="book-details">
              <strong>{book.title}</strong> by {book.author}
            </div>
            <button onClick={() => handleRemove(book.id)}>Remove</button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default BookList;
