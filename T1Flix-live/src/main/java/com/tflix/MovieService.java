package com.tflix;

import java.time.Duration;
import java.util.Date;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;
	
	public Flux<MovieEvent> events(String movieId){
		return movieRepository.findById(movieId)
				.flatMapMany(
						movie -> {
							
							Flux<Long> interval = Flux.interval(Duration.ofSeconds(2));
							
							Flux<MovieEvent> events = Flux.fromStream(
									Stream.generate(() -> new MovieEvent(movie.getTitle(), new Date())));
							
							return Flux.zip(interval, events).map(Tuple2::getT2);
						}
						);
	}
	
	public Mono<Movie> byId(String id){
		return movieRepository.findById(id);
	}
	
	public Flux<Movie> all(){
		return movieRepository.findAll();
	}
}
