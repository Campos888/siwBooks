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
import org.springframework.web.bind.annotation.RequestParam;

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
        
        List<Author> availableAuthors = (List<Author>) authorService.getAllAuthors();
        model.addAttribute("availableAuthors", availableAuthors);
        
        return "admin/editBookAdmin";
    }
    
    
    
    
    /*
    @PostMapping("/book/update")
    public String updateBook(@Valid @ModelAttribute("book") Book book, BindingResult bindingResult, Model model) {
        bookValidator.validate(book, bindingResult);
        if (bindingResult.hasErrors()) {
            return "admin/editBookAdmin";
        }
        else {
        	Book bookToUpdate = bookService.getBookById(book.getId());
        	bookToUpdate.setTitle(book.getTitle());
        	bookToUpdate.setPublicationYear(book.getPublicationYear());

            bookService.save(bookToUpdate);

            return "redirect:/admin/books";
        }
    }

    
    */
    
//------------------------------------
    
    /*
    @PostMapping("/book/update")
    public String updateBook(@Valid @ModelAttribute("book") Book book,
                             BindingResult bindingResult,
                             @RequestParam(value = "newAuthorNameAndSurname", required = false) String newAuthorName,
                             Model model) {

        bookValidator.validate(book, bindingResult);
        if (bindingResult.hasErrors()) {
            return "admin/editBookAdmin";
        }

        Book existingBook = bookService.getBookById(book.getId());
        if (existingBook == null) {
            bindingResult.reject("notfound", "Book not found");
            return "admin/editBookAdmin";
        }

        // Update book fields
        existingBook.setTitle(book.getTitle());
        existingBook.setPublicationYear(book.getPublicationYear());



        // Handle new author
        if (newAuthorNameAndSurname != null && !newAuthorNameAndSurname.trim().isEmpty()) {
            // Assuming case-insensitive match; adjust as needed
            Author author = authorService.findByNameAndSurname(newAuthorNameAndSurname.trim());
    		if (author != null){
    			if (!existingBook.getAuthors().contains(author)) {
                	existingBook.getAuthors().add(author);
                	
            	}
    			if (!author.getBooks().contains(existingBook)) {
                	author.getBooks().add(existingBook);
                	authorService.save(author);
            	}
    		}
        }

        bookService.save(existingBook);
        return "redirect:/admin/book/edit/" + existingBook.getId(); // stay on edit page
    }

    */
    
    //------------------------------------
    
    /*
    @PostMapping("/book/update")
    public String updateBook(@Valid @ModelAttribute("book") Book book,
                             BindingResult bindingResult,
                             @RequestParam(value = "authorName", required = false) String authorName,
                             Model model) {

        bookValidator.validate(book, bindingResult);
        if (bindingResult.hasErrors()) {
            return "admin/editBookAdmin";
        }

        // Fetch existing book to avoid overwriting authors
        Book existingBook = bookService.getBookById(book.getId());
        if (existingBook == null) {
            bindingResult.reject("notfound", "Libro non trovato.");
            return "admin/editBookAdmin";
        }

        // Update fields
        existingBook.setTitle(book.getTitle());
        existingBook.setPublicationYear(book.getPublicationYear());

        // Add new author if provided
        if (authorName != null && !authorName.trim().isEmpty()) {
            

                Author author = authorService.findByNameStartingWithOrSurnameStartingWith(authorName, authorName);
               

                if (!existingBook.getAuthors().contains(author)) {
                    existingBook.getAuthors().add(author);
                }
            } else {
                // Invalid format
                bindingResult.rejectValue("title", "invalidAuthorFormat", "Inserisci nome e cognome separati da uno spazio.");
                return "admin/editBookAdmin";
            }
        }

        bookService.save(existingBook);
        return "redirect:/admin/book/edit/" + existingBook.getId();
    }
*/
    
    
    @PostMapping("/book/update")
    public String updateBook(@Valid @ModelAttribute("book") Book book,
                             BindingResult bindingResult,
                             @RequestParam(value = "selectedAuthorId", required = false) Long selectedAuthorId,
                             Model model) {


    	
        Book existingBook = bookService.getBookById(book.getId());
  
        existingBook.setTitle(book.getTitle());
        existingBook.setPublicationYear(book.getPublicationYear());

        if( selectedAuthorId != null) {
        	Author author = authorService.getAuthorById(selectedAuthorId);
        	author.getBooks().add(existingBook);
        	existingBook.getAuthors().add(author);
        	authorService.save(author);
        }

        bookService.save(existingBook);
        
        
        model.addAttribute("book", existingBook);
        model.addAttribute("availableAuthors", authorService.getAllAuthors());
        return "redirect:/admin/book/edit/" + existingBook.getId();
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
