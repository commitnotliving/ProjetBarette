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
		System.out.println( "Mon nom est: " + nom + "\nMon Pr�nom est: " + prenom + "\nMa formation est: " + formation + "\nMes ann�es d'exp�riance: " + experiences 
				+ "\nMes comp�tences: " + competences + "\nMes attentes: " + attentes + "\n" );
	}
	
}
