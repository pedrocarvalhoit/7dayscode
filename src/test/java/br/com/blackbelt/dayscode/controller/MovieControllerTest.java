package br.com.blackbelt.dayscode.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MovieControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    void shoulResturnTop250Films(){
        ResponseEntity<Map> response =
                this.restTemplate.getForEntity("https://imdb-api.com/en/API/Top250Movies/k_zu8058un", Map.class);
        assertEquals(HttpStatus.OK,response.getStatusCode());
        assertNotNull(response.getBody());
    }

}