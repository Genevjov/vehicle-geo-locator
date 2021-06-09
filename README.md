<h1> Vehicle geo locator</h1>

<h3> Startup guide</h3>

1. Pull this project and follow to the docker directory inside.
2. To deploy needed infrastructure execute command `docker-compose up` inside the docker directory.
3. Go to the main project directory and execute `mvn clean install spring-boot:run`

The service will be deployed with such network settings:

- Host: localhost
- Port: 8080

<h3> User guide</h3>
This project supports Swagger ui. To use Swagger, please follow the  <a href="http://localhost:8080/swagger-ui.html">link</a>.

The application allows you to register vehicle location 
and find vehicles that are currently located in specified rectangle.

It is possible to do using Swagger with executing the request:
 - PUT /vehicle/location - for adding/updating new vehicle location
- POST  /vehicle/location/search/rectangle - for locating all vehicles that are registered inside the specified rectangle

