import { PURCHASE_BOOK, TOGGLE_WISHLIST } from './BookTypes';

const bookNames = [
    "Geeta", "Ramayan", "Hacking Book", "JavaScript Mastery", "React Essentials",
    "Node.js Guide", "Python Basics", "AI Fundamentals", "CSS Secrets", "HTML & CSS Design",
    "Web Security", "Data Structures", "Algorithms Unlocked", "Database Systems",
    "Operating Systems", "Networking Basics", "System Design", "Microservices", 
    "Cloud Computing", "DevOps Essentials"
];

const initialState = {
    books: bookNames.map((name, i) => ({
        id: i,
        name,
        quantity: 5,
        inWishlist: false,
    })),
    message: 'No books purchased yet',
    wishlist: [],
};

const BookReducer = (state = initialState, action) => {
    switch (action.type) {
        case PURCHASE_BOOK:
            return {
                ...state,
                books: state.books.map(book =>
                    book.id === action.payload && book.quantity > 0
                        ? { ...book, quantity: book.quantity - 1 }
                        : book
                ),
                message: state.books.some(book => book.quantity > 0)
                    ? 'You purchased a book!'
                    : 'All books out of stock!',
            };

        case TOGGLE_WISHLIST:
            return {
                ...state,
                books: state.books.map(book =>
                    book.id === action.payload
                        ? { ...book, inWishlist: !book.inWishlist }
                        : book
                ),
                wishlist: state.books
                    .filter(book => book.id === action.payload && !book.inWishlist)
                    .concat(state.wishlist.filter(item => item.id !== action.payload)),
            };

        case 'PURCHASE_ALL_WISHLIST_BOOKS':
            const updatedBooks = state.books.map(book =>
                book.inWishlist && book.quantity > 0
                    ? { ...book, quantity: book.quantity - 1 }
                    : book
            );
            const updatedWishlist = updatedBooks.filter(book => book.inWishlist && book.quantity > 0);

            return {
                ...state,
                books: updatedBooks,
                wishlist: updatedWishlist,
                message: updatedWishlist.length === 0 ? 'All wishlist books purchased!' : 'Some wishlist books purchased!',
            };

        default:
            return state;
    }
};

export default BookReducer;
