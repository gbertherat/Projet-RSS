package Application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * La classe Abonne permet la création d'Abonne de flux.
 * @author Guillaume
 */
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
	
	/**
	 * Le constructeur par défaut de la classe Abonne
	 */
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
	
	/**
	 * Le constructeur de la classe Abonne
	 * @param nom - Le nom de l'abonne
	 * @param prenom - Le prenom de l'abonne
	 * @param mail - Le mail de l'abonne
	 * @param username - Le nom d'utilisateur de l'abonne
	 * @param password - Le mot de passe de l'abonne
	 */
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
	
	/**
	 * Set l'ID d'un abonné
	 * @param id
	 */
	public void setID(int id) {
		this.id = id;
	}
	
	/**
	 * Get l'id d'un abonné
	 * @return l'id de l'abonné choisi
	 */
	public int getID() {
		return this.id;
	}
	
	/**
	 * Set le nom d'un abonné
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Get le nom d'un abonné
	 * @return le nom de l'abonné choisi
	 */
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * Set le prenom d'un abonné
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/**
	 * Get le prenom d'un abonné
	 * @return prenom
	 */
	public String getPrenom() {
		return this.prenom;
	}
	
	/**
	 * Set le mail d'un abonné
	 * @param mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	/**
	 * Get le mail d'un abonné
	 * @return mail
	 */
	public String getMail() {
		return this.mail;
	}
	
	/**
	 * Set l'username d'un abonné
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Get l'username d'un abonné
	 * @return username
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * Set le password d'un abonné
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Get le password d'un abonné
	 * @return password
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Set la liste de flux d'un abonné
	 * @param list
	 */
	public void setListeFlux(ArrayList<Flux> list) {
		this.listeFlux = list;
	}
	
	/**
	 * Get la liste de flux d'un abonné
	 * @return listeFlux
	 */
	public ArrayList<Flux> getListeFlux(){
		return this.listeFlux;
	}
	
	/**
	 * Ajoute un flux à la liste de flux d'un abonné
	 * @param flux
	 */
	public void addFlux(Flux flux) {
		listeFlux.add(flux);
	}
	
	/**
	 * Supprime un flux de la liste de flux d'un abonné
	 * @param flux
	 */
	public void delFlux(Flux flux) {
		listeFlux.remove(flux);
	}
	
	/**
	 * Set la liste de contraintes d'un abonné
	 * @param list
	 */
	public void setListeContraintes(ArrayList<String> list) {
		this.listeContraintes = list;
	}
	
	/**
	 * Get la liste de contraintes d'un abonné
	 * @return listeFlux
	 */
	public ArrayList<Flux> getListeContraintes(){
		return this.listeFlux;
	}
	
	/**
	 * Ajoute une contrainte à la liste de contraintes d'un abonné
	 * @param contrainte
	 */
	public void addContraintes(String contrainte) {
		listeContraintes.add(contrainte);
	}
	
	/**
	 * Supprime une contrainte de la liste de contraintes d'un abonné
	 * @param contrainte
	 */
	public void delContraintes(String contrainte) {
		listeContraintes.remove(contrainte);
	}
	
	//-----------//
	/* FONCTIONS */
	//-----------//
	
	/**
	 * La fonction toString permet d'afficher les details d'un abonné dans la console
	 */
	public String toString() {
		return "ID: " + id +
			   "\nNom: " + nom +
			   "\nPrenom: " + prenom +
			   "\nMail: " + mail;
	}
	
	
	/**
	 * La fonction equals permet de comparer les détails de deux abonnés.
	 * @param myAbonne - Un abonné avec lequel comparer
	 * @return true si les deux abonnés sont identiques, false sinon
	 */
	public boolean equals(Abonne myAbonne) {
		return (id == myAbonne.id) && (nom.equals(myAbonne.nom)) && (prenom.equals(myAbonne.prenom)) && (mail.equals(myAbonne.mail));
	}
	
	/**
	 * La fonction subToFlux permet à un abonné de s'abonner à un flux grâce à l'ID du flux.
	 * @param refFlux L'ID du Flux
	 * @return true si l'abonnement s'est bien passé, false sinon.
	 */
	public boolean subToFlux(int refFlux) {
		for(Flux subbedFlux: listeFlux) {
			if(subbedFlux.getRef() == refFlux) {
				return false;
			}
		}
		
		for(Flux myFlux : IU.listeFlux) {
			if(myFlux.getRef() == refFlux) {
				listeFlux.add(myFlux);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * La fonction unsubToFlux permet à un abonné de se désabonner d'un flux grâce à l'ID du flux.
	 * @param refFlux L'ID du Flux
	 * @return true si le désabonnement s'est bien passé, false sinon.
	 */
	public boolean unsubFromFlux(int refFlux) {
		for(Flux myFlux : listeFlux) {
			if(myFlux.getRef() == refFlux) {
				delFlux(myFlux);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * La fonction checkFlux permet à un abonné de regarder les entrées du flux qu'il veut.
	 * @param myFlux le flux qu'il souhaite regarder
	 * @return les entrées du flux choisi
	 */
	public String checkFlux(int idFlux) {
		String content = "";
		for (Entry entry : IU.listeFlux.get(idFlux).getListeEntrees()) {
            content = content + "Title: " + entry.getTitre()
            + "\nPublished date: " + entry.getDatePublication()
            + "\nDescription: " + entry.getDescription();
            content = content + "\n\n";
        }
		return content;
	}
	
	/**
	 * La fonction saveFlux permet à un abonné de sauvegarder son flux pour qu'il puisse le regarder plus tard.
	 * @param myFlux le flux à sauvegarder
	 * @return true si le flux a bien été sauvegardé, false sinon
	 */
	public boolean saveFlux(int idFlux) {
		String filename = IU.listeFlux.get(idFlux).getNom().replaceAll("\\s", "")+".txt";
	    new File(filename);
	    try {
			FileWriter myWriter = new FileWriter(filename);
			for(Entry entry : IU.listeFlux.get(idFlux).getListeEntrees()) {
				myWriter.write("Titre: " + entry.getTitre() + "\n");
				myWriter.write("Date: " + entry.getDatePublication().toString() + "\n");
				myWriter.write(entry.getDescription() + "\n\n");
			}
			myWriter.write(IU.listeFlux.get(idFlux).getRef());
			myWriter.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
