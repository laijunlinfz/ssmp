docker build -t ssmpimage .
docker run --name ssmpcontainer -d -p 8080:8080 ssmpimage
