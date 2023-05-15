package com.rayen.films.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MatchingStrategy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rayen.films.dto.FilmsDTO;
import com.rayen.films.entities.Categorie;
import com.rayen.films.entities.Film;
import com.rayen.films.repos.FilmRepository;

@Service
public class FilmServiceImpl implements FilmService {

	@Autowired
	FilmRepository filmRepository;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public FilmsDTO saveFilm(FilmsDTO p) {
		return convertEntityToDto( filmRepository.save(convertDtoToEntity(p)));
		
	}

	@Override
	public FilmsDTO updateFilm(FilmsDTO p) {
		return convertEntityToDto( filmRepository.save(convertDtoToEntity(p)) );
		
	}

	@Override
	public void deleteFilm(Film p) {
		filmRepository.delete(p);

	}

   @Override
	public void deleteFilmById(Long id) {
		filmRepository.deleteById(id);
		
	}

	@Override
	public FilmsDTO getFilm(Long id) {
		return   convertEntityToDto( filmRepository.findById(id).get() );
	
	}

	@Override
	public List<FilmsDTO> getAllFilms() {
		return filmRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
		
	
				
	}
	
    @Override
	public List<Film> findByNomFilm(String nom) {
		return filmRepository.findByNomFilm(nom);
	}

	@Override
	public List<Film> findByNomFilmContains(String nom) {
		return filmRepository.findByNomFilmContains(nom);
	}


	
	@Override
	public List<Film> findByCategorie(Categorie categorie) {
		return filmRepository.findByCategorie(categorie);
	}

	@Override
	public List<Film> findByCategorieIdCat(Long id) {
		return filmRepository.findByCategorieIdCat(id);
	}

	@Override
	public List<Film> findByOrderByNomFilmAsc() {
		return filmRepository.findByOrderByNomFilmAsc();
	}



	@Override
	public FilmsDTO convertEntityToDto(Film film) {
		
		
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		FilmsDTO filmsDTO=  modelMapper.map(film, FilmsDTO.class);
		
		return filmsDTO;
		
	
		
		
		
	}

	@Override
	public Film convertDtoToEntity(FilmsDTO filmDto) {
		
		Film film = new Film();
		film = modelMapper.map(filmDto, Film.class);
		   return film;
		
		
		

	}


}
