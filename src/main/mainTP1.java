package main;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class mainTP1 {
	
	public static ArrayList<String> erreurs = new ArrayList();
	public static String terminal = "";
	public static boolean terminalEcrit = false;
	public static boolean fichierEcrit = false;
	public static ArrayList<Commandes> listeCommandes = new ArrayList<>();
	
	public static Date date = new Date();
	public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH'h'mm");
	
	
	public static void main(String[] args) {
		
		
		ArrayList<Plats> listePlats = new ArrayList<>();
		
		
		
		boolean nomCheck = false;
		
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
						if ( commande.length == 3 ) {
							for ( Commandes c : listeCommandes ) {
								if ( c.nom.equals( commande[0] ) ) {
									for ( Plats p : listePlats ) {
										if ( p.plat.equals( commande[1] ) ) {
											try {
												for ( int i = 0; i < Integer.parseInt( commande[2] ); i++ ) {
													c.plat.add( p );
												}
											} catch ( NumberFormatException e ) {
												ajoutErreur(
														"La quantité du plat " + commande[1] + " de la commande de "
																+ commande[0] + " est un nombre décimal." );
											}
										}
									}
									nomCheck = true;
								}
							} 
						}else {
							ajoutErreur("Une ligne de commande est mal formulée, le nom " + commande[0] + " a été lu.");
							nomCheck = true;
						}
						if(!nomCheck) {
							ajoutErreur( "Le client " + commande[0] + " n'existe pas." );
							break;
						}
						ligne = reader.readLine();
						nomCheck = false;
					}
				}
		}
			ecrireFichier();
			
			reader.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

	public static void ajoutErreur(String s) {
		erreurs.add( s );
	}
	
	public static void ecrireFichier() throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("Facture-du-" + dateFormat.format( date ) + ".txt"));
		for(String s : erreurs) {
			writer.write( s + "\n" );
			terminal += (s + "\n");
			writer.newLine();
		}
		writer.write("Bienvenue chez Barette!");
		terminal += ("Bienvenue chez Barette!\n");
		writer.newLine();
		writer.write("Factures:");
		terminal += ("Factures:\n");
		writer.newLine();
		for(Commandes c : listeCommandes) {
			if ( c.getPrix() != 0 ) {
				writer.write( "\n" + c );
				terminal += ( "\n" + c );
				writer.newLine();
			}
		}
		ecrireTerminal();
		writer.close();
		fichierEcrit = true;
	}
	
	public static void ecrireTerminal() {
		System.out.println( terminal );
		terminalEcrit = true;
	}

}
