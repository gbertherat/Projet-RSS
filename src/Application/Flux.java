package Application;

import com.sun.syndication.feed.synd.SyndCategoryImpl;
import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


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
	
	// Constructeur par défaut //
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
	
	public String getUrl() {
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
	
	// Liste entrées //
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
	
	// Liste abonnés //
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
		return "Référence: " + ref +
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
	
	public void retrieveEntries() throws Exception {
		URL feedUrl = new URL(url);
        SyndFeedInput input = new SyndFeedInput();
        SyndFeed feed = input.build(new XmlReader(feedUrl));
        for (SyndEntry entry : (List<SyndEntry>) feed.getEntries()){
        	 Entry newEntry = new Entry(entry.getTitle(), entry.getDescription().getValue(), entry.getPublishedDate());

             for (SyndCategoryImpl category : (List<SyndCategoryImpl>) entry.getCategories()) {
            	 newEntry.addCategorie(category.getName());
             }
             listeEntrees.add(newEntry);
        }
	}
}
