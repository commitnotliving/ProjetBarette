package test;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class LectureFichierTest {
	
	main.LectureFichier lecture = new main.LectureFichier();

	@Test
	public void testAjoutErreur() {
		lecture.ajoutErreur( "Test" );
		assertTrue(lecture.erreurs.contains( "Test" ));
	}
	
	@Test
	public void testTerminal() {
		lecture.ecrireTerminal();
		assertTrue(lecture.terminalEcrit);
	}
	
	@Test
	public void testCommandesSansLigneClients() throws IOException {
		lecture.lireFichier( "testCommandesSansLigneClients.txt" );
		assertTrue(lecture.erreurs.contains( "La ligne Clients n'est pas lisible." ));
	}
	
	@Test
	public void testCommandesSansLignePlats() throws IOException {
		lecture.lireFichier( "testCommandesSansLignePlats.txt" );
		assertTrue(lecture.erreurs.contains( "La ligne Plats n'est pas lisible." ));
	}
	
	@Test
	public void testFichierSansErreurs() throws IOException {
		lecture.lireFichier( "commandes.txt" );
		assertTrue(lecture.erreurs.isEmpty());
	}
	
	@Test
	public void testFichierQuantitePlatDecimale() {
		lecture.lireFichier( "testCommandesQuantitePlatDecimale.txt" );
		assertTrue(lecture.erreurs.contains( "La quantité du plat Poutine de la commande de Roger est un nombre décimal." ));
	}
	
	@Test
	public void testFichierCommandesMalFormulee() {
		lecture.lireFichier( "testCommandesMalFormulee.txt" );
		assertTrue(lecture.erreurs.contains( "Une ligne de commande est mal formulée, le nom RogerPoutine a été lu." ));
	}
	
	@Test
	public void testFichierNomInconnu() {
		lecture.lireFichier( "testCommandesNomInconnu.txt" );
		assertTrue(lecture.erreurs.contains( "Le client Paul n'existe pas." ));
	}
	
	@Test
	public void testFichierPlatInconnu() {
		lecture.lireFichier( "testCommandesPlatInconnu.txt" );
		assertTrue(lecture.erreurs.contains( "Le plat Banane n'existe pas." ));
	}
}
