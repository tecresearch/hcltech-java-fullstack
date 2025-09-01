import { fetchPostsFailure, fetchPostsRequest, fetchPostsSuccess } from "./postsSlice";
 const  fetchPosts = async (dispatch) => {
    dispatch(fetchPostsRequest());
    try {
        const response = await fetch('https://jsonplaceholder.typicode.com/posts');
        const data = await response.json();
        dispatch(fetchPostsSuccess(data));
    } catch (error) {
        dispatch(fetchPostsFailure(error.message));
    }
};
export default fetchPosts;