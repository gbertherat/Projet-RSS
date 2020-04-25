package Application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;


/**
 * La classe IU correspond a l'Interface Utilisateur, c'est elle qui contient les interactions entre l'utilisateur et l'application
 * @author Guillaume
 */
public class IU {
	private static int idConnected = 0;
	public static ArrayList<Entry> listeEntrees = new ArrayList<>();
	public static ArrayList<Flux> listeFlux = new ArrayList<>();
	public static ArrayList<Abonne> listeAbonnes = new ArrayList<>();
	private static Scanner myScanner = new Scanner(System.in);
	
	/**
	 * La fonction voirDetails() permet de voir les détails d'un flux
	 */
	private static void voirDetails() {
		int id = -1;
		System.out.print("Entrez l'ID du flux:\n>> ");
		try {
			id = myScanner.nextInt();
			System.out.println("\n" + listeFlux.get(id));
		} catch (Exception e){
			System.out.println("Erreur.");
		}
		myScanner.nextLine();
	}
	
	/**
	 * La fonction voirEntrees() permet de voir les entrées d'un flux
	 */
	private static void voirEntrees() {
		int id = -1;
		System.out.print("Entrez l'ID du flux:\n>> ");
		try {
			id = myScanner.nextInt();
			listeFlux.get(id).retrieveEntries();
			System.out.println(listeAbonnes.get(idConnected-1).checkFlux(id));
		} catch (Exception e) {
			System.out.println("Erreur.");
		}
		myScanner.nextLine();
	}
	
	private static void creerUnFlux() {
		if(idConnected != 0) {
			try {
				//String nom, String url, String langue, String localisation
				System.out.print("\nEntrez le nom du flux: ");
				String nom = myScanner.nextLine();
				
				System.out.print("\nEntrez l'url du flux: ");
				String url = myScanner.nextLine();
				
				System.out.print("\nEntrez la langue du flux: ");
				String langue = myScanner.nextLine();
				
				System.out.print("\nEntrez la localisation du flux: ");
				String localisation = myScanner.nextLine();
				listeFlux.add(new Flux(nom, url, langue, localisation));
			} catch(Exception e) {
				System.out.println("Erreur.");
			}
		}
	}
	
	/**
	 * La fonction filterUnFlux() permet de filtrerUnFlux
	 * @throws Exception
	 */
	private static void filtrerUnFlux() throws Exception {
		if(idConnected != 0) {
			int id = -1;
			System.out.print("Entrez l'ID du flux a filtrer:\n>> ");
			FluxFiltre flux = new FluxFiltre();
			try {
				id = myScanner.nextInt();
				myScanner.nextLine();
				flux.copyFlux(listeFlux.get(id));
			} catch (Exception e) {
				System.out.println("Erreur.");
				return;
			}
			
			boolean done = false;
			String mot;
			System.out.print("Entrez les mots a bannir:\n"
					+ "(Entrez done quand vous avez fini)");
			while(done == false) {
				System.out.print("\n>> ");
				mot = myScanner.nextLine();
				if(mot.equals("done")) {
					done = true;
				} else {
					flux.addToBlacklist(mot);
					System.out.println("Le mot a bien ete blackliste.\n");
				}
			}
			
			System.out.print("Entrez les mots a laisser passer uniquement:\n"
					+ "(Entrez done quand vous avez fini)");
			done = false;
			while(!done) {
				System.out.print("\n>> ");
				mot = myScanner.nextLine();
				if(mot.equals("done")) {
					done = true;
				} else {
					flux.addToWhitelist(mot);
					System.out.println("Le mot a bien ete whiteliste.\n");
				}
			}
			flux.setNom(flux.nom + " (filtre)");
			flux.retrieveFilteredEntries();
			listeFlux.add(flux);
		}
	}
	
	/**
	 * La fonction seConnecter() permet à l'utilisateur de se connecter
	 * @throws Exception
	 */
	private static void seConnecter() throws Exception {
		Abonne aboSel = null;
		String username;
		String password;
		boolean done = false;
		while(!done) {
			System.out.print("\n('Stop' pour annuler) Nom d'utilisateur: ");
			username = myScanner.nextLine();
			if(username.equals("stop") || username.equals("none")){
				main(null);
			} else {
				for(Abonne myAbo : listeAbonnes) {
					if(myAbo.getUsername().equals(username)) {
						aboSel = myAbo;
						done = true;
					}
				}
				if(aboSel == null) {
					System.out.println("Cette utilisateur n'existe pas.");
				}
			}
		}
		
		done = false;
		while(!done) {
			System.out.print("\n('Stop' pour annuler) Mot de passe: ");
			password = myScanner.nextLine();
			if(password.equals("stop")){
				main(null);
			} else if(aboSel.getPassword().equals(password)) {
				idConnected = aboSel.getID();
				done = true;
			} else {
				System.out.println("Mot de passe incorrecte.");
			}
		}
	}
	
