package com.persoal.spring.reactive;

import com.persoal.spring.reactive.PeopleHandler.People;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
class ReactiveApplicationTests {

    @Autowired
    private WebTestClient webClient;

    @Test
    public void dummy() {
        webClient
                .get()
                .uri("/people")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus().isOk()
                .expectBody(People.class)
                .isEqualTo(new People("John", "Biden", "St. Five PO Box 102"));
    }
}
