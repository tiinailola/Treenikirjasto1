package com.example.Treenikirjasto1.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Kategoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long kategoriaid;
	private String nimi;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "kategoria")
	@JsonIgnoreProperties("kategoria")
	private List<Treeni> treenit;
	
	public Kategoria() {
		
	}
	
	public Kategoria(String nimi) {
		super();
		this.nimi = nimi;
	}
	
	public Long getKategoriaid() {
		return kategoriaid;
	}
	
	public void setKategoriaid(Long kategoriaid) {
		this.kategoriaid = kategoriaid;
	}
	
	public String getNimi() {
		return nimi;
	}
	
	public void setNimi(String nimi) {
		this.nimi = nimi;
	}
	
	public List<Treeni> getTreenit() {
		return treenit;
	}
	
	public void setTreenit(List<Treeni> treenit) {
		this.treenit = treenit;
	}

	@Override
	public String toString() {
		return "Kategoria [kategoriaid=" + kategoriaid + ", nimi=" + nimi + ", treenit=" + treenit + "]";
	}

}
