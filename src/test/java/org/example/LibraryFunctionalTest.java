// LibraryFunctionalTest.java
package org.example;

import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryFunctionalTest {

    @Test
    void testLibraryScenario() throws IOException {
        Library library = new Library();

        library.addBook(new Book("1984", "George Orwell", 1949));
        library.addBook(new Book("Dune", "Frank Herbert", 1965));
        library.removeBookByTitle("1984");

        List<Book> books = library.getAllBooks();
        assertEquals(1, books.size());
        assertEquals("Dune", books.getFirst().getTitle());

        library.exportBooksToTxt("books.txt");
        System.out.println(books.getFirst());
    }
}