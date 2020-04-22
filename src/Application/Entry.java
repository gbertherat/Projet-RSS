package Application;

import java.util.ArrayList;
import java.util.Date;

/**
 * La classe Entry permet de creer des entrees pour un flux.
 * @author Guillaume
 */
public class Entry {
	// Vars //
	private int id;
	private static int count = 0;
	private String titre;
	private ArrayList<String> listeCategories;
	private String description;
	private ArrayList<String> listeContenus;
	private Date datePublication;
	
	/**
	 * Constructeur par defaut de la classe Entry
	 */
	public Entry() {
		count++;
		id = count;
		titre = "";
		listeCategories = new ArrayList<String>();
		description = "";
		listeContenus = new ArrayList<String>();
		datePublication = null;
	}
	
	/**
	 * Constructeur de la classe Entry
	 * @param titre - Le titre de l'entree
	 * @param description - La description de l'entree
	 * @param date - La date de publication de l'entree
	 */
	public Entry(String titre, String description, Date date) {
		count++;
		this.id = count;
		this.titre = titre;
		this.listeCategories = new ArrayList<String>();
		this.description = description;
		this.listeContenus = new ArrayList<String>();
		this.datePublication = date;
	}
	
	//-------------------//
	/* SETTERS & GETTERS */
	//-------------------//
	
	/**
	 * Set l'ID d'une entree
	 * @param id
	 */
	public void setID(int id) {
		this.id = id;
	}
	
	/**
	 * Get l'ID d'une entree
	 * @return id
	 */
	public int getID() {
		return this.id;
	}
	
	/**
	 * Set le titre d'une entree
	 * @param titre
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	/**
	 * Get le titre d'une entree
	 * @return titre
	 */
	public String getTitre() {
		return this.titre;
	}
	
	/**
	 * Set la liste de categories d'une entree
	 * @param list
	 */
	public void setListeCategories(ArrayList<String> list) {
		this.listeCategories = list;
	}
	
	/**
	 * Get la liste de categories d'une entree
	 * @return listeCategories
	 */
	public ArrayList<String> getCategorie() {
		return this.listeCategories;
	}
	
	/**
	 * Ajoute une categorie a la liste de categories d'une entree
	 * @param categorie
	 */
	public void addCategorie(String categorie) {
		listeCategories.add(categorie);
	}
	
	/**
	 * Supprime une categorie de la liste de categories d'une entree
	 * @param categorie
	 */
	public void delCategorie(String categorie) {
		listeCategories.remove(categorie);
	}
	
	/**
	 * Set la description d'une entree
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Get la description d'une entree
	 * @return description
	 */
	public String getDescription() {
		return this.description;
	}
	
	/** 
	 * Set la liste de contenus d'une entree
	 * @param contenu
	 */
	public void setListeContenu(ArrayList<String> contenu) {
		this.listeContenus = contenu;
	}
	
	/**
	 * Get la liste de contenus d'une entree
	 * @return listeContenus
	 */
	public ArrayList<String> getListeContenu() {
		return this.listeContenus;
	}
	
	/**
	 * Ajoute un contenu a la liste de contenu d'une entree
	 * @param contenu
	 */
	public void addContenu(String contenu) {
		listeContenus.add(contenu);
	}
	
	/**
	 * Supprime un contenu de la liste de contenu d'une entree
	 * @param contenu
	 */
	public void delContenu(String contenu) {
		listeContenus.remove(contenu);
	}
	
	/**
	 * Set la date de publication d'une entreee
	 * @param date
	 */
	public void setDatePublication(Date date) {
		this.datePublication = date;
	}
	
	/**
	 * Get la date de publication d'une entree
	 * @return datePublication
	 */
	public Date getDatePublication() {
		return this.datePublication;
	}
	
	//-----------//
	/* FONCTIONS */
	//-----------//
	
	/**
	 * La fonction toString permet d'afficher les details d'une entree dans la console
	 */
	public String toString() {
		return "ID: " + id +
			   "\nTitre: " + titre +
			   "\nDate de publication: " + datePublication;
	}
	
	/**
	 * La fonction equals permet de comparer les details de deux entrees
	 * @param myEntry - Une entree avec laquelle comparer
	 * @return true si les deux entrees sont identiques, false sinon.
	 */
	public boolean equals(Entry myEntry) {
		return (id == myEntry.id) && (titre == myEntry.titre) && (datePublication == myEntry.datePublication);
	}
}
