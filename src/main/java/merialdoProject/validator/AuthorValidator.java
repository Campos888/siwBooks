package merialdoProject.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import merialdoProject.model.Author;
import merialdoProject.service.AuthorService;

@Component
public class AuthorValidator implements Validator {

    @Autowired
    private AuthorService authorService;

    @Override
    public boolean supports(Class<?> clazz) {
        return Author.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Author author = (Author) target;

        if (author.getName() != null && author.getSurname() != null &&
            authorService.existsByNameAndSurname(author.getName(), author.getSurname())) {
            errors.reject("author.duplicate", "Un autore con lo stesso nome e cognome esiste già.");
        }
    }
}
