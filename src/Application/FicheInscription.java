package Application;

import java.time.LocalDate;

public class FicheInscription {
	// Vars
	private int ref;
	private static int count = 0;
	private Abonne myAbonne;
	private LocalDate dateInscription;
	private LocalDate dateFinInscription;
	private Flux myFlux;
	
	// Constructeur par défaut //
	public FicheInscription() {
		count++;
		ref = count;
		myAbonne = null;
		dateInscription = LocalDate.now();
		dateFinInscription = null;
		myFlux = null;
	}
	
	// Constructeur //
	public FicheInscription(Abonne myAbonne, Flux myFlux) {
		count++;
		this.ref = count;
		this.myAbonne = myAbonne;
		this.dateInscription = LocalDate.now();
		this.dateFinInscription = null;
		this.myFlux = myFlux;
	}
	
	//-------------------//
	/* SETTERS & GETTERS */
	//-------------------//
	
	// Référence //
	public void setRef(int ref) {
		this.ref = ref;
	}

	public int getRef() {
		return this.ref;
	}
	
	// Abonné //
	public void setAbonne(Abonne myAbonne) {
		this.myAbonne = myAbonne;
	}
	
	public Abonne getAbonne() {
		return this.myAbonne;
	}
	
	// Date d'inscription //
	public void setDateInscription(LocalDate date) {
		this.dateInscription = date;
	}
	
	public LocalDate getDateInscription() {
		return this.dateInscription;
	}
	
	// Date fin d'inscription
	public void setDateFinInscription(LocalDate date) {
		this.dateInscription = date;
	}
	
	public LocalDate getDateFinInscription() {
		return this.dateFinInscription;
	}
	
	// Flux
	public void setFlux(Flux myFlux) {
		this.myFlux = myFlux;
	}
	
	public Flux getFlux() {
		return this.myFlux;
	}
	
	//-----------//
	/* FONCTIONS */
	//-----------//
	
	// toString
	public String toString() {
		return "Référence: " + ref +
			   "\nAbonné: " + myAbonne.nom + " " + myAbonne.prenom +
			   "\nDate d'inscription: " + dateInscription +
			   "\nDate fin d'inscription: " + dateFinInscription;
	}
	
	// equals
	public boolean equals(FicheInscription myInsc) {
		return (ref == myInsc.ref) && (myAbonne == myInsc.myAbonne) && (dateInscription == myInsc.dateInscription) && (dateFinInscription == myInsc.dateFinInscription);
	}
}