	/**
	 * La fonction inscription permet à l'utilisateur de s'inscrire
	 */
	private static void inscription() {
		String nom;
		System.out.print("\nEntrez votre nom: ");
		nom = myScanner.nextLine();
		
		String prenom;
		System.out.print("\nEntrez votre prenom: ");
		prenom = myScanner.nextLine();
		
		String mail;
		System.out.print("\nEntrez votre mail: ");
		mail = myScanner.nextLine();
		
		String username = "";
		boolean duplicate = true;
		while(duplicate) {
			duplicate = false;
			System.out.print("\nEntrez votre nom d'utilisateur: ");
			username = myScanner.nextLine();
			for(Abonne abonne : listeAbonnes) {
				if(abonne.getUsername().equals(username)) {
					System.out.println("Utilisateur deja pris.");
					duplicate = true;
				}
			}
		}
		
		String password;
		System.out.print("\nEntrez votre mot de passe: ");
		password = myScanner.nextLine();
		
		listeAbonnes.add(new Abonne(nom, prenom, mail, username, password));
	}
	
	/**
	 * La fonction supprimerUnAbonne permet à un administrateur de supprimer un abonné
	 */
	private static void supprimerUnAbonne() {
		if(listeAbonnes.get(idConnected-1).getClass().getSimpleName().equals("Administrateur")) {
			int idSub;
			System.out.print("Entrez l'id de l'abonne a supprimer (ou -1 pour annuler): ");
			idSub = myScanner.nextInt();
			myScanner.nextLine();
			if(idSub == -1) {
				return;
			} else {
				for(Abonne abo : listeAbonnes) {
					if(abo.getID() == idSub) {
						abo.setMail("");
						abo.setNom("Abonne supprime");
						abo.setPrenom("");
						abo.setUsername("");
						abo.setPassword("");
						System.out.println("Abonne supprime.");
					}
				}
			}
		}
	}
	
	/**
	 * La fonction supprimerUnFlux permet à un administrateur de supprimer un flux
	 */
	private static void supprimerUnFlux() {
		if(listeAbonnes.get(idConnected-1).getClass().getSimpleName().equals("Administrateur")) {
			int idFlux;
			System.out.print("Entrez l'id du flux a supprimer (ou -1 pour annuler): ");
			idFlux = myScanner.nextInt();
			myScanner.nextLine();
			if(idFlux == -1) {
				return;
			} else {
				for(Flux flux : listeFlux) {
					if(flux.getRef() == idFlux) {
						flux.setNom("Flux supprime");
						flux.setUrl("");
						flux.setLangue("");
						flux.setLocalisation("");
						System.out.println("Flux supprime.");
						return;
					}
				}
			}
		}
	}
	
	/**
	 * La fonction subToFlux() permet à un abonné de s'abonner à un flux
	 */
	private static void subToFlux() {
		if(idConnected != 0) {
			int idFlux;
			System.out.print("Entrez l'id du flux auquel vous voulez vous abonner (ou -1 pour annuler): ");
			try {
				idFlux = myScanner.nextInt();
			} catch(Exception e) {
				System.out.println("Erreur.");
				return;
			}
			myScanner.nextLine();
			if(idFlux == -1) {
				return;
			} else {
				try {
					if(listeAbonnes.get(idConnected-1).subToFlux(idFlux)) {
						System.out.println("Abonnement enregistre.");
					} else {
						System.out.println("Erreur lors de l'abonnement.");
					}
				} catch(Exception e) {
					System.out.println("Erreur.");
					return;
				}
			}
		}
	}
	
	/**
	 * La fonction unsubFromFlux permet à un abonné de se désabonner d'un flux
	 */
	private static void unsubFromFlux() {
		if(idConnected != 0) {
			int idFlux;
			System.out.print("Entrez l'id du flux auquel vous voulez vous desabonner (ou -1 pour annuler): ");
			try {
				idFlux = myScanner.nextInt();
			} catch(Exception e) {
				System.out.println("Erreur.");
				return;
			}
			myScanner.nextLine();
			if(idFlux == -1) {
				return;
			} else {
				try {
					if(listeAbonnes.get(idConnected-1).unsubFromFlux(idFlux)) {
						System.out.println("Desabonnement enregistre.");
					} else {
						System.out.println("Erreur lors de l'abonnement.");
					}
				} catch(Exception e) {
					System.out.println("Erreur.");
					return;
				}
			}
		}
	}
	
