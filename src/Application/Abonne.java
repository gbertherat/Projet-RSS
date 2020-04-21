package Application;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
            + "\nDescription: " + entry.getDescription()
            + "\nCatégorie(s): ";
            for(String categorie : entry.getCategorie()) {
            	content = content + categorie + ", ";
            }
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
		String filename = "flux.txt";
	    new File(filename);
	    try {
			FileWriter myWriter = new FileWriter(filename);
			myWriter.write(IU.listeFlux.get(idFlux).getRef());
			myWriter.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
}
