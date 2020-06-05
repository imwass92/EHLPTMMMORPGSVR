package programme;

import java.util.Random;

public class PNJ {
	
	 	private int Force;
	    private int Adresse;
	    private int Resistance;
	    private int HP;
	    private String numPNJ;
	    
	    public PNJ (int Force, int Adresse, int Resistance, int HP, String numPNJ) {
	    	
	    	this.Force = Force;
	    	this.Adresse = Adresse;
	    	this.Resistance = Resistance;
	    	this.HP = HP;
	    	this.numPNJ = numPNJ;
	    	
	    }
	    
	    public String etat_PNJ() {
	    	
	    	String etat = "";
	    	
	    	if (this.HP>=50) {
	    	    etat ="Intact";
	    	}
	    	else if (this.HP>40) {
	    	    etat ="Blessures superficielles";
	    	}
	    	else if (this.HP>30) {
	    	    etat ="Légèrement blessé";
	    	}
	    	else if (this.HP>20) {
	    	    etat ="Blessé";
	    	}
	    	else if (this.HP>10) {
	    	    etat ="Gravement blessé";
	    	}
	    	else if (this.HP>0) {
	    	    etat ="Inconscient";
	    	}
	    	else if (this.HP<=0) {
	    	    etat ="Mort";
	    	}
	     	
	    	return etat;
	    	
	    }
	    
	   public void deplacerGauche (Plateau plato) {
		   
		   int pos = plato.chercherInd(this.numPNJ);
		   plato.setCase(this.numPNJ, pos-1);
           plato.plateau[pos]=" ";
	   }
	   public void deplacerDroite (Plateau plato) {
		   
		   int pos = plato.chercherInd(this.numPNJ);
		   plato.setCase(this.numPNJ, pos+1);
           plato.plateau[pos]=" ";
		   
	   }
	   public void deplacerHaut (Plateau plato) {
		   
		   int pos = plato.chercherInd(this.numPNJ);
		   plato.setCase(this.numPNJ, pos-20);
           plato.plateau[pos]=" ";
		   
	   }
	   public void deplacerBas (Plateau plato) {
		   
		   int pos = plato.chercherInd(this.numPNJ);
		   plato.setCase(this.numPNJ, pos+20);
           plato.plateau[pos]=" ";
		   
	   }   
	   public void deplacerHasard (Plateau plato) {
		   
		   boolean deplacementDone = false;
		   int pos = plato.chercherInd(this.numPNJ);
		   Random r = new Random();
		   int h = 499;
		   while(!deplacementDone) {
			   
			   h = r.nextInt(4);
			   
			   if (h==0 && plato.getCase(pos+1)==" ") {
				   deplacementDone = true;
			   }
			   else if (h==1 && plato.getCase(pos-1)==" ") {
				   deplacementDone = true;
			   }
			   else if (h==2 && plato.getCase(pos-20)==" ") {
				   deplacementDone = true;
			   }
			   else if (h==3 && plato.getCase(pos+20)==" ") {
				   deplacementDone = true;
			   }
		   }
		   
		   if (h==0) {
			   deplacerDroite(plato);
		   }
		   else if (h==1) {
			   deplacerGauche(plato);
		   }
		   else if (h==2) {
			   deplacerHaut(plato);
		   }
		   else if (h==3) {
			   deplacerBas(plato);
		   }
	   }
	   
