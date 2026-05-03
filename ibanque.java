package repertoire;

import entite.client;
import entite.compte;
import entite.employer;

public interface ibanque {
	compte scancompte();
	client scanclient();
	employer scanemployer();
	 void gestioncompte();

	 void gestionemployer();
	void printallclient();
	void gestionclient();
	int menuprincipal();

}
