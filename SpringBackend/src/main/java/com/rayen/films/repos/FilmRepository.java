package com.rayen.films.repos;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.rayen.films.entities.Categorie;
import com.rayen.films.entities.Film;

@RepositoryRestResource(path = "rest")
public interface FilmRepository extends JpaRepository<Film, Long> {
	List<Film> findByNomFilm(String nom);
	List<Film> findByNomFilmContains(String nom);   
	

    
	@Query("select p from Film p where p.categorie = ?1")
	List<Film> findByCategorie (Categorie categorie);
	
	List<Film> findByCategorieIdCat(Long id);
	
	List<Film> findByOrderByNomFilmAsc();
	

	              




}
