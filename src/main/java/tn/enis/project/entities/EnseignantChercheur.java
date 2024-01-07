package tn.enis.project.entities;


import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter @Setter
@NoArgsConstructor
@DiscriminatorValue("ens")
public class EnseignantChercheur extends Membre {
	
	private static final long serialVersionUID = 1L;
	
	//nrml n7touha ken fl etudiant
	@OneToMany (mappedBy="encadrant")
	@JsonIgnore
	Collection<Etudiant> listEtudiants ;
	@NonNull
	private String grade  ;
	@NonNull
	private String etablissement  ;
	
	@Builder
	public EnseignantChercheur( String cin, String nom, String prenom, Date dateNaissance,
	String cv,String email, String password, String grade,  String etablissement) 
	{
		super( cin, nom, prenom, dateNaissance, cv, email, password);
		this.grade = grade;
		this.etablissement = etablissement;
	}

}

