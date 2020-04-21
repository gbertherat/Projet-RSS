package Application;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.sun.syndication.feed.synd.SyndCategoryImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

/**
 * La classe FluxFiltre permet la création de flux contenant des entrées filtrées
 * @author Guillaume
 * @see Flux
 */
public class FluxFiltre extends Flux{
	// VARS
	private LocalDate dateFin;
	private ArrayList<String> blacklist;
	private ArrayList<String> whitelist;

	/**
	 * Constructeur par défaut de la classe FluxFiltre
	 */
	public FluxFiltre() {
		super();
		dateFin = null;
		blacklist = new ArrayList<>();
		whitelist = new ArrayList<>();
	}
	
	/**
	 * Constructeur de la classe FluxFiltre
	 * @param nom - Le nom du flux
	 * @param url - L'url du flux
	 * @param langue - La langue du flux
	 * @param localisation - La localisation du flux
	 * @param dateFin - La date de fin du flux
	 */
	public FluxFiltre(String nom, String url, String langue, String localisation, LocalDate dateFin) {
		super(nom, url, langue, localisation);
		this.dateFin = dateFin;
		this.blacklist = new ArrayList<>();
		this.whitelist = new ArrayList<>();
	}
	
	//-------------------//
	/* SETTERS & GETTERS */
	//-------------------//
	
	/**
	 * Set la date de fin du flux
	 * @param date
	 */
	public void setDateFin(LocalDate date) {
		this.dateFin = date;
	}
	
	/**
	 * Get la date de fin du flux
	 * @return dateFin
	 */
	public LocalDate getDateFin() {
		return dateFin;
	}
	
	/**
	 * Set la blacklist d'un flux
	 * @param list
	 */
	public void setBlacklist(ArrayList<String> list) {
		this.blacklist = list;
	}
	
	/**
	 * Get la blacklist d'un flux
	 * @return blacklist
	 */
	public ArrayList<String> getBlacklist(){
		return blacklist;
	}
	
	/**
	 * Ajoute un mot à la blacklist d'un flux
	 * @param word
	 */
	public void addToBlacklist(String word) {
		blacklist.add(word.toLowerCase());
	}
	
	/**
	 * Supprime un mot de la blacklist d'un flux
	 * @param word
	 */
	public void delFromBlacklist(String word) {
		blacklist.remove(word.toLowerCase());
	}
	
	/**
	 * Set la whitelist d'un flux
	 * @param list
	 */
	public void setWhitelist(ArrayList<String> list) {
		this.whitelist = list;
	}
	
	/**
	 * Get la whitelist d'un flux
	 * @return whitelist
	 */
	public ArrayList<String> getWhitelist(){
		return whitelist;
	}
	
	/**
	 * Ajoute un mot à la whitelist d'un flux
	 * @param word
	 */
	public void addToWhitelist(String word) {
		whitelist.add(word.toLowerCase());
	}
	
	/**
	 * Supprime un mot de la whitelist d'un flux
	 * @param word
	 */
	public void delFromWhitelist(String word) {
		whitelist.remove(word.toLowerCase());
	}
	
	//-----------//
	/* FONCTIONS */
	//-----------//
	
	/**
	 * La fonction toString permet d'afficher les détails d'un flux filtré dans la console
	 */
	public String toString() {
		return super.toString() +
			   "\nDate de fin: " + dateFin;
	}
	
	/**
	 * La fonction equals permet de comparer les détails de deux flux filtrés
	 * @param flux - Le flux avec lequel comparer
	 * @return true si les deux flux sont identiques, false sinon
	 */
	public boolean equals(FluxFiltre flux) {
		return super.equals(flux) && (dateFin == flux.dateFin); 
	}
	
	public void copyFlux(Flux flux) {
		this.nom = flux.nom;
		this.url = flux.url;
		this.langue = flux.langue;
		this.localisation = flux.localisation;
	}
	
	/**
	 * La fonction retrieveFilteredEntries permet de récupérer les entrées d'un flux RSS en fonction de la blacklist et de la whitelist pour filtrer ces entrées.
	 * @throws Exception
	 */
	public void retrieveFilteredEntries() throws Exception {
		URL feedUrl = new URL(url);
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(feedUrl));
        for (SyndEntry entry : (List<SyndEntry>) feed.getEntries()){
        	for(String motAutorise : this.whitelist) {
        		if(entry.getTitle().toLowerCase().contains(motAutorise) || entry.getDescription().getValue().toLowerCase().contains((motAutorise))){
	        		Entry newEntry = new Entry(entry.getTitle(), entry.getDescription().getValue(), entry.getPublishedDate());
	        		for (SyndCategoryImpl category : (List<SyndCategoryImpl>) entry.getCategories()) {
	        			newEntry.addCategorie(category.getName());
	        		}
	        		listeEntrees.add(newEntry);
        		}
        	}
        	
        	for(String motBanni : this.blacklist) {
        		if(!entry.getTitle().toLowerCase().contains(motBanni) && !entry.getDescription().getValue().toLowerCase().contains((motBanni))){
	        		Entry newEntry = new Entry(entry.getTitle(), entry.getDescription().getValue(), entry.getPublishedDate());
	        		for (SyndCategoryImpl category : (List<SyndCategoryImpl>) entry.getCategories()) {
	        			newEntry.addCategorie(category.getName());
	        		}
	        		listeEntrees.add(newEntry);
        		}
        	}
        }
	}
}
