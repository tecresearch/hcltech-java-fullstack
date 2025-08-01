import React from 'react';

const Sidebar = ({ wishlist, isSidebarOpen, closeSidebar, handleWishlistToggle, handleBuyAllWishlist }) => {
    return (
        <div className={`fixed top-0 right-0 w-64 h-full bg-white shadow-lg transition-transform transform ${isSidebarOpen ? 'translate-x-0' : 'translate-x-full'}`}>
            <div className="p-4">
                <div className="flex justify-between items-center">
                    <h2 className="text-xl font-bold mb-4">Your Wishlist</h2>
                    <button 
                        className="text-red-500 hover:text-red-700 focus:outline-none"
                        onClick={closeSidebar}
                    >
                        <svg className="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24" xmlns="http://www.w3.org/2000/svg">
                            <path strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="M6 18L18 6M6 6l12 12"></path>
                        </svg>
                    </button>
                </div>
                {wishlist.length > 0 ? (
                    <div>
                        {wishlist.map(book => (
                            <div key={book.id} className="mb-4 p-2 border-b border-gray-300">
                                <h3 className="font-bold">{book.name}</h3>
                                <p>Remaining Quantity: {book.quantity}</p>
                                <button
                                    className="mt-2 px-4 py-2 bg-red-500 hover:bg-red-700 text-white font-semibold rounded-lg shadow-md focus:outline-none"
                                    onClick={() => handleWishlistToggle(book.id)}
                                >
                                    Remove
                                </button>
                            </div>
                        ))}
                        <button
                            className="mt-6 w-full px-4 py-2 bg-yellow-500 hover:bg-yellow-700 text-white font-semibold rounded-lg shadow-md focus:outline-none"
                            onClick={handleBuyAllWishlist}
                        >
                            Buy All Wishlist Books
                        </button>
                    </div>
                ) : (
                    <p>Your wishlist is empty.</p>
                )}
            </div>
        </div>
    );
};

export default Sidebar;
