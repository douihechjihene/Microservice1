package tn.enis.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.enis.project.entities.EnseignantChercheur;
import tn.enis.project.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
	
	List<Etudiant> findByDiplome(String diplome);
	List<Etudiant> findByEncadrant(EnseignantChercheur encadrant);
	//List<Etudiant> findByDiplomeOrderByDateInscriptionDesc(String diplome);
}
