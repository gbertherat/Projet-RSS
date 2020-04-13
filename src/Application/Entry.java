package Application;

import java.util.ArrayList;
import java.util.Date;

public class Entry {
	// Vars //
	private int id;
	private static int count = 0;
	private String titre;
	private ArrayList<String> listeCategories;
	private String description;
	private ArrayList<String> listeContenues;
	private Date datePublication;
	
	// Constructeur par défaut //
	public Entry() {
		count++;
		id = count;
		titre = "";
		listeCategories = new ArrayList<String>();
		description = "";
		listeContenues = new ArrayList<String>();
		datePublication = null;
	}
	
	// Constructeur //
	public Entry(String titre, String description, Date date) {
		count++;
		this.id = count;
		this.titre = titre;
		this.listeCategories = new ArrayList<String>();
		this.description = description;
		this.listeContenues = new ArrayList<String>();
		this.datePublication = date;
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
	public void setListeCategories(ArrayList<String> list) {
		this.listeCategories = list;
	}
	
	public ArrayList<String> getCategorie() {
		return this.listeCategories;
	}
	
	public void addCategorie(String categorie) {
		listeCategories.add(categorie);
	}
	
	public void delCategorie(String categorie) {
		listeCategories.remove(categorie);
	}
	
	// Description //
	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	// Contenue //
	public void setListeContenue(ArrayList<String> contenue) {
		this.listeContenues = contenue;
	}
	
	public ArrayList<String> getListeContenue() {
		return this.listeContenues;
	}
	
	public void addContenue(String contenue) {
		listeContenues.add(contenue);
	}
	
	public void delContenue(String contenue) {
		listeContenues.remove(contenue);
	}
	
	// Date publication //
	public void setDatePublication(Date date) {
		this.datePublication = date;
	}
	
	public Date getDatePublication() {
		return this.datePublication;
	}
	
	//-----------//
	/* FONCTIONS */
	//-----------//
	
	// toString //
	public String toString() {
		return "ID: " + id +
			   "\nTitre: " + titre +
			   "\nDate de publication: " + datePublication;
	}
	
	// equals //
	public boolean equals(Entry myEntry) {
		return (id == myEntry.id) && (titre == myEntry.titre) && (datePublication == myEntry.datePublication);
	}
}
