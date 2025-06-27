package merialdoProject.model;

import java.time.LocalDateTime;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String text;

    private Integer evaluation;
    
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "book_id")  // owns the FK to Country
    private Book book;

    @ManyToOne
    @JoinColumn(name = "user_id")     // owns the FK to User
    private User user;
    
    
    public Review() {
        // Required by JPA
    }

    
    
    public Review(String text, Integer evaluation, User user, Book book) {
        this.text = text;
        this.evaluation = evaluation;
        this.user = user;
        this.book = book;
        this.createdAt = LocalDateTime.now();
    }
    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}



	public Integer getEvaluation() {
		return evaluation;
	}



	public void setEvaluation(Integer evaluation) {
		this.evaluation = evaluation;
	}



	public Book getBook() {
		return book;
	}



	public void setBook(Book book) {
		this.book = book;
	}



	@Override
	public int hashCode() {
		return Objects.hash(book, createdAt, evaluation, text, user);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Review other = (Review) obj;
		return Objects.equals(book, other.book) && Objects.equals(createdAt, other.createdAt)
				&& Objects.equals(evaluation, other.evaluation) && Objects.equals(text, other.text)
				&& Objects.equals(user, other.user);
	}

	



}
