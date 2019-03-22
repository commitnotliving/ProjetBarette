package main;

import java.util.ArrayList;

public class Plats {

	public String plat;
	public double prix;
	
	public ArrayList<String> listeNoms = new ArrayList<String>();

	public Plats(String pPlat, double prix){
			
			plat = pPlat;
			this.prix = prix;
			listeNoms.add( pPlat );

	}
	
	public double getPrix() {
		return this.prix * 1.15;
	}
	
	public String getNomPlat() {
		return this.plat;
	}

	public double getPrixSansTaxes() {
		return this.prix;
	}

}
