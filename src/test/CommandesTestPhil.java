package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CommandesTestPhil {
	
	@Test
	void testTPS() {
		double resultat = main.Commandes.ajoutTPS(100);
		assertEquals(105, resultat);
	}
	
	@Test
	void testTVQ() {
		double resultat = main.Commandes.ajoutTVQ(100);
		assertEquals(110, resultat);
	}

}
