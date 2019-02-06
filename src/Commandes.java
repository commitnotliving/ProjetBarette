
public class Commandes {

	public String nom, plat;
	public int quantite;

	Plats die = new Plats();
	

	public Commandes(String pnom, String pPlat, int pQuantite){
			nom = pnom;
			plat = pPlat;	
			quantite = pQuantite;
			die = new Plats(plat);
	}
	
	
	
	@Override
	public String toString() {
		return nom + " " + die.prix * quantite + "$";
	}
}
