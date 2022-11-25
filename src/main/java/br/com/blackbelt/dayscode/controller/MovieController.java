package br.com.blackbelt.dayscode.controller;

import br.com.blackbelt.dayscode.controller.model.Movie;
import br.com.blackbelt.dayscode.dto.DadosCadastroMovie;
import br.com.blackbelt.dayscode.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@RestController
@RequestMapping("api/movies")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("top250")
    public String getTop250Movies(){
        ResponseEntity<String> response =
                this.restTemplate.getForEntity("https://imdb-api.com/en/API/Top250Movies/k_zu8058un", String.class);
        System.out.println("teste");
        return response.getBody();

    }

    @PostMapping("cadastrar")
    @Transactional
    @CacheEvict(value = "listaDeMovies", allEntries = true)
    public void cadastrar(@RequestBody @Valid DadosCadastroMovie dados){
        movieRepository.save(new Movie(dados));
    }

}
