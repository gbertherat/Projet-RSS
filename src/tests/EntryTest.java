package tests;

import Application.Entry;

public class EntryTest {
	static Entry myEntry = new Entry();
	static Entry myEntry2 = new Entry();
	
	public static boolean equalsTest() {
		return myEntry.equals(myEntry2) == false;
	}
	
	public static void main(String[] args) {
		System.out.println("Test equals(): " + equalsTest());
	}

}
