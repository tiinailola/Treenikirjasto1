package com.example.Treenikirjasto1.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Treenikirjasto1.domain.Kategoria;
import com.example.Treenikirjasto1.domain.KategoriaRepository;

public class KategoriaController {
	
	@Autowired
	KategoriaRepository krepository;
	
	@RequestMapping(value = "/kateorialista", method = RequestMethod.GET)
	public String kategoriaLista(Model model) {
		List<Kategoria> kategoriat = (List<Kategoria>) krepository.findAll();
		
		model.addAttribute("kategoriat", kategoriat);
		return "kategorialista";
	}

}
