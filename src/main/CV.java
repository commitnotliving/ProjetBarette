package main;

public class CV {
	
	public String nom,
	  			  prenom,
	  			  formation,
	  			  competences,
	  			  attentes;
	public int experiences;

	public CV(String pnom, String pprenom, String pformation, int pexperiences, String pcompetences, 
		String pattentes){
		nom = pnom;
		prenom = pprenom;
		formation = pformation;
		experiences = pexperiences;
		competences = pcompetences;
		attentes = pattentes;
}

	public static void main( String[] args ) {
		System.out.println( "Bienvenue chez Barette! \n" );
		CV cvHogo = new CV("Migner", "Hogo", "Technique Informatique", 0, "Je suis capable de programmer", 
				"Apprendre beaucoup de choses sur le logiciel Git et GitHub.");
		
		cvHogo.affiche();
		
		CV cvPhil = new CV("Lalonde", "Philippe","Technique Informatique", 0, "aucune", 
				"En apprendre sur Git et GitHub.");
		
		cvPhil.affiche();
		
	}
	
	public void affiche() {
		System.out.println( "Mon nom est: " + nom + "\nMon Prénom est: " + prenom + "\nMa formation est: " + formation + "\nMes années d'expériance: " + experiences 
				+ "\nMes compétences: " + competences + "\nMes attentes: " + attentes + "\n" );
	}
	
}
