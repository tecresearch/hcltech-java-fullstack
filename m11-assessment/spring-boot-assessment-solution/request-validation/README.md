## Environment:
- Java version: 17
- Maven version: 3.*
- Spring Boot version: 3.0.6

## Read-Only Files:
- src/test/*

## Requirements:
There is a tiny `employee information system` built using Spring Boot. Currently, the system accepts employee information as `Employee` objects from the client requests, but it lacks the validation of the `Employee` object attributes that checks for correctness. The application owner doesn't want invalid data to be saved in the system, meaning that employee information should be validated according to the given constraints. The REST API request is validated by using the `@Valid` request Bean Validation or programmatically by implementing a custom request validator. This question deals with setting up a custom request validator in order to validate a RESTful API request.

The given project has all the classes defined for accepting requests from clients and saving employee information into the database. It also uses a custom request validator `EmployeeValidator`  to validate each `Employee` request object before saving it into the database. However, the validator currently does nothing, meaning it doesn't report any errors upon receiving invalid data. Your task is to complete the implementation of the custom request validator class `EmployeeValidator` so that it reports errors.

The validation constraints are given below:
1. `fullName`: 
    * validation: check if it's null or empty
    * message: The fullName is a mandatory field
2. `mobileNumber`:
    * validation: check if it's null or not of 10 digits
    * message: The mobileNumber is a mandatory field
3. `emailId`:
    * validation: check if it's null or empty
    * message: The emailId is a mandatory field
    * validation: check if it doesn't contain the @ sign
    * message: The emailId should be in a valid email format
4. `dateOfBirth`:
    * validation: check if it's null or empty
    * message: The dateOfBirth is a mandatory field
    * validation: check if it's not in YYYY-MM-DD format
    * message: The dateOfBirth should be in YYYY-MM-DD format
    
NOTE: All the validation error messages must be reported in the same order as the corresponding field declaration order. 

There is a single REST API endpoint exposed for receiving employee information.

`POST` request to `/employee`:
* accepts an `Employee` object as a request body
* calls employee validator
* if there are no errors, then it returns status code 200
* if there are any errors, then `EmployeeValidationErrorHandler` returns a list of validation error messages `List<FieldValidationMessage>` with status code 400

Your task is to complete the given project so that it passes all the test cases when running the provided unit tests.

## Commands
- run: 
```bash
mvn clean package -DskipTests && java -jar target/requestvalidator-1.0.jar
```
- install: 
```bash
mvn clean install
```
- test: 
```bash
mvn clean test
```
