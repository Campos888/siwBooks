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
import merialdoProject.model.Book;
import merialdoProject.service.BookService;
import merialdoProject.validator.BookValidator;

@Controller
@RequestMapping("/admin")
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {

    @Autowired
    BookService bookService;
    
    @Autowired
    BookValidator bookValidator;
    
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


    
    
    

}
