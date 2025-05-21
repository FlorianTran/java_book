package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    void testAddBook() {
        Book book = new Book("1984", "George Orwell", 1949);
        library.addBook(book);
        assertEquals(1, library.getAllBooks().size());
    }

    @Test
    void testRemoveBookByTitle() {
        library.addBook(new Book("Dune", "Frank Herbert", 1965));
        assertTrue(library.removeBookByTitle("Dune"));
        assertEquals(0, library.getAllBooks().size());
    }

    @Test
    void testFindBookByTitle() {
        Book book = new Book("1984", "George Orwell", 1949);
        library.addBook(book);
        assertNotNull(library.findBookByTitle("1984"));
    }

    @Test
    void testGetAllBooks() {
        library.addBook(new Book("Dune", "Frank Herbert", 1965));
        library.addBook(new Book("1984", "George Orwell", 1949));
        List<Book> books = library.getAllBooks();
        assertEquals(2, books.size());
        assertEquals("1984", books.getFirst().getTitle());
    }

    @Test
    void testFindBooksByPartialTitle() {
        library.addBook(new Book("Harry Potter and the Goblet of Fire", "J.K. Rowling", 2000));
        List<Book> found = library.findBooksByPartialTitle("goblet");
        assertEquals(1, found.size());
    }

    @Test
    void testGetAuthorAndYear() {
        Book book = new Book("Test Title", "Test Author", 2020);
        assertEquals("Test Author", book.getAuthor());
        assertEquals(2020, book.getYear());
    }
}
