package Application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * La classe Abonne permet la creation d'Abonne de flux.
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
	 * Le constructeur par defaut de la classe Abonne
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
	 * Set l'ID d'un abonne
	 * @param id
	 */
	public void setID(int id) {
		this.id = id;
	}
	
	/**
	 * Get l'id d'un abonne
	 * @return l'id de l'abonne choisi
	 */
	public int getID() {
		return this.id;
	}
	
	/**
	 * Set le nom d'un abonne
	 * @param nom
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	/**
	 * Get le nom d'un abonne
	 * @return le nom de l'abonne choisi
	 */
	public String getNom() {
		return this.nom;
	}
	
	/**
	 * Set le prenom d'un abonne
	 * @param prenom
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
	/**
	 * Get le prenom d'un abonne
	 * @return prenom
	 */
	public String getPrenom() {
		return this.prenom;
	}
	
	/**
	 * Set le mail d'un abonne
	 * @param mail
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}
	
	/**
	 * Get le mail d'un abonne
	 * @return mail
	 */
	public String getMail() {
		return this.mail;
	}
	
	/**
	 * Set l'username d'un abonne
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Get l'username d'un abonne
	 * @return username
	 */
	public String getUsername() {
		return this.username;
	}
	
	/**
	 * Set le password d'un abonne
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * Get le password d'un abonne
	 * @return password
	 */
	public String getPassword() {
		return this.password;
	}
	
	/**
	 * Set la liste de flux d'un abonne
	 * @param list
	 */
	public void setListeFlux(ArrayList<Flux> list) {
		this.listeFlux = list;
	}
	
	/**
	 * Get la liste de flux d'un abonne
	 * @return listeFlux
	 */
	public ArrayList<Flux> getListeFlux(){
		return this.listeFlux;
	}
	
	/**
	 * Ajoute un flux a la liste de flux d'un abonne
	 * @param flux
	 */
	public void addFlux(Flux flux) {
		listeFlux.add(flux);
	}
	
	/**
	 * Supprime un flux de la liste de flux d'un abonne
	 * @param flux
	 */
	public void delFlux(Flux flux) {
		listeFlux.remove(flux);
	}
	
	/**
	 * Set la liste de contraintes d'un abonne
	 * @param list
	 */
	public void setListeContraintes(ArrayList<String> list) {
		this.listeContraintes = list;
	}
	
	/**
	 * Get la liste de contraintes d'un abonne
	 * @return listeFlux
	 */
	public ArrayList<Flux> getListeContraintes(){
		return this.listeFlux;
	}
	
	/**
	 * Ajoute une contrainte a la liste de contraintes d'un abonne
	 * @param contrainte
	 */
	public void addContraintes(String contrainte) {
		listeContraintes.add(contrainte);
	}
	
	/**
	 * Supprime une contrainte de la liste de contraintes d'un abonne
	 * @param contrainte
	 */
	public void delContraintes(String contrainte) {
		listeContraintes.remove(contrainte);
	}
	
	//-----------//
	/* FONCTIONS */
	//-----------//
	
	/**
	 * La fonction toString permet d'afficher les details d'un abonne dans la console
	 */
	public String toString() {
		StringBuffer toReturn = new StringBuffer("ID: " + id +
			   "\nNom: " + nom +
			   "\nPrenom: " + prenom +
			   "\nMail: " + mail +
			   "\nUsername: " + username +
			   "\nPassword: " + password);
		
		toReturn.append("\nListe flux:");
		try{
			for(Flux flux : listeFlux) {
				toReturn.append("\n" + flux.getRef());
			}
		} catch(Exception e) {
			;
		}
		
		toReturn.append("\nListe contraintes:");
		try{
			for(String contrainte : listeContraintes) {
				toReturn.append("\n" + contrainte);
			}
		} catch(Exception e) {
			;
		}
		
		return toReturn.toString();
	}
	
	
	/**
	 * La fonction equals permet de comparer les details de deux abonnes.
	 * @param myAbonne - Un abonne avec lequel comparer
	 * @return true si les deux abonnes sont identiques, false sinon
	 */
	public boolean equals(Abonne myAbonne) {
		return (id == myAbonne.id) && (nom.equals(myAbonne.nom)) && (prenom.equals(myAbonne.prenom)) && (mail.equals(myAbonne.mail));
	}
	
	/**
	 * La fonction subToFlux permet a un abonne de s'abonner a un flux grâce a l'ID du flux.
	 * @param refFlux L'ID du Flux
	 * @return true si l'abonnement s'est bien passe, false sinon.
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
	 * La fonction unsubToFlux permet a un abonne de se desabonner d'un flux grâce a l'ID du flux.
	 * @param refFlux L'ID du Flux
	 * @return true si le desabonnement s'est bien passe, false sinon.
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
	 * La fonction checkFlux permet a un abonne de regarder les entrees du flux qu'il veut.
	 * @param idFlux le flux qu'il souhaite regarder
	 * @return les entrees du flux choisi
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
	 * La fonction saveFlux permet a un abonne de sauvegarder son flux pour qu'il puisse le regarder plus tard.
	 * @param idFlux le flux a sauvegarder
	 * @return true si le flux a bien ete sauvegarde, false sinon
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
