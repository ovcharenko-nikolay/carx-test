**Test for carX**

_How to build?_

`mvn -B package`

_How to run?_
`
docker-compose up`

OR

`docker build -t test:latest .`

`cd ./database`

`docker build -t postgres-test:latest .`

`docker network create test`

`docker network ls`

`docker run -d --network test --name postgres -p 5432:5432 postgres-test:latest`

`docker run -d --network test --name test -p 8282:8080 test:latest`