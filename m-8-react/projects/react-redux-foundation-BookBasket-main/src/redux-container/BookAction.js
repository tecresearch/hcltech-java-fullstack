import { PURCHASE_BOOK, TOGGLE_WISHLIST } from './BookTypes';

export const purchaseBook = (bookId) => {
    return {
        type: PURCHASE_BOOK,
        payload: bookId
    };
};

export const toggleWishlist = (bookId) => {
    return {
        type: TOGGLE_WISHLIST,
        payload: bookId
    };
};

export const purchaseAllWishlistBooks = () => {
    return {
        type: 'PURCHASE_ALL_WISHLIST_BOOKS'
    };
};
