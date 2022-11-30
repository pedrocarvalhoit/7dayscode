package br.com.blackbelt.dayscode.controller;

import br.com.blackbelt.dayscode.FilmeController;
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

    @Test
    void shouldInsertToFavoritos() {

        String filmeId = "tt0068646";

        ResponseEntity<String> response =
                this.restTemplate.postForEntity("http://localhost:" + port + "/favorito/" + filmeId, null, String.class);

        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertEquals(FilmeController.POST_SUCCESS, response.getBody());

    }

    @Test
    void shouldReturnFavoritos() {

        ResponseEntity<FilmeController.ListOfMovies> response =
                this.restTemplate.getForEntity("http://localhost:" + port + "/favoritos", FilmeController.ListOfMovies.class);

        assertEquals(HttpStatus.OK, response.getStatusCode());
    }


}