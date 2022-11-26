package br.com.blackbelt.dayscode.repository;

import br.com.blackbelt.dayscode.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, String > {
}
