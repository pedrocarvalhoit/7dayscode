package br.com.blackbelt.dayscode;

import br.com.blackbelt.dayscode.vo.Movie;
import br.com.blackbelt.dayscode.vo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@SpringBootTest
class ApplicationTest {

    @Test
    public void consumerApi(){
        //    https://imdb-api.com/en/API/Top250Movies/k_zu8058un

        RestTemplate restTemplate = new RestTemplate();
        User user = new User();
        user.setApiKey("k_zu8058un");


        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("imdb-api.com")
                .path("en/API/Top250Movies/" + user.getApiKey())
                .build();

        ResponseEntity<Movie> entity = restTemplate.getForEntity(uri.toUriString(), Movie.class);

        System.out.println(entity.getBody().getFullTitle());
    }

}