package merialdoProject.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Author {


				
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private Long id;
		
		@NotNull
		private Integer bornDate;

		private Integer deathDate;
		
		private String nationality;
		
		@NotBlank
		private String name;

		@NotBlank
		private String surname;
		
		@Column(name = "url_image")
		private String urlImage;
		
		@ManyToMany(mappedBy = "authors")
		private List<Book> books = new ArrayList<>();

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public Integer getBornDate() {
			return bornDate;
		}

		public void setBornDate(Integer bornDate) {
			this.bornDate = bornDate;
		}

		public Integer getDeathDate() {
			return deathDate;
		}

		public void setDeathDate(Integer deathDate) {
			this.deathDate = deathDate;
		}

		public String getNationality() {
			return nationality;
		}

		public void setNationality(String nationality) {
			this.nationality = nationality;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			name = name;
		}

		public String getSurname() {
			return surname;
		}

		public void setSurname(String surname) {
			this.surname = surname;
		}

		public String getUrlImage() {
			return urlImage;
		}

		public void setUrlImage(String urlImage) {
			this.urlImage = urlImage;
		}

		public List<Book> getBooks() {
			return books;
		}

		public void setBooks(List<Book> books) {
			this.books = books;
		}

		@Override
		public int hashCode() {
			return Objects.hash(name, bornDate, deathDate, nationality, surname);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Author other = (Author) obj;
			return Objects.equals(name, other.name) && Objects.equals(bornDate, other.bornDate)
					&& Objects.equals(deathDate, other.deathDate) && Objects.equals(nationality, other.nationality)
					&& Objects.equals(surname, other.surname);
		}
	
		
		
}
