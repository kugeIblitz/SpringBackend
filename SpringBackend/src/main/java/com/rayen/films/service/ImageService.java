package com.rayen.films.service;


import java.io.IOException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.rayen.films.entities.Image;

public interface ImageService {
	 Image uplaodImage(MultipartFile file) throws IOException;
	 Image getImageDetails(Long id) throws IOException;
	 ResponseEntity<byte[]> getImage(Long id) throws IOException;
	 void deleteImage(Long id) ;
	 
	 
		Image uplaodImageFilm(MultipartFile file,Long idFilm) throws IOException;
		List<Image> getImagesParFilm(Long idFilm);
	}