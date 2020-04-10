package Application;

import java.time.LocalDate;
import java.util.ArrayList;

public class Filtre {
	// VARS
	private int id;
	private static int count = 0;
	private LocalDate dateExpiration;
	private ArrayList<String> whitelist;
	private ArrayList<String> blacklist;
	private ArrayList<Flux> listeFlux;
	
	// Constructeur par défaut //
	public Filtre() {
		count++;
		id= count;
		dateExpiration = null;
		whitelist = new ArrayList<String>();
		blacklist = new ArrayList<String>();
		listeFlux = new ArrayList<Flux>();
	}
	
	// Constructeur //
	public Filtre(LocalDate dateExpiration) {
		count++;
		this.id = count;
		this.dateExpiration = dateExpiration;
		this.whitelist = new ArrayList<String>();
		this.blacklist = new ArrayList<String>();
		this.listeFlux = new ArrayList<Flux>();
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
	
	// Date d'expiration //
	public void setDateExpiration(LocalDate date) {
		this.dateExpiration = date;
	}
	
	public LocalDate getDateExpiration() {
		return this.dateExpiration;
	}
	
	// Whitelist //
	public void setWhitelist(ArrayList<String> whitelist) {
		this.whitelist = whitelist;
	}
	
	public ArrayList<String> getWhitelist(){
		return this.whitelist;
	}
	
	public void addToWhitelist(String word) {
		whitelist.add(word);
	}
	
	public void removeFromWhitelist(String word) {
		whitelist.remove(word);
	}
	
	// Blacklist //
	public void setBlacklist(ArrayList<String> blacklist) {
		this.blacklist = blacklist;
	}
	
	public ArrayList<String> getBlacklist(){
		return this.blacklist;
	}
	
	public void addToBlacklist(String word) {
		blacklist.add(word);
	}
	
	public void removeFromBlacklist(String word) {
		blacklist.remove(word);
	}
	
	// Liste flux //
	public void setListeFlux(ArrayList<Flux> listeFlux) {
		this.listeFlux = listeFlux;
	}
	
	public ArrayList<Flux> getListeFlux(){
		return this.listeFlux;
	}
	
	public void addToListeFlux(Flux myFlux) {
		listeFlux.add(myFlux);
	}
	
	public void removeFromListeFlux(Flux myFlux) {
		listeFlux.remove(myFlux);
	}
	
	//-----------//
	/* FONCTIONS */
	//-----------//
	
	// toString
	public String toString() {
		return "ID: " + id +
			   "\nDate d'expiration: " + dateExpiration;
	}
	
	
	// equals
	public boolean equals(Filtre myFiltre) {
		return (id == myFiltre.id) && (dateExpiration == myFiltre.dateExpiration);
	}
}
