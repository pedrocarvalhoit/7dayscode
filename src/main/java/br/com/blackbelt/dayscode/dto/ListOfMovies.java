package br.com.blackbelt.dayscode.dto;

import br.com.blackbelt.dayscode.model.Movie;

import java.util.List;

public record ListOfMovies(
        List<Movie> items
) {
}
