# Send email

## 1. Create an account and send an confirmation email

- URL: `/api/sendEmail/users`
- Method: `POST`
- Description: Create a user account and send an confirmation email.
- Request Body:

```json
{
  "firstName": "Dan",
  "lastName": "David",
  "email": "test@d-david8.ro"
}
```

- Response:

```json
{
  "errorCode": null,
  "message": "User was created successfully, and the activation mail was send with success"
}
```

## 2. Get account details by id

- URL: `/api/sendEmail/users/{id}`
- Method: `GET`
- Description: Retrieve user's account details by id.
- Response body:

```json
{
  "id": "ae1f8822-7299-4e6a-bf7b-7682ee5f22eb",
  "firstName": "Dan",
  "lastName": "David",
  "email": "test@d-david8.ro",
  "createdAt": "2023-10-25T22:23:41.580147"
}
```

## 3. Get all users

- URL: `/api/sendEmail/users`
- Method: `GET`
- Description: Retrieve all users registered in the system.
- Response body:

```json
[
  {
    "id": "ae1f8822-7299-4e6a-bf7b-7682ee5f22eb",
    "firstName": "Dan",
    "lastName": "David",
    "email": "test@d-david8.ro",
    "createdAt": "2023-10-25T22:23:41.580147"
  },
  {
    "id": "8735af7b-1809-422c-97eb-c4c25f71236d",
    "firstName": "John",
    "lastName": "Doe",
    "email": "test@d-david8.ro",
    "createdAt": "2023-10-25T22:33:57.85274"
  }
]
```

## Application Configuration - application.properties

### SMTP Server Configuration

* spring.mail.host - Specifies the hostname of the SMTP server used for sending emails.
* spring.mail.port - Specifies the port number of the SMTP server for email communication.
* spring.mail.username - The username required for authentication with the SMTP server (usually an email address).
* spring.mail.password - The password associated with the SMTP server username for authentication.
* spring.mail.properties.mail.smtp.auth - Indicates whether SMTP authentication should be enabled (set to `true`).
* spring.mail.properties.mail.smtp.starttls.enable - Specifies whether STARTTLS should be enabled for secure
  communication with the SMTP server

### Application Properties

* application.sender.email - You can provide a default sender's email address for outgoing emails if needed.
* application.name - The name or identifier for the application.
* application.support.email - The email address where users can contact for support related to the application.
* application.sender.name - The name of the sender or the company associated with outgoing emails.