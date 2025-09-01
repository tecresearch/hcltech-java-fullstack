import { createSlice } from '@reduxjs/toolkit';

export const postsSlice = createSlice({
    name: 'posts',
    initialState: {
        loading: false,
        posts: [],
        error: '',
    },
    reducers: {
        fetchPostsRequest: (state) => {
            state.loading = true;
        },
        fetchPostsSuccess: (state, action) => {
            state.loading = false;
            state.posts = action.payload;
            state.error = '';
        },
        fetchPostsFailure: (state, action) => {
            state.loading = false;
            state.error = action.payload;
        },
    },
});

// Exporting the actions  
export const { fetchPostsRequest, fetchPostsSuccess, fetchPostsFailure } = postsSlice.actions;

// Exporting the reducer  
export default postsSlice.reducer;