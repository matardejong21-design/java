package repertoire;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import entite.client;
import entite.compte;
import entite.comptecourant;
import entite.compteepargne;
import entite.employer;

public  class  banqueimpliste implements ibanque {
	 Map<String,compte> comptes = new HashMap<>();
	    Map<String,client> clients = new HashMap<>();
	    Map<String,employer> employes = new HashMap<>();
	Scanner clavier =new Scanner(System.in);
	public compte scancompte() {
	
		        System.out.println("Entrer le numero du compte : ");
		        String numc =clavier.nextLine();
		        System.out.println("Entrer le solde du compte : ");
		        double solde =clavier.nextDouble();
		        clavier.nextLine();
		        System.out.println("Entrer le type du compte : ");
		        String type = clavier.nextLine();
		        compte c  ;
		        if(type.equalsIgnoreCase("epargne")){
		            c = new compteepargne();
		        }else
		        {
		            c = new comptecourant();
		        }
		        c.setNumcompte(numc);
		        c.setSolde(solde);
		        c.setTypecompte(type);
		        return c;
		
	}
	  public int menuprincipal() {
	        int choix;
	        do {
	            System.out.println("1.Gerer les clients");
	            System.out.println("2.Gerer les comptes");
	            System.out.println("3.Gerer les employes");
	            System.out.println("4.Quitter");
	            System.out.println("Entrer le choix : ");
	            choix = clavier.nextInt();
	        }while (choix<1 || choix >4);
	        return choix;
	    }
	  
