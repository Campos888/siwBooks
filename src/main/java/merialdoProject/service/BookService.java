package merialdoProject.service;

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

	
}
