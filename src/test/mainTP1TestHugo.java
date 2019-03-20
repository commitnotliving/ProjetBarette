package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class mainTP1TestHugo {

	@Test
	void testAjoutErreur() {
		main.mainTP1.ajoutErreur( "test" );
		boolean resultat = main.mainTP1.erreurs.isEmpty();
		assertFalse(resultat);
	}

}
