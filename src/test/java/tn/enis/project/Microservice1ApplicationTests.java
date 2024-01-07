package tn.enis.project;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.enis.project.entities.Etudiant;
import tn.enis.project.repository.EtudiantRepository;

@SpringBootTest
class Microservice1ApplicationTests {

	@Autowired        // Mecanisme d'injection de dependance
	private EtudiantRepository etudiantRepository ; 
	
	@Test
	public void testCreateEtud() {
		Etudiant etd = new Etudiant("1001", "jihene","douihech", new Date(), "cv", "jiji@gmail.com", "123", null, null, null, null) ;
		etudiantRepository.save(etd);
	}
	
	@Test
	public void testFindEtd() {
		Etudiant e = etudiantRepository.findById(1L).get();
		System.out.println(e);	
	}
	
	@Test
	public void testUpdateEtd() {
		Etudiant e = etudiantRepository.findById(1L).get();
		e.setCin("0249588");
		etudiantRepository.save(e);
		System.out.println(e);
	}

	@Test
	public void testDeletEtd() {
		etudiantRepository.deleteById(1L);
	}
	
	@Test
	public void testFindAllEtd() {
		List<Etudiant> etds = etudiantRepository.findAll();
		for (Etudiant e:etds)
			System.out.println(e);
	}
	
	 @Test
	    public void testEtudiantBuilder() {
		 
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
			System.out.println("le build est reusie");
			etudiantRepository.save(etd1);
			System.out.println("le build est enrg");
			
	    }
}
