package com.example.Treenikirjasto1.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Treeni {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String otsikko;
	private String pvm;
	private String sijainti;
	private String kesto;
	private String kuvaus;
	
	@ManyToOne
	@JsonIgnoreProperties ("treenit")
	@JoinColumn(name = "kategoriaid")
	private Kategoria kategoria;
	
	public Treeni() {
		super();
		this.id = null;
		this.otsikko = null;
		this.pvm = null;
		this.sijainti = null;
		this.kesto = null;
		this.kuvaus = null;
		this.kategoria = null;
	}
	
	public Treeni(String otsikko, String pvm, String sijainti, String kesto, String kuvaus, Kategoria kategoria) {
		super();
		this.otsikko = otsikko;
		this.pvm = pvm;
		this.sijainti = sijainti;
		this.kesto = kesto;
		this.kuvaus = kuvaus;
		this.kategoria = kategoria;
	}
	
	public Treeni(Long id, String otsikko, String pvm, String sijainti, String kesto, String kuvaus, Kategoria kategoria) {
		super();
		this.id = id;
		this.otsikko = otsikko;
		this.pvm = pvm;
		this.sijainti = sijainti;
		this.kesto = kesto;
		this.kuvaus = kuvaus;
		this.kategoria = kategoria;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOtsikko() {
		return otsikko;
	}

	public void setOtsikko(String otsikko) {
		this.otsikko = otsikko;
	}

	public String getPvm() {
		return pvm;
	}

	public void setPvm(String pvm) {
		this.pvm = pvm;
	}

	public String getSijainti() {
		return sijainti;
	}

	public void setSijainti(String sijainti) {
		this.sijainti = sijainti;
	}

	public String getKesto() {
		return kesto;
	}

	public void setKesto(String kesto) {
		this.kesto = kesto;
	}

	public String getKuvaus() {
		return kuvaus;
	}

	public void setKuvaus(String kuvaus) {
		this.kuvaus = kuvaus;
	}

	public Kategoria getKategoria() {
		return kategoria;
	}

	public void setKategoria(Kategoria kategoria) {
		this.kategoria = kategoria;
	}

	/*@Override
	public String toString() {
		if (this.kategoria != null)
			return "Treeni [id=" + id + ", otsikko=" + otsikko + ", pvm=" + pvm + ", sijainti=" + sijainti + ", kesto="
				+ kesto + ", kuvaus=" + kuvaus + ", kategoria=" + this.getKategoria() + "]";
		else
			return "Treeni [id=" + id + ", otsikko=" + otsikko + ", pvm=" + pvm + ", sijainti=" + sijainti + ", kesto="
			+ kesto + ", kuvaus=" + kuvaus + "]";
	}
	*/
	
}
