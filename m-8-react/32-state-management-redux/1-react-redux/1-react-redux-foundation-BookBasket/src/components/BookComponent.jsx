import React, { useState } from 'react';
import { useSelector, useDispatch } from 'react-redux';
import { purchaseBook, toggleWishlist, purchaseAllWishlistBooks } from '../redux-container/BookAction';
import Navbar from './NavBar';
import Sidebar from './Sidebar';
import BookCard from './BookCard';
import Footer from './Footer';

function BookComponent() {
    const { books, message, wishlist } = useSelector(state => state);
    const dispatch = useDispatch();
    const [isSidebarOpen, setSidebarOpen] = useState(false);

    const handlePurchase = (bookId) => {
        dispatch(purchaseBook(bookId));
    };

    const handleWishlistToggle = (bookId) => {
        dispatch(toggleWishlist(bookId));
    };

    const handleBuyAllWishlist = () => {
        dispatch(purchaseAllWishlistBooks());
    };

    const toggleSidebar = () => {
        setSidebarOpen(!isSidebarOpen);
    };

    const closeSidebar = () => {
        setSidebarOpen(false);
    };

    return (
        <div className="flex flex-col min-h-screen bg-gray-100">
            <Navbar wishlistLength={wishlist.length} toggleSidebar={toggleSidebar} />
            <Sidebar 
                wishlist={wishlist}
                isSidebarOpen={isSidebarOpen}
                closeSidebar={closeSidebar}
                handleWishlistToggle={handleWishlistToggle}
                handleBuyAllWishlist={handleBuyAllWishlist}
            />
            <div className="flex-grow flex flex-col items-center justify-center py-8">
                <h1 className="text-2xl font-bold mb-6">{message}</h1>
                <div className="grid grid-cols-1 md:grid-cols-3 lg:grid-cols-4 gap-6 px-4">
                    {books.map(book => (
                        <BookCard 
                            key={book.id}
                            book={book}
                            handlePurchase={handlePurchase}
                            handleWishlistToggle={handleWishlistToggle}
                        />
                    ))}
                </div>
            </div>
            <Footer />
        </div>
    );
}

export default BookComponent;