	  public void gestioncompte() {
	        int choix;
	        do {
	            do {
	                System.out.println("1.Ajouter un compte");
	                System.out.println("2.Afficher les comptes");
	                System.out.println("3.Modifier un compte");
	                System.out.println("4.Supprimer un compte");
	                System.out.println("5.Quitter");
	                System.out.println("Entrer le choix : ");
	                choix = clavier.nextInt();
	            }while (choix<1 || choix >5);

	            switch (choix)
	            {
	                case 1:
	                    System.out.println("Ajout compte");
	                    clavier.nextLine();
	                    System.out.println("veuiller entrer votre mail");
	                    String email=clavier.nextLine();
	                    clavier.nextLine();
	                    if(clients.containsKey(email))
	                    {
	                    	System.out.println("voici la liste de vos comptes");
	                    	client cl =clients.get(email);
	                    	cl.getComptes().values().forEach(System.out::println );
	                    	compte co =scancompte();
		                    comptes.put(co.getNumcompte(),co);

	                    }else
	                    {
	                    	  System.out.println("bienvenue vous etes nouveaux");
	  	                    client c = scanclient();
	  	                    compte cpt = scancompte();
	  	                    Map<String,compte> comptesclient = c.getComptes();
	  	                    comptesclient.put(cpt.getNumcompte(),cpt);
	  	                    c.setComptes(comptesclient);
	  	                    clients.put(c.getEmail(),c);
	  	                    comptes.put(cpt.getNumcompte(),cpt);
	                    }
	                    
	                    
	                    break;
	                case 2:
	               
	                    System.out.println("Afiicher les comptes");
	                    System.out.println("les comptes sont ");
	                    comptes.values().forEach(System.out::println);
	                    
	                    break;
	                case 3:
	                	clavier.nextLine();
	                    System.out.println("modifier compte");
	                    comptes.values().forEach(System.out::println);
	                    System.out.println("saisir l'adresse mail du client dont vous voulez modifier son compte modifier");
	                    String emailcli=clavier.nextLine();
	                	clavier.nextLine();
	                    if(clients.containsKey(emailcli)) {
	                    	client cl=clients.get(emailcli);
	                    	System.out.println("ses comptes sont");
	                    	cl.getComptes().values().forEach(System.out::println);
	                    	System.out.println("saisir le numero du compte");
	                    	String numc=clavier.nextLine();
	                    	clavier.nextLine();
	                    	if(comptes.containsKey(numc)) {
	                    		compte co=comptes.get(numc);
	                    	 	System.out.println("entrer le nouveau type");
		                    	String type=clavier.nextLine();
		                    	co.setTypecompte(type);
		                    	System.out.println("entrer le nouveau numero");
		                    	String modep=clavier.nextLine();
		                    	co.setNumcompte(numc);
		                    	System.out.println("entrer le nouveau sole");
		                    	double sole=clavier.nextDouble();
		                    	co.setSolde(choix);
		                    	System.out.println("compte modifié avec succés");
	                    		
	                    	}
	                   
	                    }


	                    
	                    break;
	                case 4:
	                    System.out.println("supprimer compte");
	                    System.out.println("voici la liste des comptes");
	                    comptes.values().forEach(System.out::println);
	                    System.out.println("saisir le numero du compte a supprimer");
	                    String numco=clavier.nextLine();
	                   
	                    if(comptes.containsKey(numco)){
	                    	compte co=comptes.get(numco);
	                    	comptes.remove(numco);
	                    }
	                    
	                    break;
	            }
	        }while (choix !=5);

	    }
	  
	  
	  
	  
	  public void gestionclient() {
	        int choix;
	        do {
	            do {
	                System.out.println("1.Ajouter un client");
	                System.out.println("2.Afficher les clients");
	                System.out.println("3.Supprimer un client");
	                System.out.println("4.Modifier un client");

	                System.out.println("5.Quitter");
	                System.out.println("Entrer le choix : ");
	                choix = clavier.nextInt();
	            }while (choix<1 || choix >5);
	            clavier.nextLine();

	            switch (choix)
	            {
	                case 1:
	                    System.out.println("Ajout client");
	                    clavier.nextLine();
	                    client c = scanclient();
	                    compte cpt = scancompte();
	                    Map<String,compte> comptesclient = c.getComptes();
	                    comptesclient.put(cpt.getNumcompte(),cpt);
	                    c.setComptes(comptesclient);
	                    clients.put(c.getEmail(),c);
	                    comptes.put(cpt.getNumcompte(),cpt);
	                    break;
	                case 2:
	                    System.out.println("Afficher les clients");
	                    clients.values().forEach(System.out::println);
	                    break;
	                case 3:
	                    System.out.println("supprimer client");
	                    System.out.println("voici la liste des clients");
	                    clients.values().forEach(System.out::println);
	                    System.out.println("saisir l'adresse mail du client a supprimer");
	                    String emailcli=clavier.nextLine();
	                   
	                    if(clients.containsKey(emailcli)){
	                    	client cl=clients.get(emailcli);
	                    	cl.getComptes().values().forEach( e-> comptes.remove(e.getNumcompte()));
	                    	clients.remove(emailcli);
	                    }
	                    
	                    break;
	                case 4:
	                    System.out.println("modifier client");
	                    clients.values().forEach(System.out::println);
	                    System.out.println("saisir l'adresse mail du client a modifier");
	                    String emailcliupd=clavier.nextLine();
	                    if(clients.containsKey(emailcliupd)) {
	                    	client cl=clients.get(emailcliupd);
	                    	System.out.println("entrer le nouveau nom");
	                    	String nom=clavier.nextLine();
	                    	cl.setNom(nom);
	                    	System.out.println("entrer le nouveau prenom");
	                    	String prenom=clavier.nextLine();
	                    	cl.setNom(prenom);
	                    }

	                    break;
	            }
	        }while (choix !=5);

	    }

