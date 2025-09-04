@echo off
echo Starting deployment of Spring REST app...

:: Stop and remove any existing container with the same name (optional)
docker stop spring-rest-app
docker rm spring-rest-app

:: Pull the latest Docker image from Docker Hub (optional, but ensures you have the latest image)
docker pull 110044/spring-rest-app:1.0

:: Run the Docker container from the image
docker run -d -p 8082:8082 --name spring-rest-app 110044/spring-rest-app:1.0

:: Verify that the container is running
docker ps

echo Deployment complete. Spring REST app is running on port 8082.
pause
