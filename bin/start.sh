cd /usr/local/product/project/ssmp
git pull

cd /usr/local/product/project/ssmpdeploy
docker stop ssmpcontainer
docker rm ssmpcontainer
docker rmi ssmpimage

cd /usr/local/product/project/ssmp
git pull
mvn clean package

yes|cp /usr/local/product/project/ssmp/bin/Dockerfile /usr/local/product/project/ssmpdeploy/Dockerfile
yes|cp /usr/local/product/project/ssmp/target/ssmp.jar /usr/local/product/project/ssmpdeploy/ssmp.jar

cd /usr/local/product/project/ssmpdeploy
docker build -t ssmpimage .
docker run --name ssmpcontainer -d -p 8080:8080 ssmpimage
