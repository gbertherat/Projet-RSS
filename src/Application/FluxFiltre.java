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

public class FluxFiltre extends Flux{
	// VARS
	private LocalDate dateFin;
	private ArrayList<String> blacklist;
	private ArrayList<String> whitelist;

	public FluxFiltre() {
		super();
		dateFin = null;
		blacklist = new ArrayList<String>();
		whitelist = new ArrayList<String>();
	}
	
	public FluxFiltre(String nom, String url, String langue, String localisation, LocalDate dateFin) {
		super(nom, url, langue, localisation);
		this.dateFin = dateFin;
		this.blacklist = new ArrayList<String>();
		this.whitelist = new ArrayList<String>();
	}
	
	//-------------------//
	/* SETTERS & GETTERS */
	//-------------------//
	
	// Date fin //
	public void setDateFin(LocalDate date) {
		this.dateFin = date;
	}
	
	public LocalDate getDateFin() {
		return dateFin;
	}
	
	// Blacklist //
	public void setBlacklist(ArrayList<String> list) {
		this.blacklist = list;
	}
	
	public ArrayList<String> getBlacklist(){
		return blacklist;
	}
	
	public void addToBlacklist(String word) {
		blacklist.add(word.toLowerCase());
	}
	
	public void delFromBlacklist(String word) {
		blacklist.remove(word.toLowerCase());
	}
	
	// Whitelist //
	public void setWhitelist(ArrayList<String> list) {
		this.whitelist = list;
	}
	
	public ArrayList<String> getWhitelist(){
		return whitelist;
	}
	
	public void addToWhitelist(String word) {
		whitelist.add(word.toLowerCase());
	}
	
	public void delFromWhitelist(String word) {
		whitelist.remove(word.toLowerCase());
	}
	
	//-----------//
	/* FONCTIONS */
	//-----------//
	
	// toString
	public String toString() {
		return super.toString() +
			   "\nDate de fin: " + dateFin;
	}
	
	// equals
	public boolean equals(FluxFiltre flux) {
		return super.equals(flux) && (dateFin == flux.dateFin); 
	}
	
	public void retrieveFilteredEntries() throws Exception {
		URL feedUrl = new URL(url);
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(feedUrl));
        for (SyndEntry entry : (List<SyndEntry>) feed.getEntries()){
        	for(String motAutorise : this.whitelist) {
        		if(entry.getTitle().toLowerCase().contains(motAutorise) && entry.getDescription().getValue().toLowerCase().contains((motAutorise))){
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
