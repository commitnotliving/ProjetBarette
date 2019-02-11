
public class Plats {

	public String nom, plat;
	public double prix;


	public Plats() {
		
	}

	public Plats(String pPlat){
			
			plat = pPlat;
			switch ( plat ) {
			case "Poutine":
				prix = 10.5;
				break;
				
			case "Frites":
				prix = 2.5;
				break;
				
			case "Repas_Poulet":
				prix = 15.75;
				break;
			default:
				prix = 0;
				break;
			}

	}
	

}
