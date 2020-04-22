package Application;

import com.sun.syndication.feed.synd.SyndCategoryImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * La classe Flux permet la creation de flux
 * @author Guillaume
 */
public class Flux {
	// Vars //
	protected int ref;
	protected static int count = -1;
	protected String nom;
	protected String url;
	protected String langue;
	protected LocalDate dateAjout;
	protected String localisation;
	protected ArrayList<Entry> listeEntrees;
	protected ArrayList<String> listeCategories;
	protected ArrayList<Abonne> listeAbonnes;
	
	/**
	 * Constructeur par defaut de la classe Flux
	 */
	public Flux() {
		count++;
		ref = count;
		nom = "";
		url = "";
		langue = "";
		dateAjout = LocalDate.now();
		localisation = "";
		listeEntrees = new ArrayList<Entry>();
		listeAbonnes = new ArrayList<Abonne>();
	}
	
	/**
	 * Constructeur de la classe Flux
	 * @param nom - Le nom du flux
	 * @param url - L'Url du flux
	 * @param langue - La langue du flux
	 * @param localisation - La localisation du flux
	 */
	public Flux(String nom, String url, String langue, String localisation) {
		count++;
		this.ref = count;
		this.nom = nom;
		this.url = url;
		this.langue = langue;
		this.dateAjout = LocalDate.now();
		this.localisation = localisation;
		this.listeEntrees = new ArrayList<Entry>();
		this.listeAbonnes = new ArrayList<Abonne>();
	}
	
	//-------------------//
	/* SETTERS & GETTERS */
	//-------------------//
	
	/**
	 * Set la reference d'un flux
	 * @param ref
	 */
	public void setRef(int ref) {
		this.ref = ref;
	}
	
	/**
	 * Get la reference d'un flux
	 * @return ref
	 */
	public int getRef() {
		return this.ref;
	}
	
	/**
	 * Set le nom d'un flux
	 * @param nom
	 */
	// Nom //
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Get le nom d'un flux
	 * @return nom
	 */
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * Set l'url d'un flux
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * Get l'url d'un flux
	 * @return url
	 */
	public String getUrl() {
		return this.url;
	}
	
	/**
	 * Set la langue d'un flux
	 * @param langue
	 */
	public void setLangue(String langue) {
		this.langue = langue;
	}
	
	/**
	 * Get la langue d'un flux
	 * @return langue
	 */
	public String getLangue() {
		return this.langue;
	}
	
	/**
	 * Set la date d'ajout d'un flux
	 * @param date
	 */
	public void setDateAjout(LocalDate date) {
		this.dateAjout = date;
	}
	
	/**
	 * Get la date d'ajout d'un flux
	 * @return dateAjout
	 */
	public LocalDate getDateAjout() {
		return this.dateAjout;
	}
	
	/**
	 * Set la localisation d'un flux
	 * @param localisation
	 */
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	
	/**
	 * Get la localisation d'un flux
	 * @return localisation
	 */
	public String getLocalisation() {
		return this.localisation;
	}
	
	/**
	 * Get la liste d'entrees d'un flux
	 * @param list
	 */
	public void setListeEntrees(ArrayList<Entry> list) {
		this.listeEntrees = list;
	}
	
	/**
	 * Set la liste d'entrees d'un flux
	 * @return listeEntrees
	 */
	public ArrayList<Entry> getListeEntrees(){
		return this.listeEntrees;
	}
	
	/**
	 * Ajoute une entree a un flux
	 * @param myEntry
	 */
	public void addEntree(Entry myEntry) {
		listeEntrees.add(myEntry);
	}
	
	/**
	 * Supprime une entree d'un flux
	 * @param myEntry
	 */
	public void delEntree(Entry myEntry) {
		listeEntrees.remove(myEntry);
	}
	
	/**
	 * Set la liste de categories d'un flux
	 * @param list
	 */
	public void setListeCategories(ArrayList<String> list) {
		this.listeCategories = list;
	}
	
	/**
	 * Get la liste de categories d'un flux
	 * @return listeCategories
	 */
	public ArrayList<String> getCategorie() {
		return this.listeCategories;
	}
	
	/**
	 * Ajoute une categorie a un flux 
	 * @param categorie
	 */
	public void addCategorie(String categorie) {
		listeCategories.add(categorie);
	}
	
	/**
	 * Supprime une categorie d'un flux
	 * @param categorie
	 */
	public void delCategorie(String categorie) {
		listeCategories.remove(categorie);
	}
	
	/**
	 * Set la liste d'abonnes d'un flux
	 * @param list
	 */
	public void setListeAbonnes(ArrayList<Abonne> list) {
		this.listeAbonnes = list;
	}
	
	/**
	 * Get la liste d'abonnes d'un flux
	 * @return listeAbonnes
	 */
	public ArrayList<Abonne> getListeAbonnes(){
		return this.listeAbonnes;
	}
	
	/**
	 * Ajoute un abonne a un flux
	 * @param myAbonne
	 */
	public void addAbonne(Abonne myAbonne) {
		listeAbonnes.add(myAbonne);
	}
	
	/**
	 * Supprime un abonne d'un flux
	 * @param myAbonne
	 */
	public void delAbonne(Abonne myAbonne) {
		listeAbonnes.remove(myAbonne);
	}
	
	//-----------//
	/* FONCTIONS */
	//-----------//
	
	/**
	 * La fonction toString permet d'afficher les details d'un flux dans la console
	 */
	public String toString() {
		return "Reference: " + ref +
				"\nNom: " + nom +
				"\nUrl: " + url +
				"\nLangue: " + langue +
				"\nDate d'ajout: " + dateAjout +
				"\nLocalisation: " + localisation;
	}
	
	/**
	 * La fonction equals permet de comparer les details de deux flux
	 * @param myFlux - Le flux avec lequel comparer
 	 * @return true si les flux sont identiques, false sinon.
	 */
	public boolean equals(Flux myFlux) {
		return (ref == myFlux.ref) && (nom.equals(myFlux.nom)) && (url.equals(myFlux.url)) && (langue.equals(myFlux.langue)) && (dateAjout == myFlux.dateAjout) && (localisation.equals(myFlux.localisation));
	}
	
	/**
	 * La fonction retrieveEntries permet de recuperer toutes les entrees d'un flux RSS selon l'url du flux.
	 * @throws Exception
	 */
	public void retrieveEntries() throws Exception {
		URL feedUrl = new URL(url);
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(feedUrl));
        for (SyndEntry entry : (List<SyndEntry>) feed.getEntries()){
        	 Entry newEntry = new Entry(entry.getTitle(), entry.getDescription().getValue(), entry.getPublishedDate());

             for (SyndCategoryImpl category : (List<SyndCategoryImpl>) entry.getCategories()) {
            	 newEntry.addCategorie(category.getName());
             }
             listeEntrees.add(newEntry);
        }
	}
}
