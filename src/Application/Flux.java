package Application;

import java.time.LocalDate;
import java.util.ArrayList;

public class Flux {
	// Vars //
	private int ref;
	private static int count = 0;
	private String nom;
	private String url;
	private String langue;
	private LocalDate dateAjout;
	private String localisation;
	private ArrayList<Entry> listeEntrees;
	private ArrayList<Abonne> listeAbonnes;
	
	// Constructeur par d�faut //
	public Flux() {
		count++;
		ref = count;
		nom = "";
		url = "";
		langue = "";
		dateAjout = LocalDate.now();
		localisation = "";
		listeEntrees = new ArrayList<Entry>();
		listeAbonnes = new ArrayList<Abonne>();
	}
	
	// Constructeur //
	public Flux(String nom, String url, String langue, String localisation) {
		count++;
		this.ref = count;
		this.nom = nom;
		this.url = url;
		this.langue = langue;
		this.dateAjout = LocalDate.now();
		this.localisation = localisation;
		this.listeEntrees = new ArrayList<Entry>();
		this.listeAbonnes = new ArrayList<Abonne>();
	}
	
	//-------------------//
	/* SETTERS & GETTERS */
	//-------------------//
	
	// Reference //
	public void setRef(int ref) {
		this.ref = ref;
	}
	
	public int getRef() {
		return this.ref;
	}
	
	// Nom //
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getNom() {
		return this.nom;
	}
	
	// URL //
	public void setUrl(String url) {
		this.url = url;
	}
	
	public String getUrl(String url) {
		return this.url;
	}
	
	// Langue //
	public void setLangue(String langue) {
		this.langue = langue;
	}
	
	public String getLangue() {
		return this.langue;
	}
	
	// Date ajout //
	public void setDateAjout(LocalDate date) {
		this.dateAjout = date;
	}
	
	public LocalDate getDateAjout() {
		return this.dateAjout;
	}
	
	// Localisation //
	public void setLocalisation(String localisation) {
		this.localisation = localisation;
	}
	
	public String getLocalisation() {
		return this.localisation;
	}
	
	// Liste entr�es //
	public void setListeEntrees(ArrayList<Entry> list) {
		this.listeEntrees = list;
	}
	
	public ArrayList<Entry> getListeEntrees(){
		return this.listeEntrees;
	}
	
	public void addEntree(Entry myEntry) {
		listeEntrees.add(myEntry);
	}
	
	public void delEntree(Entry myEntry) {
		listeEntrees.remove(myEntry);
	}
	
	// Liste abonn�s //
	public void setListeAbonnes(ArrayList<Abonne> list) {
		this.listeAbonnes = list;
	}
	
	public ArrayList<Abonne> getListeAbonnes(){
		return this.listeAbonnes;
	}
	
	public void addAbonne(Abonne myAbonne) {
		listeAbonnes.add(myAbonne);
	}
	
	public void delAbonne(Abonne myAbonne) {
		listeAbonnes.remove(myAbonne);
	}
	
	//-----------//
	/* FONCTIONS */
	//-----------//
	
	// toString //
	public String toString() {
		return "R�f�rence: " + ref +
				"\nNom: " + nom +
				"\nUrl: " + url +
				"\nLangue: " + langue +
				"\nDate d'ajout: " + dateAjout +
				"\nLocalisation: " + localisation;
	}
	
	// equals //
	public boolean equals(Flux myFlux) {
		return (ref == myFlux.ref) && (nom.equals(myFlux.nom)) && (url.equals(myFlux.url)) && (langue.equals(myFlux.langue)) && (dateAjout == myFlux.dateAjout) && (localisation.equals(myFlux.localisation));
	}
}
