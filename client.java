package entite;

public class client extends personne{
	private String adresse;
	private String modepaiement;
	public client(String nom, String prenom, String email, String tel,String adresse,String modepaiment) {
		super(nom, prenom, email, tel);
		this.adresse=adresse;
		this.modepaiement=modepaiement;
		
	}
	@Override
	public String toString() {
		return "client [adresse=" + adresse + ", modepaiement=" + modepaiement +" ]"+super.toString();
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getModepaiement() {
		return modepaiement;
	}
	public void setModepaiement(String modepaiement) {
		this.modepaiement = modepaiement;
	}
	

}
