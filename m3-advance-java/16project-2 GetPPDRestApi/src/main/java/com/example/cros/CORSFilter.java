package com.example.cros;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")  // Apply this filter to all requests
public class CORSFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization (optional)
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletResponse httpResp = (HttpServletResponse) response;

        // Set CORS headers
        httpResp.setHeader("Access-Control-Allow-Origin", "http://localhost:8080");  // Allow frontend URL
        httpResp.setHeader("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE");  // Allowed methods
        httpResp.setHeader("Access-Control-Allow-Headers", "Content-Type"); // Allowed headers

        // If it's a preflight request (OPTIONS), respond immediately
        if ("OPTIONS".equalsIgnoreCase(((HttpServletRequest) request).getMethod())) {
            httpResp.setStatus(HttpServletResponse.SC_OK);
        } else {
            // Proceed with the request
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        // Cleanup (optional)
    }
}
