package tests;

import Application.Abonne;
import Application.Flux;
import Application.IU;

public class AbonneTest {
	static Flux myFlux = new Flux();
	static Abonne myAbo1 = new Abonne();
	static Abonne myAbo2 = new Abonne();
	
	public static boolean equalsTest() {
		return myAbo1.equals(myAbo2) == false;
	}
	
	public static boolean subToFluxTest() {
		myAbo1.subToFlux(0);
		return myAbo1.getListeFlux().get(0).getRef() == myFlux.getRef();
	}
	
	public static boolean unsubFromFluxTest() {
		myAbo1.unsubFromFlux(0);
		try {
			boolean res = myAbo1.getListeFlux().get(0).getRef() != myFlux.getRef();
			return res;
		} catch(Exception e) {
			return true;
		}
	}
	
	public static void main(String[] args) {
		IU.listeFlux.add(myFlux);
		System.out.println("Test equals(): " + equalsTest());
		System.out.println("Test subToFlux(): " + subToFluxTest());
		System.out.println("Test unsubFromFlux(): " + unsubFromFluxTest());
	}
}
