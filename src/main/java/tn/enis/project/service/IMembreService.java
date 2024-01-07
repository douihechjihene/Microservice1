package tn.enis.project.service;

import java.util.List;

import tn.enis.project.entities.EnseignantChercheur;
import tn.enis.project.entities.Etudiant;
import tn.enis.project.entities.Membre;

public interface IMembreService {
	
	//Crud sur les membres
	public Membre addMember(Membre m);
	public void deleteMember(Long id) ;
	public Membre updateMember(Membre p) ;
	public Membre findMember(Long id) ;
	public List<Membre> findAll();
	
	//Filtrage par propriété
	public Membre findByCin(String cin);
	public Membre findByEmail(String email);
	public List<Membre> findByNom(String nom);
	//public List<Membre> findByNomStartingWith(String caractere);
	
	//recherche spécifique des étudiants
	public List<Etudiant> findByDiplome(String diplome);
	public List<Etudiant> findByEncadrant(EnseignantChercheur encadrant);
	
	//recherche spécifique des enseignants
	public List<EnseignantChercheur> findByGrade(String grade);
	public List<EnseignantChercheur> findByEtablissement(String etablissement);
	
	public void affecterEtudiantToEns(Long id_ens,Long id_etd);

}
