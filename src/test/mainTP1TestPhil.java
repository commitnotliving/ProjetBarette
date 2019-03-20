package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class mainTP1TestPhil {

	@Test
	void testErreursClient() {
		boolean erreurs = main.mainTP1.erreursClient.isEmpty();
		assertFalse(erreurs);
	}
	
	@Test
	void testErreursPlats() {
		boolean erreurs = main.mainTP1.erreursPlats.isEmpty();
		assertFalse(erreurs);
	}
	
	@Test
	void testErreursCommandes() {
		boolean erreurs = main.mainTP1.erreursCommandes.isEmpty();
		assertFalse(erreurs);
	}

}
