package com.example.api;

import java.io.BufferedReader;
import java.io.IOException;

import com.example.model.ApiResponse;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/api/hello")
public class HelloAPI extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type to JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
       
        // Create a model object
        ApiResponse apiResponse = new ApiResponse(
            "Welcome to your first REST API!",
            "success",
            "Your Name",
            "1.0.0"
        );

        // Convert the model object to JSON using Gson
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(apiResponse);

        // Send the JSON response
        response.getWriter().write(jsonResponse);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type to JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Read input data from the request body
        StringBuilder body = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                body.append(line);
            }
        }

        // Simulate saving the data and send a response
        ApiResponse apiResponse = new ApiResponse(
            "Data received successfully!",
            "success",
            "Your Name",
            "1.0.0"
        );

        // Convert the model object to JSON using Gson
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(apiResponse);

        // Send the JSON response
        response.getWriter().write(jsonResponse);
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type to JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Read input data from the request body
        StringBuilder body = new StringBuilder();
        try (BufferedReader reader = request.getReader()) {
            String line;
            while ((line = reader.readLine()) != null) {
                body.append(line);
            }
        }

        // Simulate updating the data and send a response
        ApiResponse apiResponse = new ApiResponse(
            "Data updated successfully!",
            "success",
            "Your Name",
            "1.0.1"
        );

        // Convert the model object to JSON using Gson
        Gson gson = new Gson();
        String jsonResponse = gson.toJson(apiResponse);

        // Send the JSON response
        response.getWriter().write(jsonResponse);
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set response content type to JSON
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        // Simulate deletion logic based on a query parameter (e.g., ?id=123)
        String id = request.getParameter("id");
        String jsonResponse;
        if (id != null) {
            ApiResponse apiResponse = new ApiResponse(
                "Data with ID " + id + " has been deleted successfully!",
                "success",
                "Your Name",
                "1.0.0"
            );
            Gson gson = new Gson();
            jsonResponse = gson.toJson(apiResponse);
        } else {
            ApiResponse apiResponse = new ApiResponse(
                "No ID provided. Unable to delete.",
                "error",
                "Your Name",
                "1.0.0"
            );
            Gson gson = new Gson();
            jsonResponse = gson.toJson(apiResponse);
        }

        // Send the JSON response
        response.getWriter().write(jsonResponse);
    }
}
