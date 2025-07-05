package merialdoProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import merialdoProject.model.Book;


public interface BookRepository extends CrudRepository<Book,Long>{
	List<Book> findByAuthorsNameStartingWithIgnoreCaseOrAuthorsSurnameStartingWithIgnoreCase(String name, String surname);
	List<Book> findByTitleStartingWithIgnoreCase(String title);
	boolean existsByTitleAndPublicationYear(String title, Integer year);	

}
