package com.example.Bookstore1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore1.domain.Book;
import com.example.Bookstore1.domain.BookRepository;
import com.example.Bookstore1.domain.Category;
import com.example.Bookstore1.domain.CategoryRepository;
import com.example.Bookstore1.domain.User;
import com.example.Bookstore1.domain.UserRepository;


@SpringBootApplication
public class Bookstore1Application {

	public static void main(String[] args) {
		SpringApplication.run(Bookstore1Application.class, args);
	}
	
	@Bean
	public CommandLineRunner bookDemo(BookRepository repository, CategoryRepository crepository, UserRepository userrepository) {
		return (args) -> {
			
			crepository.save(new Category("Fantasy"));
			crepository.save(new Category("Scifi"));
			crepository.save(new Category("Thriller"));
			crepository.save(new Category("Horror"));
			crepository.save(new Category("History"));
			crepository.save(new Category("Other"));
			
			repository.save(new Book(0, "Stephanie Meyer", "Twilight", "14565-47", 2014,(double) 25.90, crepository.findByName("Fantasy").get(0)));
			
		
			User user1 = new User("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "user@one.com", "USER");
			User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "admim@two.com", "ADMIN");
			userrepository.save(user1);
			userrepository.save(user2);
		};
	}
}

