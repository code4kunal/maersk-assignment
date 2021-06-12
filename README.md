## MAERSK ASSIGNMENT
Create an API suite for movie records using in-memory database.
Also, provide required junit test coverage for the same.
### Solution
1. Used spring boot as a web framework to develop REST APIs.
2. Used h2 database(JVM based) for a storage.
3. Included ratings and year as a query parameter in get All Movies API.
4. Ratings will strictly have certain values as specified in the constants i.e
   FLOP, AVERAGE, HIT, SUPER_HIT, BLOCKBUSTER.
5. Some validations have been performed based on some assumptions, which are properly handled in case of exception.

### Setup
1. Clone the code from github
```
git clone https://github.com/code4kunal/maersk-assignment.git
```
2. cd into project directory

```
mvn clean install
mvn spring-boot:run 
```
3. For testing API's, Swagger is configured at
``` 
http://localhost:8080/swagger-ui.html
```
4. h2 Console is configured at
```
http://localhost:8080/h2
```