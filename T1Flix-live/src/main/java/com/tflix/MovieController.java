package com.tflix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@GetMapping("/movies/{id}")
	public Mono<Movie> byId(@PathVariable String id){
		return movieService.byId(id);
	}
	
	@GetMapping("/movies")
	public Flux<Movie> all(){
		return movieService.all();
	}
	
	@GetMapping(value="/movies/{id}/events",produces=MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<MovieEvent> events(@PathVariable String id){
		return movieService.events(id);
	}
}