	/**
	 * La fonction telechargerUnFlux permet à un abonné de télécharger un flux
	 */
	private static void telechargerUnFlux() {
		if(idConnected != 0) {
			int idFlux;
			System.out.print("Entrez l'id du flux que vous voulez telecharger (ou -1 pour annuler) : ");
			try {
				idFlux = myScanner.nextInt();
			} catch(Exception e) {
				System.out.println("Erreur");
				return;
			}
			myScanner.nextLine();
			if(idFlux == -1) {
				return;
			} else {
				try {
					if(listeAbonnes.get(idConnected-1).saveFlux(idFlux)) {
						System.out.println("Le flux a bien ete telecharge!");
					} else {
						System.out.println("Erreur lors du telechargement");
					}
				} catch(Exception e) {
					System.out.println("Erreur.");
					return;
				}
			}
		}
	}
	
	/**
	 * La fonction save_all permet de sauvegarder tous objets des classes dans des fichiers
	 */
	private static void save_all() {
		String entryFile = "listeEntrées.txt";
		new File(entryFile);
		
		String fluxFile = "listeFlux.txt";
	    new File(fluxFile);
	    
	    String abonneFile = "listeAbonnes.txt";
	    new File(abonneFile);
	    try {
	    	// Liste entrées
	    	FileWriter myWriter = new FileWriter(entryFile);
	    	for(Flux flux : listeFlux) {
	    		for(Entry entry : flux.getListeEntrees()) {
	    			myWriter.write("\n" + entry.toString());
	    		}
			}
			myWriter.close();
	    	
	    	// Liste flux
			FileWriter myWriter1 = new FileWriter(fluxFile);
			for(Flux flux : listeFlux) {
				myWriter1.write("\n" + flux.toString());
			}
			myWriter1.close();

			// Liste abonnés
			FileWriter myWriter2 = new FileWriter(abonneFile);
			for(Abonne abonne : listeAbonnes) {
				myWriter2.write("\n" + abonne.toString());
			}
			myWriter2.write("\n");
			myWriter2.close();
			
			
		} catch (IOException e) {
			e.printStackTrace();
			return;
		}
	}
	
