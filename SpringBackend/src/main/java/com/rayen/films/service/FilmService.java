package com.rayen.films.service;

import java.util.List;

import com.rayen.films.dto.FilmsDTO;
import com.rayen.films.entities.Categorie;
import com.rayen.films.entities.Film;

public interface FilmService {
	
	 FilmsDTO saveFilm(FilmsDTO p);
	 FilmsDTO updateFilm(FilmsDTO p);
	 
	 FilmsDTO getFilm(Long id);
	 List<FilmsDTO> getAllFilms();
	 
	 

	 void deleteFilm(Film p);
     void deleteFilmById(Long id);
	
    
	 
	 List<Film> findByNomFilm(String nom);
	 List<Film> findByNomFilmContains(String nom);

	 List<Film> findByCategorie (Categorie categorie);
	 List<Film> findByCategorieIdCat(Long id);
	 List<Film> findByOrderByNomFilmAsc();
	

	 FilmsDTO convertEntityToDto(Film p);
	 Film convertDtoToEntity(FilmsDTO filmDto);
}
