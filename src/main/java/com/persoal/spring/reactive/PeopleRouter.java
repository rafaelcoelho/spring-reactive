package com.persoal.spring.reactive;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

@Configuration
public class PeopleRouter {

    @Bean
    public RouterFunction<ServerResponse> route(PeopleHandler handler) {
        return RouterFunctions.route(RequestPredicates.GET("/people")
                .and(RequestPredicates.accept(MediaType.APPLICATION_JSON)), handler::hello);
    }
}
