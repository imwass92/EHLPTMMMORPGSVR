package programme;

import java.util.Scanner;
import java.util.*;
import java.util.Random;


public class Jouer {
	
	 public static boolean isLive (int nbj, Joueur [] listeJoueurs) {
			boolean islive = true;
			int i = 0;
			int cpt_vie = 0;
			while (i<nbj) {
				if (listeJoueurs[i].getHP()>0) {
					cpt_vie++;
				}
				i++;
			}
			if (cpt_vie==1) {
				islive = false;
			}
			return islive;
		}
	
	public static boolean choixAction(Scanner sc, Joueur joueur1, Plateau plateau, Joueur [] liste, PNJ [] lmonstre) {
		
		boolean passerTour = false;
		
		if (joueur1.getHP()>0 && joueur1.getPA()>1) {
			
			int number = 0;
			
			while (number>6 || number<=0) {
				System.out.println("Joueur "+joueur1.getNumJoueur()+" que souhaitez vous faire ? Taper 1 pour attaquer (3PA), 2 pour vous déplacer (2PA), 3 pour utiliser une potion (6 PA pour une potion de soin et 4 PA pour une potion d'explosion), 4 pour ramasser une potion (2 PA) ou 5 pour passer votre tour.");
				number = sc.nextInt();
			}
			
			if (number == 1) {
				if (joueur1.getPA()>=3) {
					if (joueur1.getType() == "Guerrier") {
						joueur1.attaquerGuerrier(sc, liste, plateau, lmonstre);
					}
					else {
						joueur1.attaquerArcher(sc, liste, plateau, lmonstre);
					}
				}
				else {
					System.out.println("Vous n'avez pas assez de points d'action.");
				}
			}
			else if (number == 2) {
				if (joueur1.getPA()>=2) {
					joueur1.seDeplacer(plateau, sc);
					plateau.affichage();
				}
				else {
					System.out.println("Vous n'avez pas assez de points d'action.");
				}			
			}
			else if (number == 3) {
				int n = 0;
				while (n<1 || n>2) {
					System.out.println("Voulez-vous utiliser une potion de soin ou d'explosion ? -Taper 1 pour une potion de soin, Taper 2 pour une potion d'explosion-");
					n = sc.nextInt();
				}
				if (n==1) {
					if (joueur1.getPA()>=6) {
						int i = joueur1.getListePotion().size();
						if (i==0) {
							System.out.println("Vous n'avez pas de potion.");
						}
						else {
							boolean ispSoin = false;
							while (i>0 && !ispSoin) {
								if (joueur1.getListePotion().get(i-1).isSoin()) {
									joueur1.useSoinPotion(joueur1.getListePotion().get(i-1));
									ispSoin = true;
								}
								i--;
							}
							if (!ispSoin) {
								System.out.println("Vous n'avez pas de potion de soin.");
							}
						}
					}
					else {
					System.out.println("Vous n'avez pas assez de PA.");
					}
				}
				else {
					if (joueur1.getPA()>=4) {
						int i = joueur1.getListePotion().size();
						if (i==0) {
							System.out.println("Vous n'avez pas de potion.");
						}
						else {
							boolean ispExplosion = false;
							while (i>0 && !ispExplosion) {
								if (joueur1.getListePotion().get(i-1).isExplosion()) {
									joueur1.useExplosionPotion(joueur1.getListePotion().get(i-1), plateau, sc, liste);
									ispExplosion = true;
								}
								i--;
							}
							if (!ispExplosion) {
								System.out.println("Vous n'avez pas de potion d'explosion.");
							}
						}
					}
					else {
					System.out.println("Vous n'avez pas assez de PA.");
					}
				}
			}
			else if ( number == 4) {
				if (joueur1.getPA()>=2) {
					joueur1.ramasserPotion(sc, plateau);
				}
			}
			else {
				passerTour = true;
			}
			int i = 8;
			while (i>2) {
				lmonstre[i].autoPNJ(plateau, liste);
				i--;
			}
		}
		else {
			passerTour = true;
		}
		
		return passerTour;
		
	}
	
