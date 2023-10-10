package seminars.fourth.book;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BookServiceTest {

    @Test
    void findBookById() {
        BookRepository bookRepositoryMock
                = mock(BookRepository.class);
        when(bookRepositoryMock.findById("1")).thenReturn(
                new Book("1", "Физика", "А.А. Детлаф"));

        BookService bookService = new BookService(bookRepositoryMock);
        Book book = bookService.findBookById("1");

        assertEquals(book.getTitle(), "Физика");
        assertEquals(book.getAuthor(), "А.А. Детлаф");
    }

    @Test
    void findAllBooks() {
        BookRepository bookRepositoryMock
                = mock(BookRepository.class);
        List<Book> booksExpected = new ArrayList<>();
        booksExpected.add(new Book("1", "Физика", "А.А. Детлаф"));
        booksExpected.add(new Book("2", "Математика", "Я.Б. Зельдович"));
        when(bookRepositoryMock.findAll()).thenReturn(booksExpected);

        BookService bookService = new BookService(bookRepositoryMock);
        List<Book> booksActual = bookService.findAllBooks();

        assertEquals(booksActual.size(), 2);
        assertEquals(booksActual.get(0).getId(), "1");
        assertEquals(booksActual.get(0).getTitle(), "Физика");
        assertEquals(booksActual.get(0).getAuthor(), "А.А. Детлаф");
        assertEquals(booksActual.get(1).getId(), "2");
        assertEquals(booksActual.get(1).getTitle(), "Математика");
        assertEquals(booksActual.get(1).getAuthor(), "Я.Б. Зельдович");
    }
}