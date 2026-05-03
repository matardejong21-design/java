package entite;

public class comptecourant extends compte {
	private double taxe=0.01;
	void retrait (double montant) {
		if((montant+montant*taxe)>solde) {
			System.out.println("solde insuffisant");
			return;
		}
		solde=solde-(montant+solde*taxe);
	}

}
