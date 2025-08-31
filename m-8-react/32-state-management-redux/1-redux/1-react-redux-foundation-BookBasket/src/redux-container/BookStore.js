// src/store.js
import { createStore } from 'redux';
import BookReducer from './BookReducer';

export const store = createStore(BookReducer);
