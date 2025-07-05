package merialdoProject.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import merialdoProject.model.Book;
import merialdoProject.service.BookService;


@Component
public class BookValidator implements Validator {
  @Autowired
  private BookService bookService;

  @Override
  public void validate(Object o, Errors errors) {
    Book book = (Book)o;
    if (book.getTitle()!=null && book.getPublicationYear()!=null
  && bookService.existsByTitleAndPublicationYear(book.getTitle(), book.getPublicationYear())) {
      errors.reject("movie.duplicate");
    }
  }
  
  
  @Override
    public boolean supports(Class<?> aClass) {
      return Book.class.equals(aClass);
    }

}
