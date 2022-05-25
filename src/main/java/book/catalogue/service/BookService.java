package book.catalogue.service;

import java.util.List;

import book.catalogue.entity.Book;

public interface BookService {
	List<Book> getAllBooks();
	
	Book saveBook(Book book);
	
	Book getBookById(Long id);
	
	Book updateBook(Book book);
	
	void deleteBookById(Long id);
}
