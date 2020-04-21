package Application;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * La classe IU correspond à l'Interface Utilisateur, c'est elle qui contient les interactions entre l'utilisateur et l'application
 * @author Guillaume
 */
public class IU {
	public static ArrayList<Flux> listeFlux = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		Flux myFlux = new Flux("Science Daily", "https://www.sciencedaily.com/rss/all.xml", "Anglais", "");
		myFlux.retrieveEntries();
		listeFlux.add(myFlux);
		
		Abonne abonne = new Abonne();
		
		Scanner myScanner = new Scanner(System.in);
		
		while(true) {
			int choix = 0;
			System.out.print("Que souhaitez-vous faire?\n"
					+ "1) Voir la liste des flux\n"
					+ "2) Voir les détails d'un flux\n"
					+ "3) Voir les entrées d'un flux\n"
					+ "4) Filtrer un flux\n"
					+ "5) Se connecter\n"
					+ "6) Enregistrer un flux\n"
					+ "7) Annuler\n"
					+ ">> ");
			
			choix = myScanner.nextInt();
			
			if(choix == 7) {break;}
			
			System.out.println("");
			
			switch(choix) {
				case 1:{
					System.out.println("Nom des flux:");
					for(Flux flux : listeFlux) {
						System.out.println(flux.getRef() + ") " + flux.getNom());
					}
					break;
				}
				case 2:{
					int id = -1;
					System.out.print("Entrez l'ID du flux:\n>> ");
					id = myScanner.nextInt();
					System.out.println("\n" + listeFlux.get(id));
					break;
				}
				case 3:{
					int id = -1;
					System.out.print("Entrez l'ID du flux:\n>> ");
					id = myScanner.nextInt();
					System.out.println(abonne.checkFlux(id));
					break;
				}
				case 4:{
					int id = -1;
					System.out.print("Entrez l'ID du flux à filtrer:\n>> ");
					id = myScanner.nextInt();
					
					FluxFiltre flux = new FluxFiltre();
					flux.copyFlux(listeFlux.get(id));
					
					boolean done = false;
					String mot;
					System.out.println("Entrez les mots à bannir:\n"
							+ "(Entrez done quand vous avez fini)\n"
							+ "\n>> ");
					while(done == false) {
						mot = myScanner.nextLine();
						if(mot.equals("done")) {done = true;}
						else {
							flux.addToBlacklist(mot);
							System.out.println("Le mot a bien été blacklisté.\n");
						}
					}
					
					System.out.println("Entrez les mots à laisser passer uniquement:\n"
							+ "(Entrez done quand vous avez fini)\n"
							+ "\n>> ");
					done = false;
					while(done == false) {
						mot = myScanner.nextLine();
						if(mot.equals("done")) {done = true;}
						else {
							flux.addToWhitelist(mot);
							System.out.println("Le mot a bien été whitelisté.\n");
						}
					}
					listeFlux.add(flux);
					break;
				}
			}
			
			System.out.println("");
		}
		myScanner.close();
	}
}
