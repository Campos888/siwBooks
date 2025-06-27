package merialdoProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import merialdProject.utils.CountryUtils;
import merialdoProject.model.Author;
import merialdoProject.model.Book;
import merialdoProject.service.AuthorService;
import merialdoProject.service.BookService;

@Controller
public class siwBooksController {

	@Autowired
	BookService bookService;
	
	@Autowired
	AuthorService authorService;
	
	
	
	
	
	
	
	@GetMapping("/")
    public String index(Model model) {
        return "indexSiwBooks.html"; // must match one of your templates (e.g., movies.html)
    }
	
	
	@GetMapping("/books")
	public String showBooks(Model model) {
		model.addAttribute("books", this.bookService.getAllBooks());
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
	public String getBook(@PathVariable("id") Long id, Model model) {
		Book book=bookService.getBookById(id);
		model.addAttribute("book",book);
		return "book.html";
	}
	
	
}
