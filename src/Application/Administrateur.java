package Application;

/**
 * La classe Administrateur permet la creation de compte administrateur.
 * @author Guillaume
 * @see Abonne
 */
public class Administrateur extends Abonne{
	public Administrateur() {
		super();
	}
	
	public Administrateur(String nom, String prenom, String mail, String username, String password) {
		super(nom, prenom, mail, username, password);
	}
	
	public String toString() {
		return super.toString() 
				+ "\nAdministrateur";
	}
	
	public void copyAbo(Abonne myAbo) {
		id = myAbo.id;
		nom = myAbo.nom;
		prenom = myAbo.prenom;
		mail = myAbo.mail;
		username = myAbo.username;
		password = myAbo.password;
	}
}
