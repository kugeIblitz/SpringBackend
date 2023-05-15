package com.rayen.films;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.rayen.films.entities.Categorie;
import com.rayen.films.entities.Film;

@SpringBootApplication
public class FilmsApplication implements CommandLineRunner  {

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(FilmsApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Film.class,Categorie.class);
		
	}
	
	@Bean
	public ModelMapper modelMapper()
	{
		return new ModelMapper();
	}



}
