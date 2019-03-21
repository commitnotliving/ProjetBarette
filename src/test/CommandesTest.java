package test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import main.Commandes;
import main.Plats;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class CommandesTest {
	
	Commandes com;
	@Mock
	Plats plat;
	
	@Before
	public void setUp() {
		com = new Commandes("test", plat, 1);
	}
	
	@After
	public void setNull() {
		com = null;
		plat = null;
	}
	
	@Test
	public void testPrixAvecTaxes() {
		Mockito.when(plat.getPrix()).thenReturn(115.00);
		assertEquals(115.00, com.getPrix(), 0);
	}

	@Test
	public void testAjoutPlat() {
		Mockito.when( plat.getNomPlat()).thenReturn( "test" );
		assertTrue(com.plat.contains( plat ));
	}
	
	
//	@Test
//	public void testAjoutTPS() {
//		com = new Commandes("test");
//		double resultat = com.ajoutTPS( 100 );
//		assertEquals(105, resultat, 0);
//	}
//
//	@Test
//	public void testAjoutTVQ() {
//		com = new Commandes("test");
//		double resultat = com.ajoutTVQ( 100 );
//		assertEquals(110, resultat, 0.01);
//	}

}
