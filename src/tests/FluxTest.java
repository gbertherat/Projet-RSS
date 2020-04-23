package tests;

import Application.Flux;

public class FluxTest {
	static Flux myFlux = new Flux();
	static Flux myFlux1 = new Flux();
	
	public static boolean equalsTest() {
		return myFlux.equals(myFlux1) == false;
	}
	
	public static boolean retrieveEntriesTest() throws Exception {
		myFlux.retrieveEntries();
		return myFlux.getListeEntrees().size() > 1;
		
	}
	
	public static void main(String[] args) throws Exception {
		myFlux.setUrl("https://www.sciencedaily.com/rss/all.xml");
		System.out.println("Test equals(): " + equalsTest());
		System.out.println("Test retrieveEntries(): " + retrieveEntriesTest());
	}

}
