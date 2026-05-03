package entite;

import java.util.HashMap;
import java.util.Map;

public abstract class personne {
	protected String nom;
	protected String prenom;
	protected String email;
	protected String tel;
	protected Map<String,compte> comptes=new HashMap();
	public Map<String, compte> getComptes() {
		return comptes;
	}
	public void setComptes(Map<String, compte> comptes) {
		this.comptes = comptes;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	protected personne(String nom, String prenom, String email, String tel) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.tel = tel;
	}
	@Override
	public String toString() {
		return "personne [nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", tel=" + tel + ",comptes="+comptes+ "]";
	}


}
