## Desciption
___
This is a service for getting weather data for a specific city and storing the list of cities in a database for reuse. Powered by OpenWeatherMapApi service and PostgreSQL database.

HTTP-methods you can use:

Expect result: `receive JSON response with cod 200 and info about default city`
```http request
GET    http://localhost:8080/city/json
```
```json
{
    "cod": "200",
    "name": "Dnipro",
    "main": {
        "temp": "0.7",
        "temp_min": "0.7",
        "grnd_level": "1006",
        "humidity": "84",
        "pressure": "1023",
        "sea_level": "1023",
        "feels_like": "-2.92",
        "temp_max": "0.7"
    }
}
```
Expect result: `info about your added cities`
```http request
GET    http://localhost:8080/city
```
Expect result: `show "add" city page`
```http request
GET    http://localhost:8080/
```
Expect result: `delete the specified city`
```http request
GET    http://localhost:8080/city/delete?counrtyName=${counrtyName}
```
Expect result: `receive JSON response with all cities by your ip`
```http request
GET    http://localhost:8080/user
```
Example:
```json
[
    {
        "id": 12,
        "countryName": "Dnipro,ua",
        "ipAddress": "Your Ip"
    },
    {
        "id": 13,
        "countryName": "Kyiv,ua",
        "ipAddress": "Your Ip"
    },
    {
        "id": 14,
        "countryName": "Lviv,ua",
        "ipAddress": "Your Ip"
    }
]
```
Expect result: `add city in your list`
```http request
POST   http://localhost:8080/?counrtyName=${counrtyName}
```
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
* java 11.0.15
* maven 3.8.4
* spring-boot 2.6.0
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
```
Browser check:
[localhost:8080](http://localhost:8080)
### Reference
___
+ [My GitHub](https://github.com/swat121)
+ [My DockerHub](https://hub.docker.com/u/swat121)
+ [API key](https://home.openweathermap.org/api_keys)

