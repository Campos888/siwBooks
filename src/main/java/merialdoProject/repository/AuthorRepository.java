package merialdoProject.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import merialdoProject.model.Author;


public interface AuthorRepository extends CrudRepository<Author,Long>{
	 List<Author> findByNameStartingWithIgnoreCaseOrSurnameStartingWithIgnoreCase(String name, String surname);

	boolean existsByNameAndSurname(String name, String surname);
	
	
}