	/**
	 * La fonction get_all permet de récupérer les objets des fichiers de sauvegarde.
	 * @throws IOException 
	 * @throws ParseException 
	 */
	private static void get_all() throws IOException, ParseException{
		// Entrées
		ArrayList<String> listeCategorie = new ArrayList<>();
		ArrayList<String> listeContent = new ArrayList<>();
		
		// Flux
		ArrayList<Entry> listeEntrees = new ArrayList<>();
		ArrayList<String> flux_listeCategories = new ArrayList<>();
		
		// Abonnés
		ArrayList<Flux> listeFlux = new ArrayList<>();
		ArrayList<String> listeContraintes = new ArrayList<>();
		
		BufferedReader reader;
		BufferedReader reader1;
		BufferedReader reader2;
			String line;
			Entry newEntry = null;
			Flux newFlux = null;
			Abonne newAbo = null;
			Flux getFlux = null;
			SimpleDateFormat format = new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy",Locale.ENGLISH);
			
			// Entrées
			reader = new BufferedReader(new FileReader("listeEntrées.txt"));
			line = reader.readLine();
			while(line != null) {
				// Entrées
				int id = -1;
				String titre = "";
				Date date = null;
				String description = "";		
				
				if(line.contains("ID:")) {
					newEntry = new Entry();
					id = Integer.parseInt(line.substring(4, line.length()));
					newEntry.setID(id);
				} else if(line.contains("Titre:")) {
					titre = line.substring(7, line.length());
					newEntry.setTitre(titre);
				} else if(line.contains("Date de publication:")) {
					date = format.parse(line.substring(21, line.length()));
					newEntry.setDatePublication(date);
				} else if(line.contains("Description:")) {
					description = line.substring(13, line.length());
					newEntry.setDescription(description);
				}
				
				if(line.contains("Liste catégories:")) {
					line = reader.readLine();
					while(!line.contains("Liste contenus")) {
						listeCategorie.add(line);
						line = reader.readLine();
					}
					newEntry.setListeCategories(listeCategorie);
				} 
				
				
				if(line.contains("Liste contenus")) {
					line = reader.readLine();
					while(!line.contains("ID:")) {
						listeContent.add(line);
						line = reader.readLine();
					}
					newEntry.setListeContenu(listeContent);
					IU.listeEntrees.add(newEntry);
				}
				line = reader.readLine();
			}
			reader.close();
			
			
			// Flux
			reader1 = new BufferedReader(new FileReader("listeFlux.txt"));
			line = reader1.readLine();
			line = reader1.readLine();
			while(line != null) {
				// Flux
				int ref = -1;
				String flux_nom = "";
				String url = "";
				String langue = "";
				LocalDate dateFlux = null;
				String localisation = "";
				
				if(line.contains("Reference:")) {
					newFlux = new Flux();
					ref = Integer.parseInt(line.substring(11, line.length()));
					newFlux.setRef(ref);
				} else if(line.contains("Nom:")) {
					flux_nom = line.substring(5, line.length());
					newFlux.setNom(flux_nom);
				} else if(line.contains("Url:")) {
					url = line.substring(5, line.length());
					newFlux.setUrl(url);
				} else if(line.contains("Langue:")) {
					langue = line.substring(8, line.length());
					newFlux.setLangue(langue);
				} else if(line.contains("Date d'ajout:")) {
					dateFlux = LocalDate.parse(line.substring(14, line.length()));
					newFlux.setDateAjout(dateFlux);
				} else if(line.contains("Localisation:")) {
					localisation = line.substring(14, line.length());
					newFlux.setLocalisation(localisation);
				} 
				
				if(line.contains("Liste entrées:")) {
					line = reader1.readLine();
					while(!line.contains("Liste catégories:")) {
						listeEntrees.add(IU.listeEntrees.get(Integer.parseInt(line)));
						line = reader1.readLine();
						System.out.println(line);
					}
					newFlux.setListeEntrees(listeEntrees);
				}
				
				if(line.contains("Liste catégories:")) {
					line = reader1.readLine();
					while(!line.contains("Liste abonnés:")) {
						flux_listeCategories.add(line);
						line = reader1.readLine();
					}
					newFlux.setListeCategories(flux_listeCategories);
					IU.listeFlux.add(newFlux);
					newFlux = null;
				}
				line = reader1.readLine();
			}
			reader1.close();
			
			// Abonnés
			reader2 = new BufferedReader(new FileReader("listeAbonnes.txt"));
			line = reader2.readLine();
			while(line != null) {
				// Abonnés
				int aboID = -1;
				String nom = "";
				String prenom = "";
				String mail = "";
				String username = "";
				String password = "";
				if(line.contains("ID:")) {
					newAbo = new Abonne();
					aboID = Integer.parseInt(line.substring(4));
					newAbo.setID(aboID);
					Abonne.count = newAbo.id;
				} else if(line.contains("Nom:")) {
					nom = line.substring(5);
					newAbo.setNom(nom);
				} else if(line.contains("Prenom:")) {
					prenom = line.substring(8);
					newAbo.setPrenom(prenom);
				} else if(line.contains("Mail:")) {
					mail = line.substring(6);
					newAbo.setMail(mail);
				} else if(line.contains("Username:")) {
					username = line.substring(10);
					newAbo.setUsername(username);
				} else if(line.contains("Password:")) {
					password = line.substring(10);
					newAbo.setPassword(password);
				}
				
				if(line.contains("Liste flux:")) {
					line = reader2.readLine();
					while(!line.contains("Liste contraintes:")) {
						getFlux = IU.listeFlux.get(Integer.parseInt(line));
						listeFlux.add(getFlux);
						getFlux.addAbonne(newAbo);
						line = reader2.readLine();
					}
					newAbo.setListeFlux(listeFlux);			
				}
				
				if(line.contains("Liste contraintes:")) {
					line = reader2.readLine();
					if(line != null) {
						while(!line.contains("Administrateur") && !line.contains("ID:")) {
							listeContraintes.add(line);
							line = reader2.readLine();	
						}
						if(line.contains("Administrateur")) {
							Abonne temp = new Abonne();
							temp.copyAbo(newAbo);
							newAbo = new Administrateur();
							newAbo.copyAbo(temp);
							newAbo.setID(newAbo.id+1);
							Abonne.count = newAbo.id;
							temp = null;
						}
					}
						System.out.println(newAbo+"\n\n");
						IU.listeAbonnes.add(newAbo);
						newAbo = null;
					if(line != null) {
						if(line.contains("ID:")) {
							newAbo = new Abonne();
							aboID = Integer.parseInt(line.substring(4));
							newAbo.setID(aboID-1);
							Abonne.count = newAbo.id;
						}
					}
				}
				line = reader2.readLine();
			}
			reader2.close();
	}
	
