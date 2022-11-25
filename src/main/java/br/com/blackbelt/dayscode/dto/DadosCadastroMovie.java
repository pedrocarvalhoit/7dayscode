package br.com.blackbelt.dayscode.dto;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public record DadosCadastroMovie(
        @NotBlank
        String id,
        @NotBlank
        String image,
        @NotBlank
        String title,
        @NotBlank
        String year,
        @NotBlank
        String imDbRating
) {
}
