package ro.ddavid8.springbootprojects.booksmanagement.services;

import ro.ddavid8.springbootprojects.booksmanagement.models.Book;

import java.util.List;
import java.util.UUID;

public interface BookService {

    Book createBook(Book book);

    List<Book> getAllBooks();

    Book updateBook(UUID id, Book book);

    Book deleteBook(UUID id);
}
