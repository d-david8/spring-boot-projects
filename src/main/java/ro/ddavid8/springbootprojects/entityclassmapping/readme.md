# Student API

This api manages operations related to student entities using a PostgreSQL database.

## 1. Create Student

Creates a new student.

URL: `/api/entityClassMapping/students`

Method: `POST`

Request Body:

```json
{
  "firstName": "John",
  "lastName": "Doe",
  "email": "johndoe@example.com"
}
```

Success Response:

Code: `200`

```json
{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe",
  "email": "johndoe@example.com"
}
```

Error Response:

Code: `400 BAD REQUEST`

## 2. Update Student

Updates an existing student by ID.

URL: `/api/entityClassMapping/students/{id}`

Method: `PUT`

Request Body:

```json
{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe",
  "email": "johndoe@example.com"
}
```

Success Response:

Code: 200

```json
{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe",
  "email": "johndoe@example.com"
}
```

Error Response:

Code:   `400 BAD REQUEST` `404 NOT FOUND`

## 3. Delete Student

Deletes an existing student by ID.

URL: `/api/entityClassMapping/students/{id}`

Method: `DELETE`

Success Response:

Code: 200

Content:

```json
{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe",
  "email": "johndoe@example.com"
}
```

Error Response:

Code: `404 NOT FOUND`

## 4. Find Student by Name

Finds students by their first name or/and last name.

URL: `/api/entityClassMapping/students`

Method: `GET`

Query Parameters:

`firstName` (optional): First name of the student.
`lastName`  (optional): Last name of the student.

Success Response:

Code: 200

```json
[
  {
    "id": 1,
    "firstName": "John",
    "lastName": "Doe",
    "email": "johndoe@example.com"
  },
  {
    "id": 2,
    "firstName": "Jane",
    "lastName": "Doe",
    "email": "janedoe@example.com"
  }
]
```

## 5. Find Student by Email

URL `/api/entityClassMapping/students/getStudentByEmail`

Method: `GET`

Query Parameters:

`email`: Email address of the student.

Success Response:

Code: 200

```json
{
  "id": 1,
  "firstName": "John",
  "lastName": "Doe",
  "email": "johndoe@example.com"
}
```

Error Response:

Code: `404 NOT FOUND`