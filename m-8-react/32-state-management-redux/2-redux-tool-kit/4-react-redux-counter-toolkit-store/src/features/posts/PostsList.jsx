import React, { useEffect } from 'react';
import { useDispatch, useSelector } from 'react-redux';
import fetchPosts from './postApi';

const PostsList = () => {
    const dispatch = useDispatch();
    const { loading, posts, error } = useSelector(state => state.posts);

    useEffect(() => {
        dispatch(fetchPosts());
    }, [dispatch]);

    if (loading) return <div>Loading...</div>;
    if (error) return <div>Error: {error}</div>;

    return (
        <ul>
            {posts.map(post => (
                <li key={post.id}>{post.title}</li>
            ))}
        </ul>
    );
};
export default PostsList;