package tests;

import Application.FluxFiltre;

public class FluxFiltreTest {
	
	static FluxFiltre myFlux = new FluxFiltre();
	static FluxFiltre myFlux1 = new FluxFiltre();

	public static boolean equalsTest() {
		return myFlux.equals(myFlux1) == false;
	}
	
	public static boolean retrieveFilteredEntriesTest() throws Exception {
		myFlux.retrieveFilteredEntries();
		return myFlux.getListeEntrees().size() > 1;
		
	}
	
	public static void main(String[] args) throws Exception {
		myFlux.setUrl("https://www.sciencedaily.com/rss/all.xml");
		myFlux.addToBlacklist("love");
		System.out.println("Test equals(): " + equalsTest());
		System.out.println("Test retrieveFilteredEntries(): " + retrieveFilteredEntriesTest());
	}

}
