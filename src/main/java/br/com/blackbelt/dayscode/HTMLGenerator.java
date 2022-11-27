package br.com.blackbelt.dayscode;

import br.com.blackbelt.dayscode.controller.MovieController;
import br.com.blackbelt.dayscode.dto.ListOfMovies;

import java.io.PrintWriter;

public class HTMLGenerator {

    private final PrintWriter printWriter;

    public HTMLGenerator(PrintWriter printWriter){
        this.printWriter = printWriter;
    }

    String head =
            """
            <head>
                <meta charset=\"utf-8\">
                <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">
                <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css\" 
                    + "integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">					
            </head>
            """;

    String divTemplate =
            """
            <div class=\"card text-white bg-dark mb-3\" style=\"max-width: 18rem;\">
                <h4 class=\"card-header\">%s</h4>
                <div class=\"card-body\">
                    <img class=\"card-img\" src=\"%s\" alt=\"%s\">
                    <p class=\"card-text mt-2\">Nota: %s - Ano: %s</p>
                </div>
            </div>
            """;

    public void generate(ListOfMovies movies) {

        printWriter.println(head);

        printWriter.println("<body>");

        movies.items().forEach(movie -> {
            //usando o template com os dados do filme
            printWriter.println(String.format(divTemplate, movie.title(), movie.image(), movie.title(), movie.imDbRating(), movie.year()));
        });

        printWriter.println(
                """
                    </body>
                </html>
                """);
    }

}