	public static void main(String args[]) {		
		
		Scanner sc = new Scanner (System.in);
		
		String[] a = {};
		Plateau plato = new Plateau(a);		
		
		Potion soin = new Potion(true, false);
		Potion explosion = new Potion(false, true);

		ArrayList<Potion> listePotionR = new ArrayList<Potion>();
		listePotionR.add(soin);
		listePotionR.add(explosion);
		Vetement tshirt = new Vetement(0,0,0,1);
		Arme baton = new Arme(0,0,0,1);		
		Joueur Ragnar = new Joueur(0,0,0,50,0,0,"",baton,tshirt,"1", listePotionR);
		
		ArrayList<Potion> listePotionF =  new ArrayList<Potion>();
		listePotionF.add(soin);
		listePotionF.add(explosion);
		Vetement veste = new Vetement(0,0,0,1);
		Arme lancePierre = new Arme(0,0,0,1);
		Joueur Floki = new Joueur(0,0,0,50,0,0,"",lancePierre,veste,"2", listePotionF);

		ArrayList<Potion> listePotionB = new ArrayList<Potion>();
		listePotionB.add(soin);
		listePotionB.add(explosion);
		Vetement chemise = new Vetement(0,0,0,1);
		Arme hache = new Arme(0,0,0,1);
		Joueur Bjorn = new Joueur(0,0,0,50,0,0,"",hache,chemise,"3", listePotionB);
		
		Joueur [] listeJoueurs = {Ragnar, Floki, Bjorn};
		Arme [] listeArmes = {baton, lancePierre, hache};
		Vetement [] listeVetements = {tshirt, veste, chemise};
		
		PNJ Monstre = new PNJ(8,8,8,50,"9");
		PNJ Monstro = new PNJ(8,8,8,50,"8");
		PNJ Monstrito = new PNJ(8,8,8,50,"7");
		PNJ Monstrousse = new PNJ(8,8,8,50,"6");
		PNJ Monstrette = new PNJ(8,8,8,50,"5");
		PNJ Monstratcho = new PNJ(8,8,8,50,"4");
		
		PNJ [] lmonstres = {null,null,null,Monstratcho,Monstrette,Monstrousse,Monstrito,Monstro,Monstre};
        
        plato.init_play();
        plato.init_mur();
        
        
        int k = 8;
        while (k>2) {
        int casp = 0;
        
	        while (!plato.caseVide(casp)) {
	        	
	        	Random r = new Random();
	    		casp = r.nextInt(400);
	    		
	        }
	        plato.setCase(lmonstres[k].getNumPNJ(), casp);
	        k--;
        }
		int nbj = 0;
		
		while(nbj<=0 || nbj>3 ) {
			
			System.out.println("Combien de y a t-il de joueurs ? (jouable de 2 à 3)");
			nbj = sc.nextInt();
			
		}
		
		int i = 0;
		
		while (i<nbj) {
			
	        listeJoueurs[i].init_type_Joueur(sc);
	        listeJoueurs[i].init_car_Joueur(sc);
	        System.out.println(listeJoueurs[i]);
	        listeJoueurs[i].etat_Joueur();                
	        listeArmes[i].evoArme();
	        listeArmes[i].initArme(listeJoueurs[i], listeJoueurs[i].getType());
	        System.out.println(listeArmes[i]);
	        listeVetements[i].evoVetement();
	        listeVetements[i].initVetement(listeJoueurs[i], listeJoueurs[i].getType());
	        System.out.println(listeVetements[i]);
	        
	        int cas = 0;
	        
	        while (!plato.caseVide(cas)) {
	        	
	        	Random r = new Random();
	    		cas = r.nextInt(400);
	    		
	        }
	        
	        plato.setCase(listeJoueurs[i].getNumJoueur(),cas);
	        plato.affichage();
	        i++;
	        
		}
		
		
		
		while (isLive(nbj, listeJoueurs)) {
			int j = 0;
			while (j<nbj) {
				listeJoueurs[j].initPA();
				boolean choix = choixAction(sc,listeJoueurs[j],plato,listeJoueurs, lmonstres);
				while (choix == false && listeJoueurs[j].getPA()>0) {
					choix = choixAction(sc,listeJoueurs[j],plato,listeJoueurs, lmonstres);
				}
				j++;
			}
	    	
		
		}
		
		sc.close();
		
	}
}