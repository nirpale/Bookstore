package com.example.Bookstore1.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Book {
		
		@Id
		@GeneratedValue(strategy=GenerationType.AUTO)
		private long id;
		private String author, title, isbn;
		private int year;
		private double price;
		
		@ManyToOne
	    @JsonIgnore
	    @JoinColumn(name = "categoryid")
	    private Category category;
		
		public Book() {
			
		}
		
		public Book(long id, String author, String title, String isbn, int year, double price, Category category) {
			super();
			this.id = id;
			this.author = author;
			this.title = title;
			this.isbn = isbn;
			this.year = year;
			this.price = price;
			this.category = category;
		}
		
		public long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getIsbn() {
			return isbn;
		}

		public void setIsbn(String isbn) {
			this.isbn = isbn;
		}

		public int getYear() {
			return year;
		}

		public void setYear(int year) {
			this.year = year;
		}

		public double getPrice() {
			return price;
		}

		public void setPrice(double price) {
			this.price = price;
		}
		
		public Category getCategory() {
			return category;
		}

		public void setCategory(Category category) {
			this.category = category;
		}

		@Override
		public String toString() {
			if (this.category != null)
				return "Book [id=" + id + ", author=" + author + ", title=" + title + ", isbn=" + isbn + ", year=" + year
						+ ", price=" + price + " category =" + this.getCategory() + "]";		
			else
			return "Book [id=" + id + ", author=" + author + ", title=" + title + ", isbn=" + isbn + ", year=" + year
					+ ", price=" + price + "]";
		}
		
}
