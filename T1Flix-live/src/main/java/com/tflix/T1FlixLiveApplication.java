package com.tflix;

import java.util.stream.Stream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class T1FlixLiveApplication {
	
	@Bean
	CommandLineRunner initialMovies(MovieRepository movieRepository) {
		return args -> {
			movieRepository.deleteAll()
			.subscribe(null, null, () -> {
				Stream.of(new Movie("1", "300"), 
						new Movie("2", "Back to the future"),
						new Movie("3", "Orugas Team (la venganza)"),
						new Movie("4", "Matrix"))
				.forEach(movie ->
						movieRepository.save(movie)
						.map(m2 -> m2.getTitle())
						.subscribe(System.out::println)
						);
			});
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(T1FlixLiveApplication.class, args);
	}
}
