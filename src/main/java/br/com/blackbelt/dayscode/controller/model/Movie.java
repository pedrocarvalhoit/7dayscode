package br.com.blackbelt.dayscode.controller.model;

import br.com.blackbelt.dayscode.dto.DadosCadastroMovie;

import javax.persistence.*;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    private String id;
    private String image;
    private String title;
    private String year;
    private String imDbRating;

    public Movie() {
    }

    public Movie(DadosCadastroMovie dados){
        this.id = dados.id();
        this.image = dados.image();
        this.title = dados.title();
        this.year = dados.year();
        this.imDbRating = dados.imDbRating();
    }

}
