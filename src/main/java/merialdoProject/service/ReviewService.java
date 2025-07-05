package merialdoProject.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import merialdoProject.model.User;
import merialdoProject.model.Book;
import merialdoProject.model.Review;
import merialdoProject.repository.ReviewRepository;
import merialdoProject.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private BookService bookService;

	
	
	public List<Review> getReviewByBook(Long bookId) {
        Book book = bookService.getBookById(bookId);
        List<Review> allReviews = (List<Review>) reviewRepository.findAll();
        return allReviews.stream()
                .filter(c -> c.getBook().getId().equals(book.getId()))
                .collect(Collectors.toList());
    }
	

    // You can still have this for saving comments
    public void addReview(String text, Integer evaluation, Book book,User user) {
        Review review = new Review(text,evaluation, user, book);
        reviewRepository.save(review);
    }
    
 // Recupera una review tramite id
    public Review getReviewById(Long reviewId) {
        Optional<Review> reviewOpt = reviewRepository.findById(reviewId);
        return reviewOpt.orElse(null);
    }
    
    // Cancella la review con id specificato
    public void deleteReview(Long reviewId) {
        reviewRepository.deleteById(reviewId);
    }
	
}
