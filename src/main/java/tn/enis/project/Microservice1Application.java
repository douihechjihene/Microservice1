package tn.enis.project;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.AllArgsConstructor;
import tn.enis.project.entities.EnseignantChercheur;
import tn.enis.project.entities.Etudiant;
import tn.enis.project.entities.Membre;
import tn.enis.project.repository.EnseignantChercheurRepository;
import tn.enis.project.repository.EtudiantRepository;
import tn.enis.project.service.IMembreService;

@SpringBootApplication
@AllArgsConstructor
public class Microservice1Application  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(Microservice1Application.class, args);}
		
		//@Autowired
		EtudiantRepository etudiantRepository;
		//@Autowired
		EnseignantChercheurRepository enseignantChercheurRepository;
		//@Autowired
		IMembreService membreService;
		
		
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
					.nom("sabrine")
					.prenom("sabrine")
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
					.nom("jradi")
					.prenom("taktak")
					.sujet("blockhain")
					.build();
			
			Etudiant etd3=Etudiant.builder()
					.cin("10001")
					.dateInscription(new Date())
					.dateNaissance(new Date())
					.diplome("mastère")
					.email("etd3@gmail.com")
					.password("pass3")
					.encadrant(null)
					.cv("cv3")
					.nom("douihech")
					.prenom("jihene")
					.sujet("spring")
					.build();
			
			EnseignantChercheur ens1=EnseignantChercheur.builder()
					.cin("123123")
					.dateNaissance(new Date())
					.email("etd2@gmail.com")
					.password("pass2")
					.cv("cv2")
					.nom("abdou")
					.prenom("abdou")
					.grade("doctora")
					.etablissement("enis")
					.build();
			
			etudiantRepository.save(etd1);
			etudiantRepository.save(etd2);
			etudiantRepository.save(etd3);
			enseignantChercheurRepository.save(ens1);
			
			// Update a Member
			Membre m= membreService.findMember(1L);
			System.out.println(m);
			m.setCv("cv1.pdf");
			membreService.updateMember(m);
			System.out.println("member updated");
			System.out.println(m);
			
			List<EnseignantChercheur> mbr = membreService.findByGrade("doctora"); 
			System.out.println("L'ens est :"+mbr);
			
			// Delete a Member
			membreService.deleteMember(2L);
			System.out.println("member having id="+2+" deleted");
			
			//getAll member
			List<Membre> mbrs=membreService.findAll();
			System.out.println(mbrs);
			
			//Affecter un étudiant à un enseignant
			membreService.affecterEtudiantToEns(4L, 1L);
			
			//Pour un enseignant donné, afficher les étudiants qu’il encadre
			List<Etudiant> etudiantsEncadres =membreService.findByEncadrant(ens1);
			 if (!etudiantsEncadres.isEmpty()) {
			        System.out.println("Étudiants encadrés par " + ens1.getNom() + " " + ens1.getPrenom() + ":");
			        for (Etudiant etudiant : etudiantsEncadres) {
			            System.out.println("- " + etudiant.getNom() + " " + etudiant.getPrenom());
			        }
			    } else {
			        System.out.println(ens1.getNom() + " " + ens1.getPrenom() + " n'encadre actuellement aucun étudiant.");
			    }
	
			
		}
	
	}


