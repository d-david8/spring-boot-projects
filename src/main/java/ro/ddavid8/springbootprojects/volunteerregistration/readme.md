# volunteer-registration

**Endpoint: POST /volunteers**

This endpoint allows volunteers to sign up for upcoming events by submitting their data to the server.

## Add Volunteer

Adds a new volunteer to the system.

- URL: `/api/volunteers`
- Method: `POST`
- Request Body:

```json {
{
  "name": "John Doe",
  "email": "john.doe@example.com",
  "phone": "01234567890",
  "event": "event1"
}
```

- Success Response: `200`

```json
  "Volunteer added successfully."
```

```json
  "An error occurred while saving volunteer information. Error: ..."
```