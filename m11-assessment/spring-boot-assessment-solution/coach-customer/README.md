## Environment
- Java version: 17
- Maven version: 3.*
- Spring Boot version: 3.2.2

## Read-Only Files
- src/test/*

## Commands
- run:
```bash
mvn clean spring-boot:run
```
- install:
```bash
mvn clean install
```
- test:
```bash
mvn clean test
```

## Sample Data
<details open>
<summary>Example of customer data JSON Object:</summary>

```json
{
  "id": 1,
  "height": 180,
  "weight": 80,
  "coach": {
    "id": 1,
    "name": "Alex Doe"
  }
}
```
Example of coach data JSON Object:
```json
{
  "id": 1,
  "name": "Alex Doe"
}
```
</details>

## Requirements

This project is a practical assessment designed to evaluate understanding and skills in working with RESTful APIs using Spring Boot.

The project consists of two empty controller classes, `CoachController` and `CustomerController`, that you need to implement. The controllers should have the following endpoints:

#### CustomerController

The REST service must expose the `/api/customer` endpoint, which allows for managing the collection of customer records in the following way:

**POST** request to `/api/customer`:

- Create a new customer
- Accepts a JSON body with `height`, `weight`, and `coach_id` fields
- Return the created record with a `201 Created` status

**GET** request to `/api/customer`:

- Return a list of all customer records in the database sorted by `id` in ascending order

**GET** request to `/api/customer/{id}`:

- Return a customer record with the given `id`
- If the customer record exists, return the record with a `200 OK` status
- If the customer record does not exist, return a `404 Not Found` status

#### CoachController

The REST service must expose the `/api/coach` endpoint, which allows for managing the collection of coach records in the following way:

**POST** request to `/api/coach`:

- Create a new coach
- Accepts a JSON body with a `name` field
- Return the created record with a `201 Created` status

**GET** request to `/api/coach`:

- Return a list of all coach records in the database sorted by `id` in ascending order
- Return the list with a `200 OK` status

**GET** request to `/api/coach/{id}`:

- Return a coach record with the given `id`
- If the coach record exists, return the record with a `200 OK` status
- If the coach record does not exist, return a `404 Not Found` status

Please ensure that all endpoints handle errors appropriately and return the correct HTTP status codes so that all unit tests pass.

## Sample Request & Response
<details><summary>Expand to view details on sample request and response for each endpoint.</summary>

### POST request to `/api/customer`:
Request data JSON Object:
```json
{
  "height": 180,
  "weight": 80,
  "coach_id": 1
}
```

Response JSON Object:
```json
{
  "id": 1,
  "height": 180,
  "weight": 80,
  "coach": {
    "id": 1,
    "name": "Alex Doe"
  }
}
```

### GET request to `/api/customer`:
Response JSON Object:
```json
[
  {
    "id": 1,
    "height": 180,
    "weight": 80,
    "coach": {
      "id": 1,
      "name": "Alex Doe"
    }
  }
]
```

### GET request to `/api/customer/{id}`:
Response JSON Object:
```json
{
  "id": 1,
  "height": 180,
  "weight": 80,
  "coach": {
    "id": 1,
    "name": "Alex Doe"
  }
}
```

### POST request to `/api/coach`:
Request data JSON Object:
```json
{
  "name": "Alex Doe"
}
```
Response JSON Object:
```json
{
  "id": 1,
  "name": "Alex Doe"
}
```
### GET request to `/api/coach`:
Response JSON Object:
```json
[
  {
    "id": 1,
    "name": "Alex Doe"
  },
  {
    "id": 2,
    "name": "Sam"
  }
]
```

### GET request to `/api/coach/{id}`:
Response JSON Object:
```json
{
  "id": 1,
  "name": "Alex Doe"
}
```
</details>
