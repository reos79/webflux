package com.tflix;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;

@Configuration
public class ReactiveConfig {

	@Bean
	RouterFunction<?> routerFunctions(RouteHandlers routeHandlers){
		return RouterFunctions.route(RequestPredicates.GET("/f-movies"), routeHandlers::all)
				.andRoute(RequestPredicates.GET("/f-movies/{id}"), routeHandlers::byId)
				.andRoute(RequestPredicates.GET("/f-movies/{id}/events"), routeHandlers::events);
	}
}
