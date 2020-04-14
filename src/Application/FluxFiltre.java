package Application;

import java.time.LocalDate;
import java.util.ArrayList;

public class FluxFiltre {
	// VARS
	private int id;
	private static int count = 0;
	private LocalDate dateExpiration;
	private ArrayList<String> whitelist;
	private ArrayList<String> blacklist;
	
	// Constructeur par défaut //
	public FluxFiltre() {
		count++;
		id= count;
		dateExpiration = null;
		whitelist = new ArrayList<String>();
		blacklist = new ArrayList<String>();
	}
	
	// Constructeur //
	public FluxFiltre(LocalDate dateExpiration) {
		count++;
		this.id = count;
		this.dateExpiration = dateExpiration;
		this.whitelist = new ArrayList<String>();
		this.blacklist = new ArrayList<String>();
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
	
	
	//-----------//
	/* FONCTIONS */
	//-----------//
	
	// toString
	public String toString() {
		return "ID: " + id +
			   "\nDate d'expiration: " + dateExpiration;
	}
	
	// equals
	public boolean equals(FluxFiltre myFluxFiltre) {
		return (id == myFluxFiltre.id) && (dateExpiration == myFluxFiltre.dateExpiration);
	}
	
}
