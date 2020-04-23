package tests;

import Application.FicheInscription;

public class FicheInscriptionTest {
	static FicheInscription myFiche = new FicheInscription();
	static FicheInscription myFiche1 = new FicheInscription();
	
	public static boolean equalsTest() {
		return myFiche.equals(myFiche1) == false;
	}
	
	public static void main(String[] args) {
		System.out.println("Test equals(): " + equalsTest());
	}

}
