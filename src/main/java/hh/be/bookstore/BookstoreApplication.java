package hh.be.bookstore;

import hh.be.bookstore.domain.Book;
import hh.be.bookstore.domain.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BookstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookstoreApplication.class, args);
    }

    @Bean
    CommandLineRunner demo(BookRepository repository) {
        return (args) -> {
            repository.save(new Book("Harri Potter ja salaisuuksien kammio", "J.K Rowling", 1998, "1232323-21", 19.99));
            repository.save(new Book("Hobitti", "J.R.R. Tolkien", 1937, "1234567-89", 25.00));

            System.out.println("Books found in database:");
            repository.findAll().forEach(book -> {
                System.out.println(book.toString());
            });
        };
    }
}
