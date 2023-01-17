## Desciption
___
This is a service for getting weather data for a specific city and storing the list of cities in a database for reuse. Powered by OpenWeatherMapApi service and PostgreSQL database.

## EndPoints:
___

```http request
GET     /api/city?name=Dnipro,ua
```
Expect result: `receive JSON response with cod 200 and info about city by name`
```http request
GET    /api/city
```
Expect result: `info about your added cities`
```http request
GET    /api/user
```
Expect result: `info about your added cities`
```http request
GET    /api/users
```
Expect result: `info about all users`
```http request
GET    /
```
Expect result: `show "add" city page`
```http request
GET    /city/delete?counrtyName=${counrtyName}
```
Expect result: `delete the specified city`
```http request
GET    /user
```
Expect result: `receive JSON response with all cities by your ip`
```http request
POST   /?counrtyName=${counrtyName}
```
Expect result: `add city in your list`  
## Properties:
___
*Example* application.yaml:
```yaml
service:
  countryName: "Kyiv,ua"
  id: Your API key
  units: metric
```
*Example* application.properties:
```properties
spring.datasource.url=jdbc:postgresql://localhost:5432/mydatabase
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.username=postres
spring.datasource.password=postres
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.show-sql=true
spring.jpa.hibernate.ddl-auto=update
```

## Requirements
___
* `java` 11.0.15
* `maven` 3.8.4
* `spring-boot` 2.6.0
## Installation and running (git)
___
Clone repository:
```cmd
git clone https://github.com/swat121/Weather
cd Weather
```
Build project:
```cmd
mvn clean compile
mvn clean package [or mvn package -DskipTests] 
```
Launch jar file:
```cmd
java -jar weather-0.0.1-SNAPSHOT.jar
```
Browser check:
[localhost:8080](http://localhost:8080)
## Installation and running (docker)
___
Clone image:
```docker
docker pull swat121/weather:tagname
```

Create container, you can use docker-compose or command line for environment variable

**command line**
```docker
docker run -e POSTGRES_DB=mydatabase -e POSTGRES_USER=postres -e POSTGRES_PASSWORD=postgres -d postgres:13.3
docker run -p 8080:8080 -e ID=yourID -e UNITS=yourUnits -e HOST=localhost -e PORT=5432 -e DATABASE=mydatabase -e USER=postres -e PASSWORD=postres -d swat121/weather:tagname
```
**docker-compose**
```docker
version: "3"

services:
  weather:
    image: swat121/weather:tagname
    container_name: weather-instance
    environment:
      id: "Your API key"
      units: metric
      Host: localhost
      Port: 5432
      Database: mydatabase
      User: postres
      Password: postres
    ports:
      - 8080:8080
  postres:
    image: postgres:13.3
    container_name: postgreSQL
    environment:
        POSTGRES_DB: mydatabase
        POSTGRES_USER: postres
        POSTGRES_PASSWORD: postres
```
Browser check:
[localhost:8080](http://localhost:8080)
### Reference
___
+ [My GitHub](https://github.com/swat121)
+ [My DockerHub](https://hub.docker.com/u/swat121)
+ [API key](https://home.openweathermap.org/api_keys)

