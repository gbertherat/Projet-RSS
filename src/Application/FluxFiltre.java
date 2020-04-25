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
 * La classe FluxFiltre permet la creation de flux contenant des entrees filtrees
 * @author Guillaume
 * @see Flux
 */
public class FluxFiltre extends Flux{
	// VARS
	private LocalDate dateFin;
	private ArrayList<String> blacklist;
	private ArrayList<String> whitelist;

	/**
	 * Constructeur par defaut de la classe FluxFiltre
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
	 * Ajoute un mot a la blacklist d'un flux
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
	 * Ajoute un mot a la whitelist d'un flux
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
	 * La fonction toString permet d'afficher les details d'un flux filtre dans la console
	 */
	public String toString() {
		StringBuffer toReturn = new StringBuffer(super.toString() +
			   "\nDate de fin: " + dateFin);
		
		toReturn.append("\nBlacklist:");
		for(String word: blacklist) {
			toReturn.append("\n" + word);
		}
		
		toReturn.append("\nWhitelist:");
		for(String word: whitelist) {
			toReturn.append("\n" + word);
		}
		
		return toReturn.toString();
	}
	
	/**
	 * La fonction equals permet de comparer les details de deux flux filtres
	 * @param flux - Le flux avec lequel comparer
	 * @return true si les deux flux sont identiques, false sinon
	 */
	public boolean equals(FluxFiltre flux) {
		return super.equals(flux) && (dateFin == flux.dateFin); 
	}
	
	/**
	 * La fonction copyFlux permet de copier les attributs d'un autre flux
	 * @param flux - Flux a copier
	 */
	public void copyFlux(Flux flux) {
		this.ref = flux.ref;
		this.nom = flux.nom;
		this.url = flux.url;
		this.langue = flux.langue;
		this.localisation = flux.localisation;
	}
	
	/**
	 * La fonction retrieveFilteredEntries permet de recuperer les entrees d'un flux RSS en fonction de la blacklist et de la whitelist pour filtrer ces entrees.
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
