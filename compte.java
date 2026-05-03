package entite;

public abstract class compte {
	protected double solde;
	protected String numcompte;
	protected String typecompte;
	abstract void retrait(double montant);
	public void depot(double montant) {
		if(montant<=0) {
			System.out.println("impossible de faire le depot");
			return;
		}
		this.solde=this.solde+montant;
		
	}
	public compte() {
		
	}
	protected compte(double solde, String numcompte, String typecompte) {
		super();
		this.solde = solde;
		this.numcompte = numcompte;
		this.typecompte = typecompte;
	}
	@Override
	public String toString() {
		return "compte [solde=" + solde + ", numcompte=" + numcompte + ", typecompte=" + typecompte + "]";
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public String getNumcompte() {
		return numcompte;
	}
	public void setNumcompte(String numcompte) {
		this.numcompte = numcompte;
	}
	public String getTypecompte() {
		return typecompte;
	}
	public void setTypecompte(String typecompte) {
		this.typecompte = typecompte;
	}
	

}
