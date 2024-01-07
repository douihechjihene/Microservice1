package tn.enis.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.enis.project.entities.EnseignantChercheur;

public interface EnseignantChercheurRepository extends JpaRepository<EnseignantChercheur, Long>{
	
	List<EnseignantChercheur>findByGrade(String grade);
	List<EnseignantChercheur>findByEtablissement(String etablissement);

}
