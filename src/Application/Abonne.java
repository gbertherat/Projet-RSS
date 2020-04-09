package Application;

import java.util.ArrayList;
import java.util.Iterator;

public class Abonne {
	// Vars //
	protected int id;
	protected static int count = 0;
	protected String nom;
	protected String prenom;
	protected String mail;
	protected String username;
	protected String password;
	protected ArrayList<Flux> listeFlux;
	protected ArrayList<String> listeContraintes;
	
	// Constructeur par défaut //
	public Abonne() {
		count++;
		id = count;
		nom = "";
		prenom = "";
		mail = "";
		username = "";
		password = "";
		listeFlux = new ArrayList<Flux>();
		listeContraintes = new ArrayList<String>();
	}
	
	// Constructeur //
	public Abonne(String nom, String prenom, String mail, String username, String password) {
		count++;
		this.id = count;
		this.nom = nom;
		this.prenom = prenom;
		this.mail = mail;
		this.username = username;
		this.password = password;
		this.listeFlux = new ArrayList<Flux>();
		this.listeContraintes = new ArrayList<String>();
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
	
	// Nom //
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	// Prenom //
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	public String getPrenom(String prenom) {
		return this.prenom;
	}
	
	// Mail //
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	public String getMail() {
		return this.mail;
	}
	
	// Username //
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getUsername(String username) {
		return this.username;
	}
	
	// Password //
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	// Liste flux //
	public void setListeFlux(ArrayList<Flux> list) {
		this.listeFlux = list;
	}
	
	public ArrayList<Flux> getListeFlux(){
		return this.listeFlux;
	}
	
	public void addFlux(Flux flux) {
		listeFlux.add(flux);
	}
	
	public void delFlux(Flux flux) {
		listeFlux.remove(flux);
	}
	
	// Liste contraintes //
	public void setListeContraintes(ArrayList<String> list) {
		this.listeContraintes = list;
	}
	
	public ArrayList<Flux> getListeContraintes(){
		return this.listeFlux;
	}
	
	public void addContraintes(String contrainte) {
		listeContraintes.add(contrainte);
	}
	
	public void delContraintes(String contrainte) {
		listeContraintes.remove(contrainte);
	}
	
	//-----------//
	/* FONCTIONS */
	//-----------//
	
	// toString //
	public String toString() {
		return "ID: " + id +
			   "\nNom: " + nom +
			   "\nPrenom: " + prenom +
			   "\nMail: " + mail;
	}
	
	
	// equals //
	public boolean equals(Abonne myAbonne) {
		return (id == myAbonne.id) && (nom.equals(myAbonne.nom)) && (prenom.equals(myAbonne.prenom)) && (mail.equals(myAbonne.mail));
	}
	
	/**
	 * La fonction subToFlux permet à un abonné de s'abonner à un flux grâce à l'ID du flux.
	 * @param idFlux L'ID du Flux
	 * @return true si l'abonnement s'est bien passé, false sinon.
	 */
	public boolean subToFlux(int idFlux) {
		Flux fluxSel;
		Iterator<Flux> iteFlux = listeFlux.iterator();
		while(iteFlux.hasNext()) {
			fluxSel = iteFlux.next();
			if(fluxSel.getRef() == idFlux) {
				addFlux(fluxSel);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * La fonction unsubToFlux permet à un abonné de se désabonner d'un flux grâce à l'ID du flux.
	 * @param idFlux L'ID du Flux
	 * @return true si le désabonnement s'est bien passé, false sinon.
	 */
	public boolean unsubToFlux(int idFlux) {
		Flux fluxSel;
		Iterator<Flux> iteFlux = listeFlux.iterator();
		while(iteFlux.hasNext()) {
			fluxSel = iteFlux.next();
			if(fluxSel.getRef() == idFlux) {
				delFlux(fluxSel);
				return true;
			}
		}
		return false;
	}
	
}
