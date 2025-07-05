package merialdoProject.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import merialdoProject.model.Book;
import merialdoProject.repository.BookRepository;

@Service
public class BookService {


		@Autowired
		private BookRepository bookRepository;
		
		
		
	
		
		public Book getBookById(Long id) {
			return bookRepository.findById(id).get();
		}
		
		
		public Iterable<Book> getAllBooks(){
			return bookRepository.findAll();
		}
		
		public Book save(Book book) {
	        return bookRepository.save(book); 
	    }
		public List<Book> searchBooksByTitleOrAuthorStartingWith(String query) {
			
		    List<Book> booksByTitle = bookRepository.findByTitleStartingWithIgnoreCase(query);
		    List<Book> booksByAuthor = bookRepository.findByAuthorsNameStartingWithIgnoreCaseOrAuthorsSurnameStartingWithIgnoreCase(query, query);

		 
		    Set<Book> results = new HashSet<>();
		    results.addAll(booksByTitle);
		    results.addAll(booksByAuthor);

		    return new ArrayList<>(results);
		}
		
	
		public void deleteById(Long id) {
			  bookRepository.deleteById(id);
			 }


		public boolean existsByTitleAndPublicationYear(String title, Integer year) {
			  return bookRepository.existsByTitleAndPublicationYear(title, year);
			 }


	

	
}
