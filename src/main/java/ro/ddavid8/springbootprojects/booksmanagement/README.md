# Books Management

This API provides access to a collection of books and offers the following endpoints:

## **1. Add a Book**

- Description: Allows you to add a new book to the collection.
- Endpoint: `/api/booksManagement/books`
- Method: `POST`
- Request Body:

```json
{
  "title": "Alice in Wonderland",
  "author": "John Doe",
  "pageNo": 100,
  "description": "short description"
}
```

## **2. Get All Books**

- Description: Retrieves a list of all available books in the collection.
- Endpoint: `/api/booksManagement/books`
- Method: `GET`

## **3. Update a Book**

- Description: Allows you to update the details of a specific book identified by its unique ID.
- Endpoint: `/api/booksManagement/books{id}`
- Method: `PUT`
- Request Body:

```json
{
  "title": "New title",
  "author": "New author",
  "pageNo": 10,
  "description": "new description"
}
```

## **4. Delete a Book**

- Description: Removes a book from the collection based on its unique ID.
- Endpoint: `/api/books/{id}`
- Method: `DELETE`