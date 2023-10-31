package com.rayen.films.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rayen.films.dto.FilmsDTO;
import com.rayen.films.entities.Film;
import com.rayen.films.service.FilmService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins ="*")
public class FilmRESTController {
	@Autowired
	FilmService filmService;
	
	@RequestMapping(path="all",method = RequestMethod.GET)
	public List<FilmsDTO> getAllFilms() {
		return filmService.getAllFilms();
	 } 		
	
	@RequestMapping(path="/getbyid/{id}",method = RequestMethod.GET)
	public FilmsDTO getFilmById(@PathVariable("id") Long id) {	
		return filmService.getFilm(id);
    }
	
	@RequestMapping(value="/addFilm",method = RequestMethod.POST)
	public FilmsDTO createFilm(@RequestBody FilmsDTO filmsDTO) {
		return filmService.saveFilm(filmsDTO);
	}

	@RequestMapping(value="/updateFilm",method = RequestMethod.PUT)
	public FilmsDTO updateFilm(@RequestBody FilmsDTO filmsDTO) {
		return filmService.updateFilm(filmsDTO);
	}

	@RequestMapping(value="/delFilm/{id}",method = RequestMethod.DELETE)
	public void deleteFilm(@PathVariable("id") Long id)
	{
		filmService.deleteFilmById(id);
	}
	
	@RequestMapping(value="/filmscat/{idCat}",method = RequestMethod.GET)
	public List<Film> getFilmsByCatId(@PathVariable("idCat") Long idCat) {
		return filmService.findByCategorieIdCat(idCat);
	 }
	
	@RequestMapping(value="/filmsByName/{nom}",method = RequestMethod.GET)
	public List<Film> findByNomFilmContains(@PathVariable("nom") String nom) {
		return filmService.findByNomFilmContains(nom);
	 }

	
	

}
