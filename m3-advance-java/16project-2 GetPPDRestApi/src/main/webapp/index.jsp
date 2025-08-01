<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Fetch API Data</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            padding: 20px;
        }
        #response {
            margin-top: 20px;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
        h1 {
            color: #333;
        }
    </style>
</head>
<body>
    <h1>Welcome to the JSP Page</h1>
    <p>This page fetches data from the REST API using various HTTP methods.</p>

    <!-- Buttons for different HTTP methods -->
    <button onclick="fetchData('GET')">Fetch Data (GET)</button>
    <button onclick="fetchData('POST')">Send Data (POST)</button>
    <button onclick="fetchData('PUT')">Update Data (PUT)</button>
    <button onclick="fetchData('DELETE')">Delete Data (DELETE)</button>

    <!-- Area to display the API response -->
    <div id="response"></div>

    <script>
        // Function to handle API requests for different methods
        function fetchData(method) {
            let url = 'http://localhost:8080/FirstRestApi/api/hello';
            let options = {
                method: method, // Set the HTTP method (GET, POST, PUT, DELETE)
                headers: {
                    'Content-Type': 'application/json'
                }
            };

            // Adding data for POST and PUT requests
            if (method === 'POST' || method === 'PUT') {
                const data = {
                    message: "This is a test message",
                    status: "success",
                    author: "Your Name",
                    version: "1.0.0"
                };
                options.body = JSON.stringify(data);
            }

            // Adding ID for DELETE request
            if (method === 'DELETE') {
                url += '?id=123'; // Example of passing an ID parameter for DELETE
            }

            // Making the fetch request
            fetch(url, options)
                .then(response => {
                    if (!response.ok) {
                        throw new Error('Network response was not ok');
                    }
                    return response.json();
                })
                .then(data => {
                    // Log the raw response data for debugging
                    console.log(data); 

                    if (!data || !data.message) {
                        document.getElementById('response').innerHTML = 'No data returned from the API.';
                        return;
                    }

                    const responseDiv = document.getElementById('response');
                    let responseContent = `
                        <strong>Message:</strong> ${data.message} <br>
                        <strong>Status:</strong> ${data.status} <br>
                        <strong>Author:</strong> ${data.author} <br>
                        <strong>Version:</strong> ${data.version} <br>
                    `;
                    if (data.timestamp) {
                        responseContent += `<strong>Timestamp:</strong> ${data.timestamp} <br>`;
                    }

                    // Update the response div with the content
                    responseDiv.innerHTML = responseContent;
                })
                .catch(error => {
                    console.error('Error fetching data:', error);
                    document.getElementById('response').innerHTML = 'Error: ' + error.message;
                });
        }
    </script>
</body>
</html>
