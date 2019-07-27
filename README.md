**Test for carX**

_How to build?_

`mvn -B package`

_How to run?_

Entry point: http://your-host:8080/

- POST: URI path /user/{uuid} with uuid in path and json in payload to save user data
- GET: URI path /user/{uuid} with uuid in path to get json user data
- POST: URI path /user/{uuid}/activity with uuid in path and some integer to save activity


`docker-compose up`

OR

`docker build -t test:latest .`

`cd ./database`

`docker build -t postgres-test:latest .`

`docker network create test`

`docker network ls`

`docker run -d --network test --name postgres -p 5432:5432 postgres-test:latest`

`docker run -d --network test --name test -p 8080:8080 test:latest`


При разработке решения нужно учитывать требования, которые были поставлены перед вами аналитическим отделом, им требуется (Х,Y - параметры запросов):

  - Быстро выбирать Х пользователей с самым большим текущим значением "money" по каждой стране "country". 

`select u.uuid from test.users u where u.country='country' order by u.money desc limit 10`

  - Иметь возможность быстро подсчитать количество новых пользователей по каждой стране за период Х.

`select count(*) from test.users u where u.country = 'RU' and u.create_date BETWEEN NOW() - INTERVAL '1 DAY' AND NOW();`

  - Для каждого конкретного пользователя X быстро получить отсортированный по дате список значений показателя "activity" и даты их получения за период Y.
  
  `select a.activity, a.create_date from test.activities a where a.user_uuid = '473f70fd-fd99-4b50-aa54-f8caff1849f0' order by a.create_date desc;`