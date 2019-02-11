import java.util.ArrayList;

public class Commandes {

	public String nom;
	public int quantite;

	ArrayList<Plats> plat = new ArrayList<>();
	
	double total = 0;
	
	public Commandes(String nom) {
		this.nom = nom;
	}

	public Commandes(String pnom, Plats plat, int pQuantite){
			nom = pnom;
			quantite = pQuantite;
			this.plat.add(plat);
	}
	
	
	
	@Override
	public String toString() {
		for(Plats p : plat) {
			total += p.prix;
		}
		return nom + " " + total + "$";
	}
}
