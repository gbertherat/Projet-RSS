package Application;

import java.util.ArrayList;
import java.util.Date;

/**
 * La classe Entry permet de créer des entrées pour un flux.
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
	 * Constructeur par défaut de la classe Entry
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
	 * @param titre - Le titre de l'entrée
	 * @param description - La description de l'entrée
	 * @param date - La date de publication de l'entrée
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
	 * Set l'ID d'une entrée
	 * @param id
	 */
	public void setID(int id) {
		this.id = id;
	}
	
	/**
	 * Get l'ID d'une entrée
	 * @return id
	 */
	public int getID() {
		return this.id;
	}
	
	/**
	 * Set le titre d'une entrée
	 * @param titre
	 */
	public void setTitre(String titre) {
		this.titre = titre;
	}
	
	/**
	 * Get le titre d'une entrée
	 * @return titre
	 */
	public String getTitre() {
		return this.titre;
	}
	
	/**
	 * Set la liste de catégories d'une entrée
	 * @param list
	 */
	public void setListeCategories(ArrayList<String> list) {
		this.listeCategories = list;
	}
	
	/**
	 * Get la liste de catégories d'une entrée
	 * @return listeCategories
	 */
	public ArrayList<String> getCategorie() {
		return this.listeCategories;
	}
	
	/**
	 * Ajoute une catégorie à la liste de catégories d'une entrée
	 * @param categorie
	 */
	public void addCategorie(String categorie) {
		listeCategories.add(categorie);
	}
	
	/**
	 * Supprime une catégorie de la liste de catégories d'une entrée
	 * @param categorie
	 */
	public void delCategorie(String categorie) {
		listeCategories.remove(categorie);
	}
	
	/**
	 * Set la description d'une entrée
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * Get la description d'une entrée
	 * @return description
	 */
	public String getDescription() {
		return this.description;
	}
	
	/** 
	 * Set la liste de contenus d'une entrée
	 * @param contenue
	 */
	public void setListeContenu(ArrayList<String> contenu) {
		this.listeContenus = contenu;
	}
	
	/**
	 * Get la liste de contenus d'une entrée
	 * @return listeContenus
	 */
	public ArrayList<String> getListeContenu() {
		return this.listeContenus;
	}
	
	/**
	 * Ajoute un contenu à la liste de contenu d'une entrée
	 * @param contenue
	 */
	public void addContenu(String contenu) {
		listeContenus.add(contenu);
	}
	
	/**
	 * Supprime un contenu de la liste de contenu d'une entrée
	 * @param contenu
	 */
	public void delContenu(String contenu) {
		listeContenus.remove(contenu);
	}
	
	/**
	 * Set la date de publication d'une entreée
	 * @param date
	 */
	public void setDatePublication(Date date) {
		this.datePublication = date;
	}
	
	/**
	 * Get la date de publication d'une entrée
	 * @return datePublication
	 */
	public Date getDatePublication() {
		return this.datePublication;
	}
	
	//-----------//
	/* FONCTIONS */
	//-----------//
	
	/**
	 * La fonction toString permet d'afficher les détails d'une entrée dans la console
	 */
	public String toString() {
		return "ID: " + id +
			   "\nTitre: " + titre +
			   "\nDate de publication: " + datePublication;
	}
	
	/**
	 * La fonction equals permet de comparer les détails de deux entrées
	 * @param myEntry - Une entrée avec laquelle comparer
	 * @return true si les deux entrées sont identiques, false sinon.
	 */
	public boolean equals(Entry myEntry) {
		return (id == myEntry.id) && (titre == myEntry.titre) && (datePublication == myEntry.datePublication);
	}
}
