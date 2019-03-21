package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LectureFichier {
	
	public ArrayList<String> erreurs = new ArrayList();
	public String terminal = "";
	public boolean terminalEcrit = false;
	public boolean fichierEcrit = false;
	public ArrayList<Commandes> listeCommandes = new ArrayList<>();
	
	public Date date = new Date();
	public DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HH'h'mm");
	public BufferedReader reader;
	
	public LectureFichier() {
		
	}
	
	public void lireFichier(String fichier) {
		ArrayList<Plats> listePlats = new ArrayList<>();
		
		boolean clientsMiss = false;
		boolean clientsPres = false;
		boolean platsMiss = false;
		boolean nomCheck = false;
		boolean platCheck = false;
		
		try {
			reader = new BufferedReader(new FileReader(fichier));
			String ligne;
			while((ligne = reader.readLine()) != null) {
				if(ligne.equals("Clients:")) {
					clientsPres = true;
					ligne = reader.readLine();
					while(!ligne.equals("Plats:")) {
						if ( ligne.split( " " ).length == 1 ) {
							listeCommandes.add( new Commandes( ligne ) );
							ligne = reader.readLine();
						}else {
							break;
						}
					}
				}else if(!clientsMiss && !clientsPres) {
					ajoutErreur( "La ligne Clients n'est pas lisible." );
					clientsMiss = true;
				}
				if(ligne.equals("Plats:")) {
					ligne = reader.readLine();
					while(!ligne.equals("Commandes:")) {
						String[] plat = new String[2];
						plat = ligne.split(" ");
						listePlats.add(new Plats(plat[0], Double.parseDouble(plat[1])));
						ligne = reader.readLine();
					}
				}else if(!platsMiss) {
					ajoutErreur("La ligne Plats n'est pas lisible.");
					platsMiss = true;
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
											platCheck = true;
										}
									}
									nomCheck = true;
								}
							} 
						}else {
							ajoutErreur("Une ligne de commande est mal formulée, le nom " + commande[0] + " a été lu.");
							nomCheck = true;
						}
						if(!nomCheck && !erreurs.contains( "Le client " + commande[0] + " n'existe pas." )) {
							ajoutErreur( "Le client " + commande[0] + " n'existe pas." );
						}
						if(!platCheck && !erreurs.contains( "Le plat " + commande[1] + " n'existe pas." )) {
							ajoutErreur( "Le plat " + commande[1] + " n'existe pas." );
						}
						ligne = reader.readLine();
						nomCheck = false;
						platCheck = false;
					}
					
				}
		}
			ecrireFichier();
			
			reader.close();
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void ajoutErreur(String s) {
		erreurs.add( s );
	}
	
	public void ecrireFichier() throws IOException {
		BufferedWriter writer = new BufferedWriter(new FileWriter("Facture-du-" + dateFormat.format( date ) + ".txt"));
		for(String s : erreurs) {
			writer.write( s + "\n" );
			terminal += (s + "\n");
			writer.newLine();
		}
		if ( erreurs.isEmpty() ) {
			writer.write( "Bienvenue chez Barette!" );
			terminal += ( "Bienvenue chez Barette!\n" );
			writer.newLine();
			writer.write( "Factures:" );
			terminal += ( "Factures:\n" );
			writer.newLine();
			for ( Commandes c : listeCommandes ) {
				if ( c.getPrix() != 0 ) {
					writer.write( "\n" + c );
					terminal += ( "\n" + c );
					writer.newLine();
				}
			} 
		}
		ecrireTerminal();
		writer.close();
		fichierEcrit = true;
	}
	
	public void ecrireTerminal() {
		System.out.println( terminal );
		terminalEcrit = true;
	}
}