	/**
	 * La fonction main contient toute l'interface utilisateur
	 * @param args - Inutile
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		boolean retrieved = false;
		if(!retrieved) {
			get_all();
			retrieved = true;
		}
		
		while(true) {
			int choix = 0;
			// Options par defaut
			System.out.print("Que souhaitez-vous faire?\n"
					+ "1) Voir la liste des flux\n"
					+ "2) Voir les details d'un flux\n"
					+ "3) Voir les entrees d'un flux\n");
			if(idConnected != 0) { // Options si l'utilisateur est connecte
				System.out.print("6) Créer un flux\n"
						+ "7) Filtrer un flux\n"
						+ "8) S'abonner a un flux\n"
						+ "9) Se desabonner d'un flux\n"
						+ "10) Telecharger un flux\n"
						+ "11) Voir les informations de mon compte\n"
						+ "12) Voir les flux auxquels je suis abonne\n"
						+ "13) Se deconnecter\n");
				if(listeAbonnes.get(idConnected-1).getClass().getSimpleName().equals("Administrateur")) { // Options si l'utilisateur connecte est un administrateur
					System.out.print("14) Voir la liste des utilisateurs\n"
							+ "15) Supprimer un utilisateur\n"
							+ "16) Supprimer un flux\n"
							+ "17) Ajouter une contrainte a un utilisateur\n");
				}
			} else { // Options si l'utilisateur n'est pas connecte
				System.out.print("4) Se connecter\n"
						+ "5) S'inscrire\n");
			}
			System.out.print("18) Annuler\n"
					+ ">> ");
			
			try {
				choix = myScanner.nextInt();
			} catch(Exception e) {
				System.out.println("Erreur.");
			}
			
			if(choix == 18) {
				break;
			}
			
			System.out.println("");
			myScanner.nextLine();
			
			// Options par defaut
			switch(choix) { // Voir la liste des flux
				case 1:{
					System.out.println("Nom des flux:");
					for(Flux flux : listeFlux) {
						System.out.println(flux.getRef() + ") " + flux.getNom());
					}
					break;
				}
				case 2:{ // Voir les details d'un flux
					voirDetails();
					break;
				}
				case 3:{ // Voir les entrees d'un flux
					voirEntrees();
					break;
				}
				case 4:{ // Se connecter
					seConnecter();
					break;
				}
				case 5:{ // S'inscrire
					inscription();
					save_all();
					break;
				}
				case 6:{ // Créer un flux
					creerUnFlux();
					save_all();
					break;
				}
				case 7:{ // Filtrer un flux
					filtrerUnFlux();
					save_all();
					break;
				}
				// Options si l'utilisateur est connecte
				case 8:{ // S'abonner a un flux
					subToFlux();
					save_all();
					break;
				}
				case 9:{ // Se desabonner d'un flux
					unsubFromFlux();
					save_all();
					break;
				}
				case 10:{ // Telecharger un flux
					telechargerUnFlux();
					break;
				}
				case 11:{ // Voir les details du compte
					if(idConnected != 0) {
						System.out.println(listeAbonnes.get(idConnected-1));
					}
					break;
				}
				case 12:{ // Voir la liste des flux auxquels l'utilisateur est abonne
					if(idConnected != 0) {
						for(Flux flux: listeAbonnes.get(idConnected-1).getListeFlux()) {
							System.out.println(flux.getRef() + ") " + flux.getNom());
						}
					}
					break;
				} 
				case 13:{ // Se deconnecter
					idConnected = 0;
					break;
				}
				
				// Si l'utilisateur connecte est un administrateur
				case 14:{ // Voir la liste des abonnes
					if(listeAbonnes.get(idConnected-1).getClass().getSimpleName().equals("Administrateur")) {
						for(Abonne abonne : listeAbonnes) {
							System.out.println(abonne.getID() + ") " + abonne.getNom() + " " + abonne.getPrenom());
						}
					}
					break;
				}
				case 15:{ // Supprimer un abonne
					supprimerUnAbonne();
					save_all();
					break;
				}
				case 16:{ // Supprimer un flux
					supprimerUnFlux();
					save_all();
					break;
				}
			}
			
			System.out.println("");
		}
		myScanner.close();
	}
}
