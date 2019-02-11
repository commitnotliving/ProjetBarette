import java.io.*;
import java.util.ArrayList;
public class mainTP1 {
	
	public static void main(String[] args) {
		
		ArrayList<Commandes> listeCommandes = new ArrayList<>();
		ArrayList<Plats> listePlats = new ArrayList<>();
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("commandes.txt"));
			String ligne;
			while((ligne = reader.readLine()) != null) {
				if(ligne.equals("Clients:")) {
					ligne = reader.readLine();
					while(!ligne.equals("Plats:")) {
						listeCommandes.add(new Commandes(ligne));
						ligne = reader.readLine();
					}
				}
				if(ligne.equals("Plats:")) {
					ligne = reader.readLine();
					while(!ligne.equals("Commandes:")) {
						String[] plat = new String[2];
						plat = ligne.split(" ");
						listePlats.add(new Plats(plat[0], Double.parseDouble(plat[1])));
						ligne = reader.readLine();
					}
				}
				if(ligne.equals("Commandes:")) {
					ligne = reader.readLine();
					while(!ligne.equals("Fin")) {
						String[] commande = new String[3];
						commande = ligne.split(" ");
						for(Commandes c : listeCommandes) {
							if(c.nom.equals(commande[0])) {
								for(Plats p : listePlats) {
									if(p.plat.equals(commande[1])) {
										for(int i = 0; i < Integer.parseInt(commande[2]); i++) {
											c.plat.add(p);
										}
									}
								}
							}
						}
						ligne = reader.readLine();
					}
				}
			}
			
			BufferedWriter writer = new BufferedWriter(new FileWriter("sortie.txt"));
			writer.write("Bienvenue chez Barette!");
			writer.newLine();
			writer.write("Factures:");
			writer.newLine();
			for(Commandes c : listeCommandes) {
				writer.write("\n" + c);
				writer.newLine();
			}
			writer.close();
			reader.close();
		} catch (IOException e) {
			System.out.println("Le fichier ne respecte pas le format demandé!");
		}
	}

}
