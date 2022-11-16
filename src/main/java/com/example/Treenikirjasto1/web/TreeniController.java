package com.example.Treenikirjasto1.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Treenikirjasto1.domain.KategoriaRepository;
import com.example.Treenikirjasto1.domain.Treeni;
import com.example.Treenikirjasto1.domain.TreeniRepository;

@CrossOrigin
@Controller
public class TreeniController {
	
	@Autowired
	TreeniRepository trepository;
	
	@Autowired
	KategoriaRepository krepository;
	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping(value = "/treenilista", method = RequestMethod.GET)
	public String treenilista(Model model) {
		List<Treeni> treenit = (List<Treeni>) trepository.findAll();
		
		model.addAttribute("treenit", treenit);
		return "treenilista";
	}
	
	@RequestMapping(value = "/treenit", method = RequestMethod.GET)
	public @ResponseBody List<Treeni> treenilistaRest() {
		return (List<Treeni>) trepository.findAll();
	}
	
	@RequestMapping(value = "/treenit/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Treeni> findTreeniRest(@PathVariable("id") Long treeniId) {
		return trepository.findById(treeniId);
	}
	
	@RequestMapping(value = "/treenit", method = RequestMethod.POST)
	public @ResponseBody Treeni saveTreeniRest(@RequestBody Treeni treeni) {
		return trepository.save(treeni);
	}
	
	@RequestMapping(value = "/add")
	public String addTreenit(Model model) {
		model.addAttribute("treeni", new Treeni());
		model.addAttribute("kategoria", krepository.findAll());
		return "addtreeni";
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
		public String saveTreeni(Treeni treeni) {
			trepository.save(treeni);
			return "redirect:treenilista";
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasAuthority('ADMIN')")
	public String deleteTreeni(@PathVariable("id") Long treeniId, Model model) {
		trepository.deleteById(treeniId);
		return "redirect:../treenilista";
	}

}
