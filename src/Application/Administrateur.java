package Application;

/**
 * La classe Administrateur permet la création de compte administrateur.
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
}
