package br.com.blackbelt.dayscode.controller;

import br.com.blackbelt.dayscode.HTMLGenerator;
import br.com.blackbelt.dayscode.dto.DadosCadastroMovie;
import br.com.blackbelt.dayscode.dto.ListOfMovies;
import br.com.blackbelt.dayscode.model.Movie;
import br.com.blackbelt.dayscode.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

@RestController
@RequestMapping("api/movies")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("top250")
    public ListOfMovies getTop250Movies() throws FileNotFoundException {
        ResponseEntity<ListOfMovies> response =
                this.restTemplate.getForEntity("https://imdb-api.com/en/API/Top250Movies/k_zu8058un", ListOfMovies.class);

        PrintWriter writer = new PrintWriter("src/main/resources/content2.html");
        new HTMLGenerator(writer).generate(response.getBody());
        writer.close();
        return response.getBody();
    }

    @PostMapping("cadastrar")
    @Transactional
    @CacheEvict(value = "listaDeMovies", allEntries = true)
    public void cadastrar(@RequestBody @Valid DadosCadastroMovie dados){
        movieRepository.save(new Movie(dados));
    }



}
