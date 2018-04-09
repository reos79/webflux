package com.tflix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import reactor.core.publisher.Mono;

@Component
public class RouteHandlers {
	
	@Autowired
	private MovieService movieService;

	public Mono<ServerResponse> byId(ServerRequest request) {
		String id = request.pathVariable("id");
		return ServerResponse.ok().body(movieService.byId(id), Movie.class);
	}
	
	public Mono<ServerResponse> all(ServerRequest request) {
		return ServerResponse.ok().body(movieService.all(), Movie.class);
	}
	
	public Mono<ServerResponse> events(ServerRequest request) {
		String id = request.pathVariable("id");
		return ServerResponse.ok().contentType(MediaType.TEXT_EVENT_STREAM).body(movieService.events(id), MovieEvent.class);
	}
}
