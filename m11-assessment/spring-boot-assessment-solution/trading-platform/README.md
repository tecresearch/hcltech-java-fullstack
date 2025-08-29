## Environment:
- Java version: 1.8
- Maven version: 3.*
- Spring Boot version: 2.2.1.RELEASE

## Read-Only Files:
- src/test/*

## Data:
Each trader data is a JSON entry with the following keys:
```json
{
    "id":"The unique ID assigned at the time of registration.",
    "name": "The name of the trader.",
    "email": "The email of the trader.",
    "balance": "The account balance of the trader.",
    "createdAt": "The timestamp when the registration was completed described by the string `yyyy-MM-dd HH:mm:ss`",
    "updatedAt": "The timestamp when the trader account got updated, i.e., either the name was updated or money was added described by the string `yyyy-MM-dd HH:mm:ss`."
}
```

Example of trader JSON object:
```json
{
    "id": 1,
    "name": "Elizabeth Small",
    "email": "susanchandler.wchurch@buck.com",
    "balance": 62.0,
    "createdAt": "2018-04-16 04:56:28",
    "updatedAt": ""
}
```

## Requirements:
The `REST` service must expose the `/trading/traders` endpoint, which allows for managing the data records in the following way:

`POST` request to `/trading/traders/register`:
* registers a new trader record.
* expects a JSON trader object with missing `id`, `createdAt`, `updatedAt`. You can assume that the given object is always valid.
* if a trader with the same email already exists, response code is 400 otherwise response code is 201.

`GET` request to `/trading/traders/all`:
* returns all the records with status code 200.
* records should be sorted by ID in the ascending order.

`GET` request to `/trading/traders?email={email}`:
* returns a record with the given email and status code 200.
* if there is no record in the database with the given email, the response code is 404.

`PUT` request to `/trading/traders`:
* updates the trader's name by email. the trader JSON sent in request body will have the keys `email, name`.
* if the trader with the requested email does not exist, the response code is 404 otherwise the response code is 200.

`PUT` request to `/trading/traders/add`:
add money to the trader's account by t
* adds money to the trader's account by email. the trader JSON sent in request body will have the keys `email, amount`.
* if the trader with the requested email does not exist, the response code is 404 otherwise the response code is 200.

`Note that:`
* The default timezone of the application is set to UTC, which should not be modified.
* We allow an absolute error of 10-3 in the expected and returned balance field of the trader data.
* We allow a maximum difference of one second between the returned `createdAt` value in any GET request and the expected createdAt, i.e., the timestamp when the registration request was sent from the JUnit test.
* We allow a maximum difference of one second between the returned `updatedAt` value in any GET request and the expected updatedAt, i.e., the timestamp when the update request was sent from the JUnit test.

You are provided with most of the implementation, but the expected behavior is not achieved as there are some bugs in the given project. You should find and fix the bugs in order to get the expected behavior which is validated by executing a set of JUnit tests. The project by default supports the use of the H2 database.

## Commands
- run: 
```bash
mvn clean package -DskipTests; java -jar target/tradingplatform-1.0.jar
```
- install: 
```bash
mvn clean install
```
- test: 
```bash
mvn clean test
```