	  public void gestionemployer() {
	        int choix;
	        do {
	            do {
	                System.out.println("1.Ajouter un employe");
	                System.out.println("2.Afficher les employes");
	                System.out.println("3.Modifier un employe");
	                System.out.println("4.Supprimer un employer");
	                System.out.println("5.Quitter");
	                System.out.println("Entrer le choix : ");
	                choix = clavier.nextInt();
	            }while (choix<1 || choix >5);
	        	clavier.nextLine();

	            switch (choix)
	            {
	                case 1:
	                    System.out.println("Ajout employer");
	                	clavier.nextLine();
	                    employer e=scanemployer();
	                    employes.put(e.getEmail(), e);
	                  
	                    break;
	                case 2:
	                    System.out.println("Afiicher les employes");
	                    employes.values().forEach(System.out::println);
	                    
	                    break;
	                case 3:
	                	clavier.nextLine();
	                	 System.out.println(" les employes sont");
	                    System.out.println("modifier employer");
	                    employes.values().forEach(System.out::println);
	                    System.out.println("veuiller donner l'email de l'employer");
	                    String emaile=clavier.nextLine();
	                    if(employes.containsKey(emaile)) {
	                    	employer emp =employes.get(emaile);
	                    	clavier.nextLine();
	                  	  System.out.println("Veuillez saisir le nouveau nom de l'employer : ");
	          	        String nom = clavier.nextLine();
	          	        System.out.println("Veuillez saisir le nouveau prenom de l'employer: ");
	          	        String prenom = clavier.nextLine();
	          	        System.out.println("Veuillez saisir le nouvel email du l'employer : ");
	          	        String email = clavier.nextLine();
	          	        System.out.println("Veuillez saisir le nouveau telephone de l'employer : ");
	          	      System.out.println("Veuillez saisir le salaire de l'employer: ");
	          	        double sal = clavier.nextDouble();
	          	        String tel = clavier.nextLine();
	          	        emp.setNom(nom);
	          	        emp.setPrenom(prenom);
	          	        emp.setSalaire(sal);
	          	        emp.setTel(tel);
	          	        
	          	       
	                    	
	                    }
	                    break;
	                case 4:
	                    System.out.println("supprimer employer");
	                    System.out.println("voici la liste des employers");
	                    employes.values().forEach(System.out::println);
	                    System.out.println("saisir l'adresse mail de l'employer a supprimer");
	                    String emailcli=clavier.nextLine();
	                   
	                    if(employes.containsKey(emailcli)){
	                    	employer em=employes.get(emailcli);
	                    	employes.remove(emailcli);
	                    	
	                    }
	                    
	                    break;
	            }
	        }while (choix !=5);

	    }

	    @Override
	    
	    public client scanclient() {
	    	clavier.nextLine();
	        System.out.println("Veuillez saisir le nom du client : ");
	        String nom = clavier.nextLine();
	    	clavier.nextLine();
	        System.out.println("Veuillez saisir le prenom du client : ");
	        String prenom = clavier.nextLine();
	        System.out.println("Veuillez saisir l'email du client : ");
	        String email = clavier.nextLine();
	        System.out.println("Veuillez saisir le telephone du client : ");
	        String tel = clavier.nextLine();
	        System.out.println("Veuillez saisir l'adresse du client : ");
	        String adresse = clavier.nextLine();
	        System.out.println("Veuillez saisir le mode de paiement du client : ");
	        String mdp = clavier.nextLine();
	        client c = new client(nom,prenom,email,tel,adresse,mdp);
	        return c; 
	    }

	  
	  
			
	
	@Override
	public employer scanemployer() {
		  System.out.println("Veuillez saisir le nom de l'employer : ");
	        String nom = clavier.nextLine();
	        System.out.println("Veuillez saisir le prenom de l'employer: ");
	        String prenom = clavier.nextLine();
	        System.out.println("Veuillez saisir l'email du l'email : ");
	        String email = clavier.nextLine();
	        System.out.println("Veuillez saisir le telephone du client : ");
	        String tel = clavier.nextLine();
	        
	        System.out.println("Veuillez saisir le salaire de l'employer: ");
	        double sal = clavier.nextDouble();
	        employer e = new employer(nom,prenom,email,tel,sal);
	        return e;
	}
	@Override
	public void printallclient() {
		// TODO Auto-generated method stub
		
	}
	
		
	
	 

}
