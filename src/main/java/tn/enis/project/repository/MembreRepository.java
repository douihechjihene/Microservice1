package tn.enis.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.enis.project.entities.Membre;

public interface MembreRepository extends JpaRepository<Membre, Long>{
   
	Membre findByCin(String cin);
	List<Membre> findByNom(String nom);
	//List<Membre> findByNomStartingWith(String caractere);
	Membre findByEmail(String email);
	
}
