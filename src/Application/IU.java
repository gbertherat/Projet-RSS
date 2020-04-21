package Application;

import java.util.ArrayList;

public class IU {
	public static ArrayList<Flux> listeFlux = new ArrayList<>();
	
	public static void main(String[] args) throws Exception {
		Flux myFlux = new Flux("Science Daily", "https://www.sciencedaily.com/rss/all.xml", "Anglais", "");
		myFlux.retrieveEntries();
		listeFlux.add(myFlux);
		
		FluxFiltre myFluxFiltre = new FluxFiltre("Science Daily (filtré)", "https://www.sciencedaily.com/rss/all.xml", "Anglais", "", null);
		myFluxFiltre.addToWhitelist("covid-19");
		
		myFluxFiltre.retrieveFilteredEntries();
		listeFlux.add(myFluxFiltre);
		
		Abonne myAbonne = new Abonne();
		System.out.println(myAbonne.checkFlux(1));
	}
}
