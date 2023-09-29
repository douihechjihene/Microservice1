package tn.enis.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import tn.enis.project.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
	
	List<Etudiant>findByDiplome(String diplome);
	List<Etudiant>findByDiplomeOrderByDateInscriptionDesc(String diplome);
}
