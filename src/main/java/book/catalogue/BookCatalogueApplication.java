package book.catalogue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import book.catalogue.entity.Book;
import book.catalogue.repository.BookRepository;

@SpringBootApplication
public class BookCatalogueApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BookCatalogueApplication.class, args);
	}

	@Autowired
	private BookRepository bookRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		  Book book1 = new Book("Animal Farm", "978-3-16-148410-0", "01/12/1984", 50.00, "ebook");
		  bookRepository.save(book1);
		  
		 Book book2 = new Book("To kill a mockingbird", "323-5-88-776380-9", "15/02/2001", 30.50, "Soft Cover");
		 bookRepository.save(book2);
		 
		 Book book3 = new Book("12 rules for  life", "989-9-58-547510-3", "15/02/2010", 20.25, "Hard Cover");
		 bookRepository.save(book3);
		
		
	}

}
