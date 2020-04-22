package Application;

import java.time.LocalDate;

/**
 * La classe FicheInscription permet de creer une fiche inscription lie a l'inscription d'un abonne a un flux.
 * @author Guillaume
 *
 */
public class FicheInscription {
	// Vars
	private int ref;
	private static int count = 0;
	private Abonne myAbonne;
	private LocalDate dateInscription;
	private LocalDate dateResiliation;
	private Flux myFlux;
	
	/**
	 * Constructeur par defaut de la classe FicheInscription
	 */
	public FicheInscription() {
		count++;
		ref = count;
		myAbonne = null;
		dateInscription = LocalDate.now();
		dateResiliation = null;
		myFlux = null;
	}
	
	/**
	 * Constructeur de la classe FicheInscription
	 * @param myAbonne - L'abonne qui s'est inscrit
	 * @param myFlux - Le flux auquel il s'est inscrit
	 */
	public FicheInscription(Abonne myAbonne, Flux myFlux) {
		count++;
		this.ref = count;
		this.myAbonne = myAbonne;
		this.dateInscription = LocalDate.now();
		this.dateResiliation = null;
		this.myFlux = myFlux;
	}
	
	//-------------------//
	/* SETTERS & GETTERS */
	//-------------------//
	
	/**
	 * Set la reference d'une fiche
	 * @param ref
	 */
	public void setRef(int ref) {
		this.ref = ref;
	}

	/**
	 * Get la reference d'une fiche
	 * @return ref
	 */
	public int getRef() {
		return this.ref;
	}
	
	/**
	 * Set l'abonne d'une fiche
	 * @param myAbonne
	 */
	public void setAbonne(Abonne myAbonne) {
		this.myAbonne = myAbonne;
	}
	
	/**
	 * Get l'abonne d'une fiche
	 * @return myAbonne
	 */
	public Abonne getAbonne() {
		return this.myAbonne;
	}
	
	/**
	 * Set la date d'inscription de l'abonne
	 * @param date
	 */
	public void setDateInscription(LocalDate date) {
		this.dateInscription = date;
	}
	
	/**
	 * Get la date d'inscription de l'abonne
	 * @return dateInscription
	 */
	public LocalDate getDateInscription() {
		return this.dateInscription;
	}
	
	/**
	 * Set la date de resiliation d'un abonne
	 * @param date
	 */
	public void setDateResiliation(LocalDate date) {
		this.dateResiliation = date;
	}
	
	/**
	 * Get la date de resiliation d'un abonne
	 * @return
	 */
	public LocalDate getDateResiliation() {
		return this.dateResiliation;
	}
	
	/**
	 * Set le flux de l'inscription d'un abonne
	 * @param myFlux
	 */
	public void setFlux(Flux myFlux) {
		this.myFlux = myFlux;
	}
	
	/**
	 * Get le flux de l'inscription d'un abonne
	 * @return myFlux
	 */
	public Flux getFlux() {
		return this.myFlux;
	}
	
	//-----------//
	/* FONCTIONS */
	//-----------//
	
	/**
	 * La fonction toString permet d'afficher les details d'une fiche dans la console
	 */
	public String toString() {
		return "Reference: " + ref +
			   "\nAbonne: " + myAbonne.nom + " " + myAbonne.prenom +
			   "\nDate d'inscription: " + dateInscription +
			   "\nDate fin d'inscription: " + dateResiliation +
			   "\nFlux inscrit: " + myFlux.getNom();
	}
	
	/**
	 * La fonction equals permet de comparer les details de deux fiches.
	 * @param myInsc - La fiche avec laquelle comparer
	 * @return true si les deux fiches sont identiques, false sinon.
	 */
	public boolean equals(FicheInscription myInsc) {
		return (ref == myInsc.ref) && (myAbonne == myInsc.myAbonne) && (dateInscription == myInsc.dateInscription) && (dateResiliation == myInsc.dateResiliation);
	}
}
