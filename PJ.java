package programme;

import java.util.Scanner;
import java.util.*;
import java.util.Random;

public class PJ {

    private int Force;
    private int Adresse;
    private int Resistance;
    private int HP;
    private String Type;
    private int XP;
    private int PA;
    private weapon weapon;
    private armure armure;
    private  String numPJ;
    private ArrayList<Potion> listePotion;
    
    public PJ (int Force,int Adresse, int Resistance, int HP,int XP, int PA, String Type, weapon weapon, armure armure, String numPJ, ArrayList<Potion> listePotion) {
    	
    	this.Force = Force;
    	this.Adresse = Adresse;
    	this.Resistance = Resistance;
    	this.HP = HP;
    	this.Type = Type;
    	this.XP = XP;
    	this.PA = PA;
    	this.weapon = weapon;
    	this.armure = armure;
    	this.numPJ = numPJ;
    	this.listePotion = listePotion;
    	
    }    
    
    public void init_type_PJ(Scanner sc) {
    	
        int c = 0;
        while (c != 1 && c != 2) {
            System.out.println("PJ "+this.numPJ+" quel type de combattant voulez vous ? - Taper 1 pour Archer, Taper 2 pour Guerrier -");
            c = sc.nextInt();
            System.out.println(c);
        }
        if (c == 1) {
            this.Type = "Archer";
        }
        else {
            this.Type = "Guerrier";
        } 
        
    }
    
    public void initPA () {
    	
    	this.PA = this.PA + 15;
    	System.out.println("Il vous reste "+this.PA+" points d'action.");
    	
    }
    
    public void upXP(Scanner sc) {
    	
    	if (this.XP == 100) {
    		String car = "";
    		int num = 0;
    		int p = 0;
    		int pts =3;
    		while (pts>0 && p<2) {    	
    			
    			if (p == 0) {
            		car = "Force";
            	}           	
            	else if (p == 1) {
            		car = "Adresse";	
            	}            	          
            		
            	System.out.print("Combien de points de " + car + " voulez-vous ? ");
                num = sc.nextInt();
                pts = pts - num;
            	                                                
                if (p == 0) {
                	this.Force = Force + num;
                }                
                else if (p == 1) { 
                	this.Adresse = Adresse + num;
                }
                                
                p = p + 1;
                        
                System.out.println("Il vous reste " + pts +" Points");
    		}   
    		
    		 this.Resistance = Resistance + pts;
    	     this.XP = 0;
    	     
    	}   
    	
    }

    public void createPJ(Scanner sc) {
    	
    	int number = 0;
        int points = 18;
        int var = 0;
        
        String caracteristique = "";
        while (points > 0 && var < 2) {        	
        	  
        	if (var == 0) {
        		caracteristique = "Force";
        	}        	
        	else if (var == 1) {
        		caracteristique = "Adresse";	
        	}
        	     
        	    	
        	System.out.print("Combien de points de " + caracteristique + " voulez-vous ? ");
            number = sc.nextInt();
            
            points -= number;
        	
            if (var == 0) {
            	this.Force = Force + number;
            }            
            else if (var == 1) {
            	this.Adresse = Adresse + number;
            }
                        
            var = var + 1;
               
            System.out.println("Il vous reste " + points +" Points");
        }        
        
        this.Resistance = Resistance + points;
        
    }
    
