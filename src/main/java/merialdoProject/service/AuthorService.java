package merialdoProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import merialdoProject.model.Author;
import merialdoProject.repository.AuthorRepository;

@Service
public class AuthorService {
	

		@Autowired
		private AuthorRepository authorRepository;
		
		public Author getAuthorById(Long id) {
			return authorRepository.findById(id).get();
		}
		
		public Iterable<Author> getAllAuthors(){
			return authorRepository.findAll();
		}
		
		public Author save(Author author) {
	        return authorRepository.save(author); 
	    }
		 public List<Author> findByNameStartingWithOrSurnameStartingWith(String name, String surname) {
		        return authorRepository.findByNameStartingWithIgnoreCaseOrSurnameStartingWithIgnoreCase(name, surname);
		    }


	
}
