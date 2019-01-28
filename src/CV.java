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

		
	}
	
	public void affiche() {
		System.out.println( "Mon nom est: " + nom + "\nMon Prénom est: " + prenom + "\nMa formation est: " + formation + "\nMes années d'expériance: " + experiences 
				+ "\nMes compétences: " + competences + "\nMes attentes: " + attentes + "\n" );
	}
	
}
