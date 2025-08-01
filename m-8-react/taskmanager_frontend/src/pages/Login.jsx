import React from 'react';

function Login() {
  return (
    <div className="h-[98vh] flex items-center justify-center bg-gradient-to-l from-gray-500 to-white-400">
      <div className="p-6 w-96 flex flex-col items-center justify-center border border-gray-600 rounded-2xl bg-gray-800 shadow-xl">
        <div className="text-3xl font-bold text-white mb-4">Login</div>
        
        <input
          type="text"
          placeholder="Username"
          className="bg-gray-700 px-4 py-2 mb-4 w-full rounded-lg text-white placeholder-gray-400 focus:outline-none focus:ring-2 focus:ring-blue-400"
          name="username"
          required
        />
        
        <input
          type="password"
          placeholder="Password"
          className="bg-gray-700 px-4 py-2 mb-6 w-full rounded-lg text-white placeholder-gray-400 focus:outline-none focus:ring-2 focus:ring-blue-400"
          name="password"
          required
        />
        
        <button className="bg-blue-600 text-white font-semibold rounded-lg py-2 px-6 w-full hover:bg-blue-700 transition duration-300 ease-in-out transform hover:scale-105">
          Login
        </button>
        
        <p className="mt-4 text-sm text-gray-400">
          Don't have an account?{' '}
          <a href="/signup" className="text-blue-400 hover:text-blue-500">
            Sign up here
          </a>
        </p>
      </div>
    </div>
  );
}

export default Login
