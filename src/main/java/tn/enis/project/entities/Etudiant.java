package tn.enis.project.entities;

import java.util.Date;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Entity
@DiscriminatorValue("etd") 
@Getter @Setter
public class Etudiant extends Membre{
	
	private static final long serialVersionUID = 1L;
	
	@NonNull @Temporal(TemporalType.DATE)
	private Date dateInscription;
	@NonNull
	private String sujet;
	@NonNull
	private String diplome;
	
	@ManyToOne
	private EnseignantChercheur encadrant;

	@Builder
	public Etudiant( String cin, String nom, String prenom, Date dateNaissance, String cv,
			String email, String password, Date dateInscription, String sujet, String diplome,
			EnseignantChercheur encadrant) 
	{
			super(cin, nom, prenom, dateNaissance, cv, email, password);
			this.dateInscription = dateInscription;
			this.sujet = sujet;
			this.diplome = diplome;
			this.encadrant = encadrant;
	}

	
	//Pour les tests
	public Etudiant() {
		super();
	}



	
	

}
