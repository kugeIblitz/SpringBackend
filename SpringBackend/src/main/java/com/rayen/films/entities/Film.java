package com.rayen.films.entities;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Film {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFilm;
	private String nomFilm;
	private String descFilm;
	private Date dateCreation;
	
	@ManyToOne
	private Categorie categorie;
	
	/*
	 * @ManyToOne private Image image;
	 */


	 @OneToMany (mappedBy = "film")
	 private List<Image> images;
	 
	 private String imagePath;


	public Film() {
		super();
	}

	public Film(String nomFilm, String descFilm, Date dateCreation) {
		super();
		this.nomFilm = nomFilm;
		this.descFilm = descFilm;
		this.dateCreation = dateCreation;
	}



	public Long getIdFilm() {
		return idFilm;
	}

	public void setIdFilm(Long idFilm) {
		this.idFilm = idFilm;
	}

	public String getNomFilm() {
		return nomFilm;
	}

	public void setNomFilm(String nomFilm) {
		this.nomFilm = nomFilm;
	}

	public String getdescFilm() {
		return descFilm;
	}

	public void setdescFilm(String descFilm) {
		this.descFilm = descFilm;
	}

	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}
	
	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public List<Image> getImages() {
		return images;
	}

	public void setImages(List<Image> images) {
		this.images = images;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	@Override
	public String toString() {
		return "Film [idFilm=" + idFilm + ", nomFilm=" + nomFilm + ", descFilm=" + descFilm
				+ ", dateCreation=" + dateCreation + "categorie=" + categorie  + "]";
	}
}
