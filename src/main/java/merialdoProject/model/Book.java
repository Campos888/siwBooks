package merialdoProject.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Book {

	
	
			
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		
		@NotNull
		private Integer publicationYear;
		
		@NotBlank
		private String title;
		
		@Column(name = "url_images")
		private List<String> urlImages;
		
		@ManyToMany
		private List<Author> authors = new ArrayList<>();
		

		@OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
		private List<Review> reviews = new ArrayList<>();
		
		
		
		
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Integer getPublicationYear() {
			return publicationYear;
		}

		public void setPublicationYear(Integer publicationYear) {
			this.publicationYear = publicationYear;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public List<String> getUrlImages() {
			return urlImages;
		}

		public void setUrlImages(List<String> urlImages) {
			this.urlImages = urlImages;
		}

		public List<Author> getAuthors() {
			return authors;
		}

		public void setAuthors(List<Author> authors) {
			this.authors = authors;
		}
		
		
		

		public List<Review> getReviews() {
			return reviews;
		}

		public void setReviews(List<Review> reviews) {
			this.reviews = reviews;
		}

		@Override
		public int hashCode() {
			return Objects.hash(title, authors, publicationYear);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Book other = (Book) obj;
			return Objects.equals(title, other.title) && Objects.equals(authors, other.authors)
					&& Objects.equals(publicationYear, other.publicationYear);
		}
		
		
	
}
