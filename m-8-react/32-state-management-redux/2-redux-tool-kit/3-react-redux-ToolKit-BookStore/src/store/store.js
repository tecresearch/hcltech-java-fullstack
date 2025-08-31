import { configureStore } from '@reduxjs/toolkit';
import booksReducer from './bookslice';

export const store = configureStore({
  reducer: {
    books: booksReducer,
  },
});
