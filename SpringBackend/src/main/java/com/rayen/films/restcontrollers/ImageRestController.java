package com.rayen.films.restcontrollers;


import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.rayen.films.entities.Image;
import com.rayen.films.dto.FilmsDTO;
import com.rayen.films.entities.Film;
import com.rayen.films.service.ImageService;
import com.rayen.films.service.FilmService;

@RestController
@RequestMapping("/api/image")
@CrossOrigin(origins = "*")
public class ImageRestController {

	@Autowired
	ImageService imageService;
	
	 @Autowired
	 FilmService filmService;
	

		
		  @RequestMapping(value = "/upload", method = RequestMethod.POST) public Image
		  uploadImage(@RequestParam("image") MultipartFile file) throws IOException {
		  return imageService.uplaodImage(file); }
		 
	
	
//	 @RequestMapping(value = "/upload/{id}" , method = RequestMethod.POST)
//	 public void uploadImage(@RequestParam("image") MultipartFile 
//			 file,@PathVariable("id") Long id) throws IOException {
//		 FilmsDTO f = filmService.getFilm(id);
//		 f.setImagePath(id+".jpg");
//
//		 Files.write(Paths.get(System.getProperty("user.home")+"/images/"+f.getImagePath())
//				 , file.getBytes());
//		 filmService.saveFilm(f);
//
//	 }

	@RequestMapping(value = "/get/info/{id}", method = RequestMethod.GET)
	public Image getImageDetails(@PathVariable("id") Long id) throws IOException {
		return imageService.getImageDetails(id);
	}

	@RequestMapping(value = "/load/{id}", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImage(@PathVariable("id") Long id) throws IOException {
		return imageService.getImage(id);
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public void deleteImage(@PathVariable("id") Long id) {
		imageService.deleteImage(id);
	}

	@RequestMapping(value = "/update", method = RequestMethod.PUT)
	public Image UpdateImage(@RequestParam("image") MultipartFile file) throws IOException {
		return imageService.uplaodImage(file);
	}
	
	
	@PostMapping(value = "/uplaodImageFilm/{idFilm}" )
	public Image uploadMultiImages(@RequestParam("image")MultipartFile file,
			@PathVariable("idFilm") Long idFilm)
					throws IOException {
		return imageService.uplaodImageFilm(file,idFilm);
	}
	@RequestMapping(value = "/getImagesFilm/{idFilm}",method = RequestMethod.GET)
	public List<Image> getImagesFilm(@PathVariable("idFilm") Long idFilm)
			throws IOException {
		return imageService.getImagesParFilm(idFilm);
	}
}