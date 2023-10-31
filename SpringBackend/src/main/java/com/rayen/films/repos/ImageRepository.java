package com.rayen.films.repos;


import org.springframework.data.jpa.repository.JpaRepository;

import com.rayen.films.entities.Image;

public interface ImageRepository extends JpaRepository<Image , Long> {
}