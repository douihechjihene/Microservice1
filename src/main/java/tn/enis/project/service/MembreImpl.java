package tn.enis.project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.enis.project.entities.EnseignantChercheur;
import tn.enis.project.entities.Etudiant;
import tn.enis.project.entities.Membre;
import tn.enis.project.repository.EnseignantChercheurRepository;
import tn.enis.project.repository.EtudiantRepository;
import tn.enis.project.repository.MembreRepository;

@Service
public class MembreImpl implements IMembreService {
	
	@Autowired
	MembreRepository membreRepository;
	@Autowired
	EtudiantRepository etudiantRepository;
	@Autowired
	EnseignantChercheurRepository enseignantChercheurRepository;

	@Override
	public Membre addMember(Membre m) {
		return membreRepository.save(m);
	}

	@Override
	public void deleteMember(Long id) {
		membreRepository.deleteById(id);

	}

	@Override
	public Membre updateMember(Membre p) {
		return membreRepository.saveAndFlush(p);
	}

	@Override
	public Membre findMember(Long id) {
		return membreRepository.findById(id).get();
	}

	@Override
	public List<Membre> findAll() {
		return membreRepository.findAll();
	}

	@Override
	public Membre findByCin(String cin) {
		return membreRepository.findByCin(cin);
	}

	@Override
	public Membre findByEmail(String email) {
		return membreRepository.findByEmail(email);
	}

	@Override
	public List<Membre> findByNom(String nom) {
		return membreRepository.findByNom(nom);
	}

	@Override
	public List<Etudiant> findByDiplome(String diplome) {
		return etudiantRepository.findByDiplome(diplome);
	}

	@Override
	public List<EnseignantChercheur> findByGrade(String grade) {
		return enseignantChercheurRepository.findByGrade(grade);
	}

	@Override
	public List<EnseignantChercheur> findByEtablissement(String etablissement) {
		return enseignantChercheurRepository.findByEtablissement(etablissement);
	}

	@Override
	public List<Etudiant> findByEncadrant(EnseignantChercheur encadrant) {
		return etudiantRepository.findByEncadrant(encadrant);
	}

	@Override
	public void affecterEtudiantToEns(Long id_ens, Long id_etd) {
		Etudiant etd=etudiantRepository.findById(id_etd).get();
		EnseignantChercheur ens =enseignantChercheurRepository.findById(id_ens).get();

		if (etd != null && ens != null) {
		    etd.setEncadrant(ens);
		    etudiantRepository.save(etd);       // Enregistrez les modifications dans la base de données
		    System.out.println("Étudiant affecté à l'enseignant avec succès.");
		} else {
		    System.out.println("Étudiant ou enseignant non trouvé.");
		}
	}
	
	

	
	



}
