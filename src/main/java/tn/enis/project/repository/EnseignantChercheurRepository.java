package tn.enis.project.repository;

import java.util.List;

import tn.enis.project.entities.EnseignantChercheur;

public interface EnseignantChercheurRepository {
	
	List<EnseignantChercheur>findByGrade(String grade);
	List<EnseignantChercheur>findByEtablissement(String etablissement);

}
