package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Commandes;
import main.Plats;

public class CommandesTest {

	@Test
	public void testAjoutPlat() {
		Plats plat = new Plats("Pomme", 2.5);
		Commandes com = new Commandes("Paul", plat, 1);
		assertTrue(com.plat.contains( plat ));
	}

}
