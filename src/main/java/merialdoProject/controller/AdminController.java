package merialdoProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.task.TaskExecutionProperties.Mode;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import merialdoProject.model.Author;
import merialdoProject.model.Book;
import merialdoProject.service.AuthorService;
import merialdoProject.service.BookService;
import merialdoProject.validator.AuthorValidator;
import merialdoProject.validator.BookValidator;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @Autowired
    BookService bookService;
    
    @Autowired
    BookValidator bookValidator;
    
    @Autowired
    AuthorService authorService; 
    
    @Autowired
    AuthorValidator authorValidator; 
    
   
    
    
    @GetMapping
    public String adminHome() {
        return "admin/indexAdmin";
    }

    @GetMapping("/books")
    public String adminBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "admin/booksAdmin";
    }

    @GetMapping("/books/create")
    public String formAddBook(Model model) {
        model.addAttribute("book", new Book());
        return "admin/formAddBookAdmin";
    }
    
    @PostMapping("/books/create")
    public String newBook(@Valid @ModelAttribute("book") 	Book book, BindingResult bindingResult, Model model) {
     this.bookValidator.validate(book, bindingResult); 
     if (bindingResult.hasErrors()) { // sono emersi errori nel binding
             return "admin/formAddBookAdmin.html";
          }
         else {                         // NON sono emersi errori nel binding
            this.bookService.save(book);
            model.addAttribute("book", book);
            return "redirect:/admin/books";


        }
    }
    
    @PostMapping("/deleteBooks/{id}")
    public String deleteBooks (@PathVariable("id") Long id, Model model) {
    	   this.bookService.deleteById(id);
    	   model.addAttribute("books", this.bookService.getAllBooks());
    	   return "admin/booksAdmin";
     }
    
    @GetMapping("/book/edit/{id}")
    public String editBookForm(@PathVariable("id") Long id, Model model) {
        Book book = bookService.getBookById(id); // o getBook(id)
        if (book == null) {
            return "redirect:/admin/books"; // se non trovato, ritorna alla lista
        }
        model.addAttribute("book", book);
        return "admin/editBookAdmin";
    }
    
    @PostMapping("/book/update")
    public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model) {
        bookValidator.validate(book, bindingResult);
        if (bindingResult.hasErrors()) {
            return "admin/editBookAdmin";
        }
        bookService.save(book); // Se esiste aggiorna, se no crea
        return "redirect:/admin/books";
    }


    @GetMapping ("/authors")
    public String adminAuthors(Model model) {
    	model.addAttribute("authors", authorService.getAllAuthors());
    	return "admin/authorsAdmin";
    }
    


    @GetMapping("/authors/create")
    public String formAddAuthors(Model model) {
        model.addAttribute("author", new Author());
        return "admin/formAddAuthorAdmin";
    }
    
    
    @PostMapping("/author/create")
    public String newAuthor(@Valid @ModelAttribute("author") Author author, BindingResult bindingResult, Model model) {
     this.authorValidator.validate(author, bindingResult); 
     if (bindingResult.hasErrors()) { // sono emersi errori nel binding
             return "admin/formAddAuthorAdmin.html";
          }
         else {                         // NON sono emersi errori nel binding
            this.authorService.save(author);
            model.addAttribute("author", author);
            return "redirect:/admin/author";


        }
    }
    @PostMapping("/deleteAuthor/{id}")
    public String deleteAuthors (@PathVariable("id") Long id, Model model) {
    	   this.authorService.deleteById(id);
    	   model.addAttribute("authors", this.authorService.getAllAuthors());
    	   return "admin/authorsAdmin";
     }
    
    @GetMapping("/author/edit/{id}")
    public String editAuthorForm(@PathVariable("id") Long id, Model model) {
        Author author = authorService.getAuthorById(id); // o getBook(id)
        if (author == null) {
            return "redirect:/admin/authors"; // se non trovato, ritorna alla lista
        }
        model.addAttribute("author", author);
        return "admin/editAuthorAdmin";
    }
    
    @PostMapping("/author/update")
    public String updateAuthor(@Valid @ModelAttribute("author") Author author, BindingResult bindingResult, Model model) {
        authorValidator.validate(author, bindingResult);
        if (bindingResult.hasErrors()) {
            return "admin/editAuthorAdmin";
        }
        authorService.save(author); // Se esiste aggiorna, se no crea
        return "redirect:/admin/author";
    }


}
