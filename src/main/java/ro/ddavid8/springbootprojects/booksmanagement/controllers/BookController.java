package ro.ddavid8.springbootprojects.booksmanagement.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.ddavid8.springbootprojects.booksmanagement.models.Book;
import ro.ddavid8.springbootprojects.booksmanagement.services.BookService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/booksManagement/books")
public class BookController {

    private final BookService bookServices;


    public BookController(BookService bookServices) {
        this.bookServices = bookServices;
    }

    /**
     * Creates a new book.
     *
     * @param book The Book object to be created.
     * @return The ResponseEntity containing the created Book object.
     */
    @PostMapping()
    public ResponseEntity<Book> createBook(@RequestBody Book book) {
        return ResponseEntity.ok(bookServices.createBook(book));
    }

    /**
     * Retrieves all books.
     *
     * @return The ResponseEntity containing a list of all Book objects.
     */
    @GetMapping()
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(bookServices.getAllBooks());
    }

    /**
     * Updates an existing book.
     *
     * @param id   The ID of the book to be updated.
     * @param book The updated Book object.
     * @return The ResponseEntity containing the updated Book object.
     */
    @PutMapping("/{id}")
    public ResponseEntity<Book> changeBook(@PathVariable UUID id, @RequestBody Book book) {
        return ResponseEntity.ok(bookServices.updateBook(id, book));
    }

    /**
     * Deletes a book.
     *
     * @param id The ID of the book to be deleted.
     * @return The ResponseEntity containing the deleted Book object.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Book> deleteBook(@PathVariable UUID id) {
        return ResponseEntity.ok(bookServices.deleteBook(id));
    }
}
