package merialdoProject.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import merialdoProject.model.Author;
import merialdoProject.model.Book;
import merialdoProject.service.AuthorService;
import merialdoProject.service.BookService;
import merialdoProject.service.CredentialsService;
import merialdoProject.utils.CountryUtils;

@Controller
public class siwBooksController {

	@Autowired
	BookService bookService;
	
	@Autowired
	AuthorService authorService;
	
	@Autowired
	CredentialsService credentialsService;
	
	
	
	
	@GetMapping("/")
    public String index(Model model) {
        return "indexSiwBooks.html"; // must match one of your templates (e.g., movies.html)
    }
	
	
	@GetMapping("/books")
	public String showAllBooks(Model model) {
		List<Book> books = (List<Book>) this.bookService.getAllBooks();
		model.addAttribute("books",books);
		return "books.html";
}
	
	
	@GetMapping("/authors")
	public String showAuthors(Model model) {
		model.addAttribute("authors", this.authorService.getAllAuthors());
		return "authors.html";
	}
	
	
	@GetMapping("/author/{id}")
	public String getAuthor(@PathVariable("id") Long id, Model model) {
	    Author author = authorService.getAuthorById(id);
	    
	    String countryCode = CountryUtils.getCountryCodeByNationality(author.getNationality());
	    
	    model.addAttribute("countryCode", countryCode);
	    System.out.println("Nationality: " + author.getNationality() + ", Country code: " + countryCode);
	    model.addAttribute("author", author);
	    
	    return "author.html";
	}
	
	
	@GetMapping("/book/{id}")
	public String getBook(@PathVariable("id") Long id, Model model, Principal principal) {
	    Book book = bookService.getBookById(id);
	    model.addAttribute("book", book);
	    return "book.html"; // o il nome corretto del tuo template
	}

	
	
	
	@GetMapping("/admin/formAddBook")
	public String formAddBook(Model model) {
	    model.addAttribute("book", new Book());
	    model.addAttribute("authors", authorService.getAllAuthors());
	    return "formAddBook.html";  // Changed to match books, not countries
	}

	@PostMapping("/admin/addBook")
	public String addBook(@ModelAttribute Book book, @RequestParam List<Long> authorIds) {

	    List<Author> authors = new ArrayList<>();
	    for (Long id : authorIds) {
	        Author author = authorService.getAuthorById(id);
	        authors.add(author);
	        author.getBooks().add(book); // Link the book to the author
	    }

	    book.setAuthors(authors); // Link authors to the book (if it's a bidirectional relationship)

	    bookService.save(book); // Save the book (and authors, if cascaded)

	    return "redirect:/books";
	}

	

	
	
}
