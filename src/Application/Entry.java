package Application;

import java.time.LocalDate;

public class Entry {
	// Vars //
	private int id;
	private static int count = 0;
	private String titre;
	private String categorie;
	private String contenue;
	private LocalDate datePublication;
	
	// Constructeur par défaut //
	public Entry() {
		count++;
		id = count;
		titre = "";
		categorie = "";
		contenue = "";
		datePublication = LocalDate.now();
	}
	
	// Constructeur //
	public Entry(String titre, String categorie, String contenue) {
		count++;
		this.id = count;
		this.titre = titre;
		this.categorie = categorie;
		this.contenue = contenue;
		this.datePublication = LocalDate.now();
	}
	
	//-------------------//
	/* SETTERS & GETTERS */
	//-------------------//
	
	// ID //
	public void setID(int id) {
		this.id = id;
	}
	
	public int getID() {
		return this.id;
	}
	
	// Titre //
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	public String getTitre() {
		return this.titre;
	}
	
	// Categorie //
	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}
	
	public String getCategorie() {
		return this.categorie;
	}
	
	// Contenue //
	public void setContenue(String contenue) {
		this.contenue = contenue;
	}
	
	public String getContenue() {
		return this.contenue;
	}
	
	// Date publication //
	public void setDatePublication(LocalDate date) {
		this.datePublication = date;
	}
	
	public LocalDate getDatePublication() {
		return this.datePublication;
	}
	
	//-----------//
	/* FONCTIONS */
	//-----------//
	
	// toString //
	public String toString() {
		return "ID: " + id +
			   "\nTitre: " + titre +
			   "\nCategorie: " + categorie +
			   "\nContenue: " + contenue +
			   "Date de publication: " + datePublication;
	}
	
	// equals //
	public boolean equals(Entry myEntry) {
		return (id == myEntry.id) && (titre == myEntry.titre) && (categorie.equals(myEntry.categorie)) && (contenue.equals(myEntry.contenue)) && (datePublication == myEntry.datePublication);
	}
}
