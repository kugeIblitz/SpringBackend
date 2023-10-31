package com.rayen.films.service;


import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.rayen.films.entities.Film;
import com.rayen.films.entities.Image;
import com.rayen.films.repos.FilmRepository;
import com.rayen.films.repos.ImageRepository;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired
	ImageRepository imageRepository;
	
	@Autowired
	FilmRepository filmRepository;

	@Autowired
	FilmService filmService;

	@Override
	public Image uplaodImage(MultipartFile file) throws IOException {
		
		return imageRepository.save(Image.builder().name(file.getOriginalFilename()).type(file.getContentType())
				.image(file.getBytes()).build());
	}

	@Override
	public Image getImageDetails(Long id) throws IOException {
		final Optional<Image> dbImage = imageRepository.findById(id);
		return Image.builder().idImage(dbImage.get().getIdImage()).name(dbImage.get().getName())
				.type(dbImage.get().getType()).image(dbImage.get().getImage()).build();
	}

	@Override
	public ResponseEntity<byte[]> getImage(Long id) throws IOException {
		final Optional<Image> dbImage = imageRepository.findById(id);
		return ResponseEntity.ok().contentType(MediaType.valueOf(dbImage.get().getType()))
				.body(dbImage.get().getImage());
	}

	@Override
	public void deleteImage(Long id) {
		imageRepository.deleteById(id);
	}
	
	@Override
	public Image uplaodImageFilm(MultipartFile file, Long idFilm) throws IOException {
		Film film = new Film();
		film.setIdFilm(idFilm);
		return imageRepository.save(Image.builder().name(file.getOriginalFilename()).type(file.getContentType())
				.image(file.getBytes()).film(film).build());
	}

	@Override
	public List<Image> getImagesParFilm(Long idFilm) {
		Film film = filmRepository.findById(idFilm).get();
		return film.getImages();
	}
}