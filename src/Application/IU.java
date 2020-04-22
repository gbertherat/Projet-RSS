package Application;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * La classe IU correspond a l'Interface Utilisateur, c'est elle qui contient les interactions entre l'utilisateur et l'application
 * @author Guillaume
 */
public class IU {
	public static ArrayList<Flux> listeFlux = new ArrayList<>();
	public static ArrayList<Abonne> listeAbonnes = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		Flux myFlux = new Flux("Science Daily", "https://www.sciencedaily.com/rss/all.xml", "Anglais", "");
		myFlux.retrieveEntries();
		listeFlux.add(myFlux);
		
		Abonne guest = new Abonne();
		guest.setNom("guest");
		listeAbonnes.add(guest);
		
		Administrateur admin = new Administrateur("admin", "", "", "admin", "admin");
		listeAbonnes.add(admin);
		
		int idConnected = 0;
		Scanner myScanner = new Scanner(System.in);
		
		while(true) {
			int choix = 0;
			// Options par defaut
			System.out.print("Que souhaitez-vous faire?\n"
					+ "1) Voir la liste des flux\n"
					+ "2) Voir les details d'un flux\n"
					+ "3) Voir les entrees d'un flux\n"
					+ "4) Filtrer un flux\n");
			if(idConnected != 0) { // Options si l'utilisateur est connecte
				System.out.print("7) S'abonner a un flux\n"
						+ "8) Se desabonner d'un flux\n"
						+ "9) Telecharger un flux\n"
						+ "10) Voir les informations de mon compte\n"
						+ "11) Voir les flux auxquels je suis abonne\n"
						+ "12) Se deconnecter\n");
				if(listeAbonnes.get(idConnected).getClass().getSimpleName().equals("Administrateur")) { // Options si l'utilisateur connecte est un administrateur
					System.out.print("13) Voir la liste des utilisateurs\n"
							+ "14) Supprimer un utilisateur\n"
							+ "15) Supprimer un flux\n"
							+ "16) Ajouter une contrainte a un utilisateur\n");
				}
			} else { // Options si l'utilisateur n'est pas connecte
				System.out.print("5) Se connecter\n"
						+ "6) S'inscrire\n");
			}
			System.out.print("17) Annuler\n"
					+ ">> ");
			
			choix = myScanner.nextInt();
			
			if(choix == 17) {
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
					int id = -1;
					System.out.print("Entrez l'ID du flux:\n>> ");
					try {
						id = myScanner.nextInt();
						System.out.println("\n" + listeFlux.get(id));
					} catch (Exception e){
						System.out.println("Erreur.");
					}
					myScanner.nextLine();
					break;
				}
				case 3:{ // Voir les entrees d'un flux
					int id = -1;
					System.out.print("Entrez l'ID du flux:\n>> ");
					try {
						id = myScanner.nextInt();
						System.out.println(listeAbonnes.get(idConnected).checkFlux(id));
					} catch (Exception e) {
						System.out.println("Erreur.");
					}
					myScanner.nextLine();
					break;
				}
				case 4:{ // Filtrer un flux
					int id = -1;
					System.out.print("Entrez l'ID du flux a filtrer:\n>> ");
					FluxFiltre flux = new FluxFiltre();
					try {
						id = myScanner.nextInt();
						myScanner.nextLine();
						flux.copyFlux(listeFlux.get(id));
					} catch (Exception e) {
						System.out.println("Erreur.");
						break;
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
					break;
				} // Se connecter
				case 5:{
					Abonne aboSel = null;
					String username;
					String password;
					boolean done = false;
					while(!done) {
						System.out.print("\n('Stop' pour annuler) Nom d'utilisateur: ");
						username = myScanner.nextLine();
						if(username.equals("stop")){
							main(args);
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
							main(args);
						} else if(aboSel.getPassword().equals(password)) {
							idConnected = aboSel.getID()-1;
							done = true;
						} else {
							System.out.println("Mot de passe incorrecte.");
						}
					}
					break;
				}
				case 6:{ // S'inscrire
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
					break;
				}
				
				// Options si l'utilisateur est connecte
				case 7:{ // S'abonner a un flux
					if(idConnected != 0) {
						int idFlux;
						System.out.print("Entrez l'id du flux auquel vous voulez vous abonner (ou -1 pour annuler): ");
						try {
							idFlux = myScanner.nextInt();
						} catch(Exception e) {
							System.out.println("Erreur.");
							break;
						}
						myScanner.nextLine();
						if(idFlux == -1) {
							break;
						} else {
							try {
								if(listeAbonnes.get(idConnected).subToFlux(idFlux)) {
									System.out.println("Abonnement enregistre.");
								} else {
									System.out.println("Erreur lors de l'abonnement.");
								}
							} catch(Exception e) {
								System.out.println("Erreur.");
								break;
							}
						}
					}
					break;
				}
				case 8:{ // Se desabonner d'un flux
					if(idConnected != 0) {
						int idFlux;
						System.out.print("Entrez l'id du flux auquel vous voulez vous desabonner (ou -1 pour annuler): ");
						try {
							idFlux = myScanner.nextInt();
						} catch(Exception e) {
							System.out.println("Erreur.");
							break;
						}
						myScanner.nextLine();
						if(idFlux == -1) {
							break;
						} else {
							try {
								if(listeAbonnes.get(idConnected).unsubFromFlux(idFlux)) {
									System.out.println("Desabonnement enregistre.");
								} else {
									System.out.println("Erreur lors de l'abonnement.");
								}
							} catch(Exception e) {
								System.out.println("Erreur.");
								break;
							}
						}
					}
					break;
				}
				case 9:{ // Telecharger un flux
					if(idConnected != 0) {
						int idFlux;
						System.out.print("Entrez l'id du flux que vous voulez telecharger (ou -1 pour annuler) : ");
						try {
							idFlux = myScanner.nextInt();
						} catch(Exception e) {
							System.out.println("Erreur");
							break;
						}
						myScanner.nextLine();
						if(idFlux == -1) {
							break;
						} else {
							try {
								if(listeAbonnes.get(idConnected).saveFlux(idFlux)) {
									System.out.println("Le flux a bien ete telecharge!");
								} else {
									System.out.println("Erreur lors du telechargement");
								}
							} catch(Exception e) {
								System.out.println("Erreur.");
								break;
							}
						}
					}
					break;
				}
				case 10:{ // Voir les details du compte
					if(idConnected != 0) {
						System.out.println(listeAbonnes.get(idConnected));
					}
					break;
				}
				case 11:{ // Voir la liste des flux auxquels l'utilisateur est abonne
					if(idConnected != 0) {
						for(Flux flux: listeAbonnes.get(idConnected).getListeFlux()) {
							System.out.println(flux.getRef() + ") " + flux.getNom());
						}
					}
					break;
				} 
				case 12:{ // Se deconnecter
					idConnected = 0;
					break;
				}
				
				// Si l'utilisateur connecte est un administrateur
				case 13:{ // Voir la liste des abonnes
					if(listeAbonnes.get(idConnected).getClass().getSimpleName().equals("Administrateur")) {
						for(Abonne abonne : listeAbonnes) {
							System.out.println(abonne.getID() + ") " + abonne.getNom() + " " + abonne.getPrenom());
						}
					}
					break;
				}
				case 14:{ // Supprimer un abonne
					if(listeAbonnes.get(idConnected).getClass().getSimpleName().equals("Administrateur")) {
						int idSub;
						System.out.print("Entrez l'id de l'abonne a supprimer (ou -1 pour annuler): ");
						idSub = myScanner.nextInt();
						myScanner.nextLine();
						if(idSub == -1) {
							break;
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
					break;
				}
				case 15:{ // Supprimer un flux
					if(listeAbonnes.get(idConnected).getClass().getSimpleName().equals("Administrateur")) {
						int idFlux;
						System.out.print("Entrez l'id du flux a supprimer (ou -1 pour annuler): ");
						idFlux = myScanner.nextInt();
						myScanner.nextLine();
						if(idFlux == -1) {
							break;
						} else {
							for(Flux flux : listeFlux) {
								if(flux.getRef() == idFlux) {
									flux.setNom("Flux supprime");
									flux.setUrl("");
									flux.setLangue("");
									flux.setLocalisation("");
									System.out.println("Flux supprime.");
									break;
								}
							}
						}
					}
					break;
				}
			}
			
			System.out.println("");
		}
		myScanner.close();
	}
}
