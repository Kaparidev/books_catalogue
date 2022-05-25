package book.catalogue.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import book.catalogue.entity.Book;
import book.catalogue.service.BookService;


@Controller
//@RestController
public class BookController {
	
	public BookService bookService;

	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	// handler method to handle list book and return mode and view
	@GetMapping("/books")
	public String listBooks(Model model) {
		model.addAttribute("books", bookService.getAllBooks());
		return "books";
	}
	
	@GetMapping("/books/new")
	public String createBookForm(Model model) {
		
		// create book object to hold book form data
		Book bookObject = new Book();
		model.addAttribute("bookObject", bookObject);
		return "add_book";
		
	}
	
	@PostMapping("/books")
	public String saveBook(@ModelAttribute("bookObject") Book bookObject) {
		bookService.saveBook(bookObject);
		return "redirect:/books";
	}
	
	@GetMapping("/books/edit/{id}")
	public String editBookForm(@PathVariable Long id, Model model) {
		model.addAttribute("bookObject", bookService.getBookById(id));
		return "update_book";
	}

	@PostMapping("/books/{id}")
	public String updateBook(@PathVariable Long id,
			@ModelAttribute("bookObject") Book bookObject,
			Model model) {
		
		// get book from database by id
		Book existingBook = bookService.getBookById(id);
		existingBook.setId(id);
		existingBook.setbookName(bookObject.getbookName());
		existingBook.setisbnNumber(bookObject.getisbnNumber());
		existingBook.setpublishDate(bookObject.getpublishDate());
		existingBook.setPrice(bookObject.getPrice());
		existingBook.setType(bookObject.getType());
		
		// save updated book object
		bookService.updateBook(existingBook);
		return "redirect:/books";		
	}
	
	// handler method to handle delete book request
	
	@GetMapping("/books/{id}")
	public String deleteBook(@PathVariable Long id) {
		bookService.deleteBookById(id);
		return "redirect:/books";
	}
	
}
