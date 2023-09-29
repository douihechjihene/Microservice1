package tn.enis.project;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tn.enis.project.entities.EnseignantChercheur;
import tn.enis.project.entities.Etudiant;
import tn.enis.project.repository.EnseignantChercheurRepository;
import tn.enis.project.repository.EtudiantRepository;

@SpringBootApplication
public class Microservice1Application {

	public static void main(String[] args) {
		SpringApplication.run(Microservice1Application.class, args);}
		
		EtudiantRepository etudiantRepository;
	
		EnseignantChercheurRepository enseignantChercheurRepository;
		
		public void run(String... args) throws Exception {
			Etudiant etd1=Etudiant.builder()
					.cin("123456")
					.dateInscription(new Date())
					.dateNaissance(new Date())
					.diplome("mastère")
					.email("etd1@gmail.com")
					.password("pass1")
					.encadrant(null)
					.cv("cv1")
					.nom("abid")
					.prenom("youssef)")
					.sujet("blockhain")
					.build();
			Etudiant etd2=Etudiant.builder()
					.cin("123123")
					.dateInscription(new Date())
					.dateNaissance(new Date())
					.diplome("mastère")
					.email("etd2@gmail.com")
					.password("pass2")
					.encadrant(null)
					.cv("cv2")
					.nom("dammak")
					.prenom("ines")
					.sujet("blockhain")
					.build();
			
			EnseignantChercheur ens1=EnseignantChercheur.builder()
					.cin("123123")
					.dateNaissance(new Date())
					.email("etd2@gmail.com")
					.password("pass2")
					.cv("cv2")
					.nom("dammak")
					.prenom("ines")
					.Grade(null)
					.Etablissement("enis")
					.build();
			
			etudiantRepository.save(etd1);
	        etudiantRepository.save(etd2);
	        enseignantChercheurRepository.save(ens1);
	        enseignantChercheurRepository.save(ens2);
			
		}
	
	}


