package main;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Commandes {

	public String nom;
	public int quantite;
	NumberFormat nf = NumberFormat.getCurrencyInstance();

	public ArrayList<Plats> plat = new ArrayList<>();
	
	
	double total = 0;
	String output = "";

	public Commandes(String nom) {
		this.nom = nom;
	}

	public Commandes(String pnom, Plats plat, int pQuantite){
			nom = pnom;
			quantite = pQuantite;
			this.plat.add(plat);
	}
	
	
	
	public String getTotal() {
		getPrix();
		
		output = nom + " " + nf.format( total );
		total = 0;
		
		return output;
	}
	
	public double getPrix() {
		total = 0;
		for(Plats p : plat) {
			total +=  p.prix * 1.15 ;
		}
		
		return total;
	}
	
	@Override
	public String toString() {
		return getTotal();
	}
}
