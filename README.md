**Test for carX**

_How to build?_

`mvn -B package`

_How to run?_

`docker-compose up`

OR

`docker build -t test:latest .`

`cd ./database`

`docker build -t postgres-test:latest .`

`docker network create test`

`docker network ls`

`docker run -d --network test --name postgres -p 5432:5432 postgres-test:latest`

`docker run -d --network test --name test -p 8282:8080 test:latest`

При разработке решения нужно учитывать требования, которые были поставлены перед вами аналитическим отделом, им требуется (Х,Y - параметры запросов):

  - Быстро выбирать Х пользователей с самым большим текущим значением "money" по каждой стране "country". 

`SQL`

  - Иметь возможность быстро подсчитать количество новых пользователей по каждой стране за период Х.

`SQL`

  - Для каждого конкретного пользователя X быстро получить отсортированный по дате список значений показателя "activity" и даты их получения за период Y.
  
 `SQL`