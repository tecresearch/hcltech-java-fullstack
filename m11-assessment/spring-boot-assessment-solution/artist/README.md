## Environment:
- Java version: 17
- Maven version: 3.*
- Spring Boot version: 3.0.6

## Read-Only Files:
- src/test/*

## Data:
Sample example of JSON data object:
```json
{
   "firstName": "Henry",
   "lastName": "Caldera"
}
```

## Requirements:
The `REST` service must expose the `/v1/artists` endpoint, which allows for managing the data records in the following way:


`POST` request to `/v1/artists` :
* creates a new artist data record
* the response code is 201 and the response body is the created record, including its unique id


`GET` request to `/v1/artists`:
* the response code is 200
* the response body is an list of matching records, ordered by their ids in increasing order


`GET` request to `/v1/artists/<id>`:
* returns a record with the given id and status code 200
* if there is no record in the database with the given id, the response code is null


`DELETE` request to `/v1/artists/<id>`:
* deletes the record with the given id from the database and return status code 200


Your task is to complete the given project so that it passes all the test cases when running the provided unit tests. The project by default supports the use of the H2 database.

## Commands
- run: 
```bash
mvn clean package; java -jar target/project_jar-1.0.jar
```
- install: 
```bash
mvn clean install
```
- test: 
```bash
mvn clean test
```
