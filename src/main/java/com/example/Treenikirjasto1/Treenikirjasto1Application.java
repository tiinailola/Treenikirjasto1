package com.example.Treenikirjasto1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Treenikirjasto1.domain.Kategoria;
import com.example.Treenikirjasto1.domain.KategoriaRepository;
import com.example.Treenikirjasto1.domain.Treeni;
import com.example.Treenikirjasto1.domain.TreeniRepository;
import com.example.Treenikirjasto1.domain.User;
import com.example.Treenikirjasto1.domain.UserRepository;

@SpringBootApplication
public class Treenikirjasto1Application {
	
	private static final Logger log = LoggerFactory.getLogger(Treenikirjasto1Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Treenikirjasto1Application.class, args);
	}
	
	@Bean
	public CommandLineRunner comm(TreeniRepository trepository, KategoriaRepository krepository, UserRepository urepository) {
		return (args) -> {
			log.info("Tallenna treenejä");
			krepository.save(new Kategoria("Lihaskunto"));
			krepository.save(new Kategoria("Kestävyys"));
			krepository.save(new Kategoria("Aerobinen"));
			krepository.save(new Kategoria("Kehonhuolto"));
			krepository.save(new Kategoria("Liikkuvuus"));
			krepository.save(new Kategoria("Voima"));
			
			trepository.save(new Treeni("Kuntosalitreeni", "25.6.2021", "Vantaa", "55 minuuttia", "Reipas ja tehokas koko kropan treeni", krepository.findByNimi("Lihaskunto").get(0)));
			trepository.save(new Treeni("Juoksulenkki", "12.9.2021", "Hakkila", "30 minuuttia", "Rento iltalenkki juosten", krepository.findByNimi("Kestävyys").get(0)));
			trepository.save(new Treeni("Venyttely", "11.10.2021", "Espoo", "40 minuuttia", "Kehonhuoltoa lepopäivänä", krepository.findByNimi("Kehonhuolto").get(0)));
			trepository.save(new Treeni("Kuntosalitreeni", "15.11.2022", "Vantaa", "1 tunti", "Rinta-, olkapäätreeni. Vinopenkkiä käsipainoilla, rintalihaslaite, peckdeck, pystypunnerrus, vipunostot, facepull.", krepository.findByNimi("Lihaskunto").get(0)));
			trepository.save(new Treeni("Koiralenkki", "16.11.2022", "Vantaa", "Puoli tuntia", "Mukava koiralenkki kirpeässä syyssäässä", krepository.findByNimi("Aerobinen").get(0)));
			
			User user1 = new User("user", "$2a$10$H/c0AZT.VelOgv6DNa0YPOkh5wEJiYlmHR5zcDzH6sOpc5CrYpTcO", "USER", "user.user@email.com");
			User user2 = new User("admin", "$2a$10$a3NRbNdvIhlBhkvQz86/9euktvB7MA1cq5dccO.WqrSEJEMUCYh1.", "ADMIN", "admin.admin@admin.com");
			urepository.save(user1);
			urepository.save(user2);
			
			log.info("Haetaan treenejä");
			for (Treeni treeni : trepository.findAll()) {
				log.info(treeni.toString());
			}
		};
	}

}
