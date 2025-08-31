import React from 'react';

const BookCard = ({ book, handlePurchase, handleWishlistToggle }) => {
    return (
        <div key={book.id} className={`max-w-xs rounded-lg overflow-hidden shadow-lg bg-white p-6 text-center ${book.quantity <= 0 ? 'bg-gray-300' : ''}`}>
            <h2 className="text-xl font-bold mb-4">{book.quantity > 0 ? 'Available' : 'Out of Stock'}</h2>
            <p className="mb-4">{book.name}</p>
            <p className="text-gray-700 mb-6">Remaining Quantity: {book.quantity}</p>
            <button
                className={`mt-4 px-6 py-2 ${book.quantity > 0 ? 'bg-blue-500 hover:bg-blue-700' : 'bg-gray-500 cursor-not-allowed'} text-white font-semibold rounded-lg shadow-md focus:outline-none`}
                onClick={() => handlePurchase(book.id)}
                disabled={book.quantity <= 0}
            >
                {book.quantity > 0 ? 'Buy Book' : 'Out of Stock'}
            </button>
            <button
                className={`mt-2 px-6 py-2 bg-green-500 hover:bg-green-700 text-white font-semibold rounded-lg shadow-md focus:outline-none`}
                onClick={() => handleWishlistToggle(book.id)}
            >
                {book.inWishlist ? 'Remove from Wishlist' : 'Add to Wishlist'}
            </button>
        </div>
    );
};

export default BookCard;