    public String etat_PJ() {
    	
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
		
	public void attaquerGuerrier (Scanner sc, PJ [] liste, map plato, PNJ [] lmonstres) {		
		
		int nj = 0;		
		int sens = 0;
        
        while (sens != 1 && sens != 2 && sens != 3 && sens !=5) {
        	
            System.out.println("Où voulez-vous attaquer ? -5 Haut, 1 Gauche, 2 Bas, 3 Droite-");
            sens = sc.nextInt();
            
        }
		
		if (sens==5) {
			
			if (plato.getCase(plato.chercherInd(this.numPJ)-20) != " " && plato.getCase(plato.chercherInd(this.numPJ)-20) != "#") {
				if (Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-20))<=3) {
					nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-20))-1;
					this.attaquer(liste[nj], plato);
				}
				else {
					nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-20))-1;
					this.attaquerPNJ(lmonstres[nj], plato);
				}
				
			}
			
			else {
				System.out.println("Il n'y a personne ici !");
			}
			
		}
		
		else if (sens==3) {
			
			if (plato.getCase(plato.chercherInd(this.numPJ)+1) != " " && plato.getCase(plato.chercherInd(this.numPJ)+1) != "#" ){
				
				if (Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+1))<=3) {
					nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+1))-1;
					this.attaquer(liste[nj], plato);
				}
				else {
					nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+1))-1;
					this.attaquerPNJ(lmonstres[nj], plato);
				}
				
			}
			
			else {
				System.out.println("Il n'y a personne ici !");
			}
			
		}
		else if (sens==2) {
			
			if (plato.getCase(plato.chercherInd(this.numPJ)+20) != " " && plato.getCase(plato.chercherInd(this.numPJ)+20) != "#" ){
				
				if (Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+20))<=3) {
					nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+20))-1;
					this.attaquer(liste[nj], plato);
				}
				else {
					nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+20))-1;
					this.attaquerPNJ(lmonstres[nj], plato);
				}
				
			}
			
			else {
				System.out.println("Il n'y a personne ici !");
			}
			
		}
			
		else {
			
			if (plato.getCase(plato.chercherInd(this.numPJ)-1) != " " && plato.getCase(plato.chercherInd(this.numPJ)-1) != "#" ){
				
				if (Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-1))<=3) {
					nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-1))-1;
					this.attaquer(liste[nj], plato);
				}
				else {
					nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-1))-1;
					this.attaquerPNJ(lmonstres[nj], plato);
				}
				
			}
			
			else {
				System.out.println("Il n'y a personne ici !");
			}
			
		}
		
	}

	public void attaquerArcher (Scanner sc, PJ [] liste, map plato, PNJ [] lmonstres) {
		
		int nj = 0;		
		int sens = 0;
        
        while (sens != 1 && sens != 2 && sens != 3 && sens !=5) {
        	
            System.out.println("Dans quel sens souhaitez-vous attaquer ? -5 Haut, 1 Gauche, 2 Bas, 3 Droite-");
            sens = sc.nextInt();
            
        }
        
        
        int Case = 0;
        
        while (Case != 1 && Case != 2 && Case != 3) {
        	
            System.out.println("A quel distance souhaitez-vous attaquer ? -1 case, 2 cases, 3 cases-");
            Case = sc.nextInt();
            
        }
		
		if (sens==5) {
			
			if (Case==1) {
			
				if (plato.getCase(plato.chercherInd(this.numPJ)-20) != " " && plato.getCase(plato.chercherInd(this.numPJ)-20) != "#" ) {
				
					if (Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-20))<=3) {
						nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-20))-1;
						this.attaquer(liste[nj], plato);
					}
					else {
						nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-20))-1;
						this.attaquerPNJ(lmonstres[nj], plato);
					}
				
				}
			
				else {
					System.out.println("Il n'y a personne ici !");
				}
			}
			
			else if (Case==2 && plato.chercherInd(this.numPJ)-40>=0 && plato.getCase(plato.chercherInd(this.numPJ)-20)!="#") {
				
				if (plato.getCase(plato.chercherInd(this.numPJ)-40) != " " && plato.getCase(plato.chercherInd(this.numPJ)-40) != "#" ){
				
					if (Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-40))<=3) {
						nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-40))-1;
						this.attaquer(liste[nj], plato);
					}
					else {
						nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-40))-1;
						this.attaquerPNJ(lmonstres[nj], plato);
					}
				
				}
			
				else {
					System.out.println("Il n'y a personne ici !");
				}
			}
			
			else if (Case==3 && plato.chercherInd(this.numPJ)-60>=0 && plato.getCase(plato.chercherInd(this.numPJ)-20)!="#" && plato.getCase(plato.chercherInd(this.numPJ)-40)!="#") {
				
				if (plato.getCase(plato.chercherInd(this.numPJ)-60) != " " && plato.getCase(plato.chercherInd(this.numPJ)-60) != "#" ){
				
					if (Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-60))<=3) {
						nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-60))-1;
						this.attaquer(liste[nj], plato);
					}
					else {
						nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-60))-1;
						this.attaquerPNJ(lmonstres[nj], plato);
					}
				
				}
			
				else {
					System.out.println("Il n'y a personne ici !");
				}
				
			}
			
		}
		
		else if (sens==3) {
			
			if (Case==1) {
				
				if (plato.getCase(plato.chercherInd(this.numPJ)+1) != " " && plato.getCase(plato.chercherInd(this.numPJ)+1) != "#" ){
				
					if (Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+1))<=3) {
						nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+1))-1;
						this.attaquer(liste[nj], plato);
					}
					else {
						nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+1))-1;
						this.attaquerPNJ(lmonstres[nj], plato);
					}
				
				}
			
				else {
					System.out.println("Il n'y a personne ici !");
				}
			}
			
			else if (Case==2 && plato.chercherInd(this.numPJ)+2>=0 && plato.getCase(plato.chercherInd(this.numPJ)+1)!="#") {
				
				if (plato.getCase(plato.chercherInd(this.numPJ)+2) != " " && plato.getCase(plato.chercherInd(this.numPJ)+2) != "#" ){
				
					if (Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+2))<=3) {
						nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+2))-1;
						this.attaquer(liste[nj], plato);
					}
					else {
						nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+2))-1;
						this.attaquerPNJ(lmonstres[nj], plato);
					}
				
				}
			
				else {
					System.out.println("Il n'y a personne ici !");
				}
				
			}
			
			else if (Case==3 && plato.chercherInd(this.numPJ)+3>=0 && plato.getCase(plato.chercherInd(this.numPJ)+1)!="#" && plato.getCase(plato.chercherInd(this.numPJ)+2)!="#") {
				
				if (plato.getCase(plato.chercherInd(this.numPJ)+3) != " " && plato.getCase(plato.chercherInd(this.numPJ)+3) != "#" ){
				
					if (Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+3))<=3) {
						nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+3))-1;
						this.attaquer(liste[nj], plato);
					}
					else {
						nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+3))-1;
						this.attaquerPNJ(lmonstres[nj], plato);
					}
				
				}
			
				else {
					System.out.println("Il n'y a personne ici !");
				}
				
			}	
			
		}
		
		else if (sens==2) {
			
			if (Case==1) {
				
				if (plato.getCase(plato.chercherInd(this.numPJ)+20) != " " && plato.getCase(plato.chercherInd(this.numPJ)+20) != "#" ){
				
					if (Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+20))<=3) {
						nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+20))-1;
						this.attaquer(liste[nj], plato);
					}
					else {
						nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+20))-1;
						this.attaquerPNJ(lmonstres[nj], plato);
					}
				
				}
			
				else {
					System.out.println("Il n'y a personne ici !");
				}
			}
			
			else if (Case==2 && plato.chercherInd(this.numPJ)+40>=0 && plato.getCase(plato.chercherInd(this.numPJ)+20)!="#") {
				
				if (plato.getCase(plato.chercherInd(this.numPJ)+40) != " " && plato.getCase(plato.chercherInd(this.numPJ)+40) != "#" ){
				
					if (Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+40))<=3) {
						nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+40))-1;
						this.attaquer(liste[nj], plato);
					}
					else {
						nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+40))-1;
						this.attaquerPNJ(lmonstres[nj], plato);
					}
				
				}
			
				else {
					System.out.println("Il n'y a personne ici !");
				}
				
			}
			
			else if (Case==3 && plato.chercherInd(this.numPJ)+60>=0 && plato.getCase(plato.chercherInd(this.numPJ)+20)!="#" && plato.getCase(plato.chercherInd(this.numPJ)+40)!="#") {
				
				if (plato.getCase(plato.chercherInd(this.numPJ)+60) != " " && plato.getCase(plato.chercherInd(this.numPJ)+60) != "#" ){
				
					if (Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+60))<=3) {
						nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+60))-1;
						this.attaquer(liste[nj], plato);
					}
					else {
						nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+60))-1;
						this.attaquerPNJ(lmonstres[nj], plato);
					}
				
				}
			
				else {
					System.out.println("Il n'y a personne ici !");
				}
				
			}
			
		}
			
		else {
			
			if (Case==1) {
				
				if (plato.getCase(plato.chercherInd(this.numPJ)-1) != " " && plato.getCase(plato.chercherInd(this.numPJ)-1) != "#" ){
				
					if (Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-1))<=3) {
						nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-1))-1;
						this.attaquer(liste[nj], plato);
					}
					else {
						nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-1))-1;
						this.attaquerPNJ(lmonstres[nj], plato);
					}
				
				}
			
				else {
					System.out.println("Il n'y a personne ici !");
				}
				
			}
			
			else if (Case==2 && plato.chercherInd(this.numPJ)-2>=0 && plato.getCase(plato.chercherInd(this.numPJ)-1)!="#") {
				
				if (plato.getCase(plato.chercherInd(this.numPJ)-2) != " " && plato.getCase(plato.chercherInd(this.numPJ)-2) != "#" ){
				
					if (Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-2))<=3) {
						nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-2))-1;
						this.attaquer(liste[nj], plato);
					}
					else {
						nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-2))-1;
						this.attaquerPNJ(lmonstres[nj], plato);
					}
				
				}
			
				else {
					System.out.println("Il n'y a personne ici !");
				}
				
			}
			
			else if (Case==3 && plato.chercherInd(this.numPJ)-3>=0 && plato.getCase(plato.chercherInd(this.numPJ)-1)!="#" && plato.getCase(plato.chercherInd(this.numPJ)-2)!="#") {
				
				if (plato.getCase(plato.chercherInd(this.numPJ)-3) != " " && plato.getCase(plato.chercherInd(this.numPJ)-3) != "#" ){
				
					if (Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-3))<=3) {
						nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-3))-1;
						this.attaquer(liste[nj], plato);
					}
					else {
						nj=Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-3))-1;
						this.attaquerPNJ(lmonstres[nj], plato);
					}
				
				}
			
				else {
					System.out.println("Il n'y a personne ici !");
				}
			}
		}
		
	}
    
    public void attaquer (PJ numero2, map plato) {
    	
    	if ((tirage(this.Adresse)+tirage(this.weapon.getManiabilite()))>(tirage(numero2.Adresse)-tirage(numero2.armure.getEncombrement()))) {
    		if ((tirage(this.Adresse)+tirage(this.weapon.getManiabilite()))>(tirage(numero2.Resistance)-tirage(numero2.armure.getEncombrement()))) {
    			numero2.HP = numero2.HP - (tirage(this.Force)+tirage(this.weapon.getImpact()));
    		}   		
    	} 
    	
    	this.PA = this.PA - 3;
    	System.out.println("L'etat du PJ attaqué est  "+numero2.etat_PJ()+".\nIl vous reste "+this.PA+" points d'action.");
    	
    	if (numero2.etat_PJ() == "Mort") {
    		int caseMort = plato.chercherInd(numero2.numPJ);
    		numero2.mort(plato);
    		plato.affichage();
    		this.weapon.upXPweapon();
    		this.weapon.evoweapon();
    		this.armure.upXParmure();
    		this.armure.evoarmure();
    		System.out.println("Votre weapon est désormais de niveau "+this.weapon.getNiveauweapon()+".\nElle possède "+this.weapon.getManiabilite()+" en maniabilité et "+this.weapon.getImpact()+" en impact.");
    		System.out.println("Votre armure est désormais de niveau "+this.armure.getNiveauarmure()+".\nIl possède "+this.armure.getEncombrement()+" en encombrement et "+this.armure.getSolidite()+" en solidité.");
    		
    		Random r = new Random();
    		int chance = r.nextInt(100)+1;
    		if (chance>90) {
    			plato.setCaseJ("e", caseMort);
    			plato.affichage();
    		}
    		else if (chance<=90 && chance>80) {
    			plato.setCaseJ("s", caseMort);
    			plato.affichage();
    		}
    	}
    	
    }
    
    public void attaquerPNJ (PNJ pnj, map plato) {
    	if ((tirage(this.Adresse)+tirage(this.weapon.getManiabilite()))>(tirage(pnj.getAdresse()))) {
    		if ((tirage(this.Adresse)+tirage(this.weapon.getManiabilite()))>tirage(pnj.getResistance())) {
    			pnj.setHP(pnj.getHP() - (tirage(this.Force)+tirage(this.weapon.getImpact())));
    		}   		
    	} 
    	
    	this.PA = this.PA - 3;
    	System.out.println("L'etat du monstre attaqué est  "+pnj.etat_PNJ()+".\nIl vous reste "+this.PA+" points d'action.");
    	
    	if (pnj.etat_PNJ() == "Mort") {
    		int caseMort = plato.chercherInd(pnj.getNumPNJ());
    		pnj.mort(plato);
    		plato.affichage();
    		this.weapon.upXPweapon();
    		this.weapon.evoweapon();
    		this.armure.upXParmure();
    		this.armure.evoarmure();
    		System.out.println("Votre weapon est désormais de niveau "+this.weapon.getNiveauweapon()+".\nElle possède "+this.weapon.getManiabilite()+" en maniabilité et "+this.weapon.getImpact()+" en impact.");
    		System.out.println("Votre armure est désormais de niveau "+this.armure.getNiveauarmure()+".\nIl possède "+this.armure.getEncombrement()+" en encombrement et "+this.armure.getSolidite()+" en solidité.");
    		
    		Random r = new Random();
    		int chance = r.nextInt(100)+1;
    		if (chance>90) {
    			plato.setCaseJ("e", caseMort);
    			plato.affichage();
    		}
    		else if (chance<=90 && chance>80) {
    			plato.setCaseJ("s", caseMort);
    			plato.affichage();
    		}
    	}
    }
    
    public void seDeplacer(map plato, Scanner sc) {

        int indice = plato.chercherInd(this.numPJ);
        int choix = 0;
        
        while (choix != 1 && choix != 2 && choix != 3 && choix !=5) {
            System.out.println("Où voulez-vous vous déplacez ? -5 Haut, 1 Gauche, 2 Bas, 3 Droite-");
            choix = sc.nextInt();
        }
        
        if (choix == 1) {
            if (!plato.caseEmpty(indice-1)) {
                System.out.println("Vous ne pouvez pas aller à gauche.");
            }
            else {
                plato.setCase(this.numPJ, indice-1);
                plato.map[indice]=" ";
            }

        }        
        else if (choix == 2) {
            if (!plato.caseEmpty(indice+20)) {
                System.out.println("Vous ne pouvez pas aller en bas.");
            }
            else {
                plato.setCase(this.numPJ, indice+20);
                plato.map[indice]=" ";
            }
        }       
        else if (choix == 3) {
            if (!plato.caseEmpty(indice+1)) {
                System.out.println("Vous ne pouvez pas aller à droite.");
            }
            else {
                plato.setCase(this.numPJ, indice+1);
                plato.map[indice]=" ";
            }
        }
        else {
        	
            if (!plato.caseEmpty(indice-20)) {
                System.out.println("Vous ne pouvez pas aller en haut.");
            }
            else {
                plato.setCase(this.numPJ, indice-20);
                plato.map[indice]=" ";
            }
        }
        
        this.PA = this.PA - 2;

    }
    
    public void mort(map plato) {
    	
    		plato.setCaseJ(" ", plato.chercherInd(this.numPJ));
    		
    }
    public void useSoinPotion(Potion potion) {
		if (potion.isSoin()) {
			if (this.HP == 50) {
				System.out.println("Votre santé est déjà au maximum");
			}
			else {
				this.HP = this.HP+30;
				if (this.HP > 50) {
					this.HP=50;
				}
			System.out.println("Vous avez utilisé une potion de soin, vous êtes maintenant "+this.etat_PJ());
				this.PA = this.PA - 6;
			}
		}
	}
	
	public int choixDirection(Scanner sc) {
		int choixD = 0;
		while (choixD != 1 && choixD != 2 && choixD != 3 && choixD !=5) {
			System.out.println("Dans quel direction souhaitez-vous jetez votre potion d'explosion ? -5 Haut, 1 Gauche, 2 Bas, 3 Droite-");
			choixD = sc.nextInt();
		}
		return choixD;
	}
	
	public int choixNbCase(Scanner sc) {
		int choixNC = 0;
		while (choixNC != 1 && choixNC != 2 && choixNC != 3) {
			System.out.println("A quelle distance souhaitez-vous jetez votre potion d'explosion ? -1 case, 2 cases, 3 cases-");
			choixNC = sc.nextInt();
		}
		return choixNC;
	}
	
	public void useExplosionPotion(Potion potion, map plato, Scanner sc, PJ [] listePJ) {
		if (potion.isExplosion()) {
			int choixD = choixDirection(sc);
			int choixC = choixNbCase(sc);
			if (choixD==1) {
				if (choixC==1) {
					if (plato.getCase(plato.chercherInd(this.numPJ)-1) != " " && plato.getCase(plato.chercherInd(this.numPJ)-1) != "#") {
						listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-1))].setHP(listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-1))].getHP()-15);
						System.out.println("Touché ! Le PJ attaqué est "+listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-1))].etat_PJ());
					}
					else {
						System.out.println("Il n'y a personne ici ! Quel gâchis !");
					}
				}
				else if (choixC==2 && plato.getCase(plato.chercherInd(this.numPJ)-1) != "#" ) {
					if (plato.getCase(plato.chercherInd(this.numPJ)-2) != " " && plato.getCase(plato.chercherInd(this.numPJ)-2) != "#") {
						listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-2))].setHP(listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-2))].getHP()-15);
						System.out.println("Touché ! Le PJ attaqué est "+listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-2))].etat_PJ());
					}
					else {
						System.out.println("Il n'y a personne ici ! Quel gâchis !");
					}
				}
				else if (choixC==3 && plato.getCase(plato.chercherInd(this.numPJ)-1)!="#" && plato.getCase(plato.chercherInd(this.numPJ)-2)!="#") {
					if (plato.getCase(plato.chercherInd(this.numPJ)-3) != " " && plato.getCase(plato.chercherInd(this.numPJ)-3) != "#") {
						listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-3))].setHP(listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-3))].getHP()-15);
						System.out.println("Touché ! Le PJ attaqué est "+listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-3))].etat_PJ());
					}
					else {
						System.out.println("Il n'y a personne ici ! Quel gâchis !");
					}
				}
			}
			else if (choixD==2) {
				if (choixC==1) {
					if (plato.getCase(plato.chercherInd(this.numPJ)+20) != " " && plato.getCase(plato.chercherInd(this.numPJ)+20) != "#") {
						listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+20))].setHP(listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+20))].getHP()-15);
						System.out.println("Touché ! Le PJ attaqué est "+listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+20))].etat_PJ());
					}
					else {
						System.out.println("Il n'y a personne ici ! Quel gâchis !");
					}
				}
				else if (choixC==2 && plato.getCase(plato.chercherInd(this.numPJ)+20) != "#" ) {
					if (plato.getCase(plato.chercherInd(this.numPJ)+40) != " " && plato.getCase(plato.chercherInd(this.numPJ)+40) != "#") {
						listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+40))].setHP(listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+40))].getHP()-15);
						System.out.println("Touché ! Le PJ attaqué est "+listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+40))].etat_PJ());
					}
					else {
						System.out.println("Il n'y a personne ici ! Quel gâchis !");
					}
				}
				else if (choixC==3 && plato.getCase(plato.chercherInd(this.numPJ)+20)!="#" && plato.getCase(plato.chercherInd(this.numPJ)+40)!="#") {
					if (plato.getCase(plato.chercherInd(this.numPJ)+60) != " " && plato.getCase(plato.chercherInd(this.numPJ))+60 != "#") {
						listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+60))].setHP(listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+60))].getHP()-15);
						System.out.println("Touché ! Le PJ attaqué est "+listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+60))].etat_PJ());
					}
					else {
						System.out.println("Il n'y a personne ici ! Quel gâchis !");
					}
					}
				}
			else if(choixD==3) {
				if (choixC==1) {
					if (plato.getCase(plato.chercherInd(this.numPJ)+1) != " " && plato.getCase(plato.chercherInd(this.numPJ)+1) != "#") {
						listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+1))].setHP(listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+1))].getHP()-15);
						System.out.println("Touché ! Le PJ attaqué est "+listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+1))].etat_PJ());
					}
					else {
						System.out.println("Il n'y a personne ici ! Quel gâchis !");
					}
				}
				else if (choixC==2 && plato.getCase(plato.chercherInd(this.numPJ)+1) != "#" ) {
					if (plato.getCase(plato.chercherInd(this.numPJ)+2) != " " && plato.getCase(plato.chercherInd(this.numPJ)+2) != "#") {
						listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+2))].setHP(listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+2))].getHP()-15);
						System.out.println("Touché ! Le PJ attaqué est "+listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+2))].etat_PJ());
					}
					else {
						System.out.println("Il n'y a personne ici ! Quel gâchis !");
					}
				}
				else if (choixC==3 && plato.getCase(plato.chercherInd(this.numPJ)+1)!="#" && plato.getCase(plato.chercherInd(this.numPJ)+2)!="#") {
					if (plato.getCase(plato.chercherInd(this.numPJ)+3) != " " && plato.getCase(plato.chercherInd(this.numPJ)+3) != "#") {
						listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+3))].setHP(listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+3))].getHP()-15);
						System.out.println("Touché ! Le PJ attaqué est "+listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)+3))].etat_PJ());
					}
					else {
						System.out.println("Il n'y a personne ici ! Quel gâchis !");
					}
				}
			}
			else if (choixD==5) {
				if (choixC==1) {
					if (plato.getCase(plato.chercherInd(this.numPJ)-20) != " " && plato.getCase(plato.chercherInd(this.numPJ)-20) != "#") {
						listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-20))].setHP(listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-20))].getHP()-15);
						System.out.println("Touché ! Le PJ attaqué est "+listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-20))].etat_PJ());
					}
					else {
						System.out.println("Il n'y a personne ici ! Quel gâchis !");
					}
				}
				else if (choixC==2 && plato.getCase(plato.chercherInd(this.numPJ)-20) != "#" ) {
					if (plato.getCase(plato.chercherInd(this.numPJ)-40) != " " && plato.getCase(plato.chercherInd(this.numPJ)-40) != "#") {
						listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-40))].setHP(listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-40))].getHP()-15);
						System.out.println("Touché ! Le PJ attaqué est "+listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-40))].etat_PJ());
					}
					else {
						System.out.println("Il n'y a personne ici ! Quel gâchis !");
					}
				}
				else if (choixC==3 && plato.getCase(plato.chercherInd(this.numPJ)-20)!="#" && plato.getCase(plato.chercherInd(this.numPJ)-40)!="#") {
					if (plato.getCase(plato.chercherInd(this.numPJ)-60) != " " && plato.getCase(plato.chercherInd(this.numPJ)-60) != "#") {
						listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-60))].setHP(listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-60))].getHP()-15);
						System.out.println("Touché ! Le PJ attaqué est "+listePJ[Integer.parseInt(plato.getCase(plato.chercherInd(this.numPJ)-60))].etat_PJ());
					}
					else {
						System.out.println("Il n'y a personne ici ! Quel gâchis !");
					}
				}
			}
			this.PA = this.PA - 4;
		}
	}

	
	public void ramasserPotion (Scanner sc, map plato) {
		Potion soin = new Potion(true, false);
		Potion explosion = new Potion(false, true);
		int choix = 0;
		while (choix != 1 && choix != 2 && choix != 3 && choix !=5) {
			System.out.println("Dans quel direction souhaitez-vous ramasser ? -5 Haut, 1 Gauche, 2 Bas, 3 Droite-");
			choix = sc.nextInt();
		}
		if (choix==1) {
			if (plato.getCase(plato.chercherInd(this.numPJ)-1)=="s" ) {
				listePotion.add(soin);
				System.out.println("Vous avez ramasser une potion de soin.");
				this.PA = this.PA - 2;
				plato.setCaseJ(" ", plato.chercherInd(this.numPJ)-1);
			}
			else if (plato.getCase(plato.chercherInd(this.numPJ)-1)=="e" ) {
				listePotion.add(explosion);
				System.out.println("Vous avez ramasser une potion d'explosion.");
				this.PA = this.PA - 2;
				plato.setCaseJ(" ", plato.chercherInd(this.numPJ)-1);
			}
			else {
				System.out.println("Il n'y a rien à ramasser ici !");
			}
		}
		else if (choix == 2) {
			if (plato.getCase(plato.chercherInd(this.numPJ)+20)=="s" ) {
				listePotion.add(soin);
				System.out.println("Vous avez ramasser une potion de soin.");
				this.PA = this.PA - 2;
				plato.setCaseJ(" ", plato.chercherInd(this.numPJ)+20);
			}
			else if (plato.getCase(plato.chercherInd(this.numPJ)+20)=="e" ) {
				listePotion.add(explosion);
				System.out.println("Vous avez ramasser une potion d'explosion.");
				this.PA = this.PA - 2;
				plato.setCaseJ(" ", plato.chercherInd(this.numPJ)+20);
			}
			else {
				System.out.println("Il n'y a rien à ramasser ici !");
			}
		}
		else if (choix == 3) {
			if (plato.getCase(plato.chercherInd(this.numPJ)+1)=="s" ) {
				listePotion.add(soin);
				System.out.println("Vous avez ramasser une potion de soin.");
				this.PA = this.PA - 2;
				plato.setCaseJ(" ", plato.chercherInd(this.numPJ)+1);
			}
			else if (plato.getCase(plato.chercherInd(this.numPJ)+1)=="e" ) {
				listePotion.add(explosion);
				System.out.println("Vous avez ramasser une potion d'explosion.");
				this.PA = this.PA - 2;
				plato.setCaseJ(" ", plato.chercherInd(this.numPJ)+1);
			}
			else {
				System.out.println("Il n'y a rien à ramasser ici !");
			}
		}
		else {
			if (plato.getCase(plato.chercherInd(this.numPJ)-20)=="s" ) {
				listePotion.add(soin);
				System.out.println("Vous avez ramasser une potion de soin.");
				this.PA = this.PA - 2;
				plato.setCaseJ(" ", plato.chercherInd(this.numPJ)-20);
			}
			else if (plato.getCase(plato.chercherInd(this.numPJ)-20)=="e" ) {
				listePotion.add(explosion);
				System.out.println("Vous avez ramasser une potion d'explosion.");
				this.PA = this.PA - 2;
				plato.setCaseJ(" ", plato.chercherInd(this.numPJ)-20);
			}
			else {
				System.out.println("Il n'y a rien à ramasser ici !");
			}
		}
	}
	
    public void setHP(int hP) {
		HP = hP;
	}

	public int getHP() {
    	
		return HP;
		
	}

	public int getPA() {
		
		return PA;
		
	}

	public String getNumPJ() {
		
		return numPJ;
		
	}

	public String getType() {
		
    	return this.Type;
    	
    }
           
    public int getAdresse() {
		return Adresse;
	}

	public int getResistance() {
		return Resistance;
	}

	public armure getarmure() {
		return armure;
	}

	public ArrayList<Potion> getListePotion() {
		return listePotion;
	}

	public String toString() {
    	
    	return "Félicitations ! Vous êtes un "+this.Type+", avec pour caractéristiques : \n-Force : "+this.Force+"\n-Adresse : "+this.Adresse+"\n-Resistance : "+this.Resistance+"\nVotre niveau de XP : "+this.XP;
    	
    }
    
}