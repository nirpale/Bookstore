package com.example.Bookstore1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore1.domain.Book;
import com.example.Bookstore1.domain.BookRepository;
import com.example.Bookstore1.domain.Category;
import com.example.Bookstore1.domain.CategoryRepository;

@SpringBootApplication
public class Bookstore1Application {

	public static void main(String[] args) {
		SpringApplication.run(Bookstore1Application.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository) {
		return (args) -> {
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Scifi"));
			crepository.save(new Category("Thriller"));
			crepository.save(new Category("Horror"));
			crepository.save(new Category("History"));
			crepository.save(new Category("Other"));
			
			repository.save(new Book(0, "Stephanie Meyer", "Twilight", "14565-47", 2014,(double) 25.90, crepository.findByName("Fantasy").get(0)));
			
		};
	}
}

