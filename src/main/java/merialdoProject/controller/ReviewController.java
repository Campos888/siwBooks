package merialdoProject.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import merialdoProject.model.Book;
import merialdoProject.model.Credentials;
import merialdoProject.model.User;
import merialdoProject.service.ReviewService;
import merialdoProject.service.BookService;
import merialdoProject.service.CredentialsService;
import merialdoProject.service.UserService;

@Controller
public class ReviewController {

	
	@Autowired
	UserService userService; 
	@Autowired
	BookService bookService; 
	@Autowired
	ReviewService commentService;
	@Autowired
	CredentialsService credentialsService;
	
	
	@PostMapping("/addReview")
	public String addComment(@RequestParam("bookId") Long bookId,
	                         @RequestParam("text") String text,
	                         @RequestParam("evaluation") Integer evaluation,
	                         Principal principal) {

	    // Get the user and country
	    User user = credentialsService.findByUsername(principal.getName());
	    Book book = bookService.getBookById(bookId);

	    // Add the comment
	    commentService.addReview(text,evaluation, book, user);

	    // Redirect back to the country's detail page
	    return "redirect:/book/" + bookId;
	}
	
	@PostMapping("/deleteReview")
    public String deleteReview(@RequestParam("reviewId") Long reviewId, Principal principal) {
        User user = credentialsService.findByUsername(principal.getName());
        var review = commentService.getReviewById(reviewId);

        if (review != null && review.getUser().getId().equals(user.getId())) {
            commentService.deleteReview(reviewId);
            return "redirect:/book/" + review.getBook().getId();
        }
        // Se non è autorizzato o la review non esiste, redirect alla home o alla pagina libro se possibile
        return "redirect:/";
    }

	
	
}