	   public void deplacement (Plateau plato) {
		   
		   int pos = plato.chercherInd(this.numPNJ);
		   
		   boolean isPG = false;
		   int posG = pos;		   
		   int comptG = 0;
		   while (plato.getCase(posG)!="1" && plato.getCase(posG)!="2" && plato.getCase(posG)!="3" && posG>=0 && plato.getCase(posG-1)!="#") {
			   if (plato.getCase(posG-1)=="1" || plato.getCase(posG-1)=="2" || plato.getCase(posG-1)=="3") {
				   isPG = true;
			   }
			   posG--;
			   comptG++;   
		   }
		   
		   boolean isPD = false;
		   int posD = pos;
		   int comptD = 0;
		   while (plato.getCase(posD)!="1" && plato.getCase(posD)!="2" && plato.getCase(posD)!="3" && posD<=399 && plato.getCase(posD+1)!="#") {
			   if (plato.getCase(posD+1)=="1" || plato.getCase(posD+1)=="2" || plato.getCase(posD+1)=="3") {
				   isPD = true;
			   }
			   posD++;
			   comptD++;
		   }
		   
		   boolean isPH = false;
		   int posH = pos;
		   int comptH = 0;
		   while (plato.getCase(posH)!="1" && plato.getCase(posH)!="2" && plato.getCase(posH)!="3" && posH>=0 && plato.getCase(posH-20)!="#") {
			   if (plato.getCase(posH-20)=="1" || plato.getCase(posH-20)=="2" || plato.getCase(posH-20)=="3") {
				   isPH = true;
			   }
			   posH = posH-20;	
			   comptH++;
		   }
		   
		   boolean isPB = false;
		   int posB = pos;
		   int comptB = 0;
		   while (plato.getCase(posB)!="1" && plato.getCase(posB)!="2" && plato.getCase(posB)!="3" && posB<=399 && plato.getCase(posB+20)!="#") {
			   if (plato.getCase(posB+20)=="1" || plato.getCase(posB+20)=="2" || plato.getCase(posB+20)=="3") {
				   isPB = true;
			   }
			   posB = posB+20;	
			   comptB++;
		   }
		   
		   if (comptG<=comptD && comptG<=comptH && comptG<=comptB && comptG>0 && isPG) {
				   deplacerGauche(plato);
		   }
		   else if (comptD<=comptH && comptD<=comptB && comptD>0 && isPD) {
			   deplacerDroite(plato);
		   }
		   else if (comptH<=comptB && comptH>0 && isPH) {
			   deplacerHaut(plato);
		   }
		   else if (comptB>0 && isPB) {
			   deplacerBas(plato);
		   }
		   else {
			   deplacerHasard(plato);
		   }
	   }
	   
	   public int tirage(int carac) {
	    	
	    	int car = carac;   	
	    	int act = 0;
	    	
	    	while (car-3 >= 0) {
	    		Random r = new Random();
	    		int tirage = r.nextInt(6)+1;
	    		act = act + tirage; 
	    		car = car - 3;
	    	}
	    	
	    	if (car>0) {
	    		act = act + car;
	    	}
	    	
	    	return act;
	    	
	    }
	   
	   public void attaquer (Plateau plato, Joueur numero2) {
		   if (tirage(this.Adresse)>(tirage(numero2.getAdresse())-tirage(numero2.getVetement().getEncombrement()))) {
	    		if (tirage(this.Adresse)>(tirage(numero2.getResistance())-tirage(numero2.getVetement().getEncombrement()))) {
	    			numero2.setHP(numero2.getHP()-tirage(this.Force));
	    			plato.affichage();
	    			System.out.println("Le joueur "+numero2.getNumJoueur()+" a été attaqué par un monstre!/nLe joueur "+numero2.getNumJoueur()+" est "+numero2.etat_Joueur());
	    		}   		
	    	}
		    
	   }
	   
	   public boolean isSomeone (Plateau plato) {
		   boolean isqqn = false;
		   int pos = plato.chercherInd(this.numPNJ);
		   
		   if ((plato.getCase(pos-1)!=" " && plato.getCase(pos-1)!="#") || (plato.getCase(pos-20)!=" " && plato.getCase(pos-20)!="#") || (plato.getCase(pos+1)!=" " && plato.getCase(pos+1)!="#") || (plato.getCase(pos+20)!=" " && plato.getCase(pos+20)!="#")) {
			   isqqn = true;
		   }
		   
		   return isqqn;
	   }

	   public int whereIs (Plateau plato) {
		   
		   int posJ = 0;
		   int pos = plato.chercherInd(this.numPNJ);
		   
		   if (plato.getCase(pos-1)!=" " && plato.getCase(pos-1)!="#") {
			   posJ = pos-1;
		   }
		   else if (plato.getCase(pos-20)!=" " && plato.getCase(pos-20)!="#") {
			   posJ = pos-20;
		   }
		   else if (plato.getCase(pos+1)!=" " && plato.getCase(pos+1)!="#") {
			   posJ = pos+1;
		   }
		   else {
			   posJ = posJ+20;
		   }
		   
		   return posJ;
		   
	   }
	   
	   public void autoPNJ (Plateau plato, Joueur [] listeJ) {
		   
		   if (isSomeone(plato)) {
			   int nj=Integer.parseInt(plato.getCase(whereIs(plato)));
			   attaquer(plato, listeJ[nj-1]);
		   }
		   else {
			   deplacement(plato);
		   }
	   }
	  
	   public void mort(Plateau plato) {
	    	
   		plato.setCaseJ(" ", plato.chercherInd(this.numPNJ));
   		
   }
	   
	public int getForce() {
		return Force;
	}

	public int getAdresse() {
		return Adresse;
	}

	public int getResistance() {
		return Resistance;
	}

	public int getHP() {
		return HP;
	}

	public void setHP(int hP) {
		HP = hP;
	}

	public String getNumPNJ() {
		return numPNJ;
	}
	    
}
