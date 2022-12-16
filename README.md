## Desciption
___
This repository contains the simple implementation OpenWeatherMap Api with Spring Web

*Example:*
```yaml
service:
  countryName: "Kyiv,ua"
  id: Your API key
  units: metric
```

## Requirements
___
* java 17.0.3
* maven 3.8.4
## Instalation and running (git)
___
Clone repository:
```cmd
git clone https://git.java-academy.xyz/swat121/pm-hw-docker.git
cd pm-hw-docker
```
Build project:
```cmd
mvn clean compile
mvn clean package [or mvn package -DskipTests] 
```
Launch jar file:
```cmd
java -jar pm-hw-docker-0.0.1-SNAPSHOT.jar
```
Browser check:
[localhost:8080](http://localhost:8080)
## Instalation and running (docker)
___
Clone image:
```docker
docker pull swat121/weather:tagname
```

Create container, you can use docker-compose or command line for environment variable

**command line**
```docker
docker run -p 8080:8080 -e COUNTRYNAME=yourCountyName -e ID=yourID -e UNITS=yourUnits -d swat121/weather:tagname
```
**docker-compose**
```docker
version: "3"

services:
  weather:
    image: swat121/weather:tagname
    container_name: weather-instance
    environment:
      countryName: "Dnipro,ua"
      id: "Your API key"
      units: "metric"
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

