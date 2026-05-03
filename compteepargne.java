package entite;

public class compteepargne extends compte{
	void retrait (double montant) {
		if(montant>solde) {
			System.out.println("solde insuffisant");
			return;
		}
		solde=solde-montant;
	}
	

}
