package programme;

import java.util.Scanner;
import java.util.*;
import java.util.Random;


public class play {
	
	 public static boolean nbPJinLive (int nbj, PJ [] listePJs) {
			boolean nbPJinLive = true;
			int i = 0;
			int cpt_live = 0;
			while (i<nbj) {
				if (listePJs[i].getHP()>0) {
					cpt_live++;
				}
				i++;
			}
			if (cpt_live==1) {
				nbPJinLive = false;
			}
			return nbPJinLive;
		}
	
	public static boolean choice(Scanner sc, PJ PJ1, map map, PJ [] liste, PNJ [] lMonstre) {
		
		boolean passerTour = false;
		
		if (PJ1.getHP()>0 && PJ1.getPA()>1) {
			
			int number = 0;
			
			while (number>6 || number<=0) {
				System.out.println("PJ "+PJ1.getNumPJ()+" que souhaitez vous faire ? Taper 1 pour attaquer (3PA), 2 pour vous déplacer (2PA), 3 pour utiliser une potion (6 PA pour une potion de soin et 4 PA pour une potion d'explosion), 4 pour ramasser une potion (2 PA) ou 5 pour passer votre tour.");
				number = sc.nextInt();
			}
			
			if (number == 1) {
				if (PJ1.getPA()>=3) {
					if (PJ1.getType() == "Guerrier") {
						PJ1.attaquerGuerrier(sc, liste, map, lMonstre);
					}
					else {
						PJ1.attaquerArcher(sc, liste, map, lMonstre);
					}
				}
				else {
					System.out.println("Vous n'avez pas assez de points d'action.");
				}
			}
			else if (number == 2) {
				if (PJ1.getPA()>=2) {
					PJ1.seDeplacer(map, sc);
					map.affichage();
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
					if (PJ1.getPA()>=6) {
						int i = PJ1.getListePotion().size();
						if (i==0) {
							System.out.println("Vous n'avez pas de potion.");
						}
						else {
							boolean ispSoin = false;
							while (i>0 && !ispSoin) {
								if (PJ1.getListePotion().get(i-1).isSoin()) {
									PJ1.useSoinPotion(PJ1.getListePotion().get(i-1));
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
					if (PJ1.getPA()>=4) {
						int i = PJ1.getListePotion().size();
						if (i==0) {
							System.out.println("Vous n'avez pas de potion.");
						}
						else {
							boolean ispExplosion = false;
							while (i>0 && !ispExplosion) {
								if (PJ1.getListePotion().get(i-1).isExplosion()) {
									PJ1.useExplosionPotion(PJ1.getListePotion().get(i-1), map, sc, liste);
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
				if (PJ1.getPA()>=2) {
					PJ1.ramasserPotion(sc, map);
				}
			}
			else {
				passerTour = true;
			}
			int i = 5;
			while (i>2) {
				lMonstre[i].autoPNJ(map, liste);
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
		map plato = new map(a);		
		
		Potion soin = new Potion(true, false);
		Potion explosion = new Potion(false, true);

		ArrayList<Potion> listPotion1 = new ArrayList<Potion>();
		listPotion1.add(soin);
		listPotion1.add(explosion);
		armure tshirt = new armure(0,0,0,1);
		weapon baton = new weapon(0,0,0,1);		
		PJ Joueur1 = new PJ(0,0,0,50,0,0,"",baton,tshirt,"1", listPotion1);
		
		ArrayList<Potion> listPotion2 =  new ArrayList<Potion>();
		listPotion2.add(soin);
		listPotion2.add(explosion);
		armure veste = new armure(0,0,0,1);
		weapon woodBow = new weapon(0,0,0,1);
		PJ Joueur2 = new PJ(0,0,0,50,0,0,"",woodBow,veste,"2", listPotion2);

		ArrayList<Potion> listPotion3 = new ArrayList<Potion>();
		listPotion3.add(soin);
		listPotion3.add(explosion);
		armure plastron = new armure(0,0,0,1);
		weapon axe = new weapon(0,0,0,1);
		PJ Joueur3 = new PJ(0,0,0,50,0,0,"",axe,plastron,"3", listPotion3);
		
		PJ [] listePJs = {Joueur1, Joueur2, Joueur3};
		weapon [] listeweapons = { woodBow, axe,axe};
		armure [] listearmures = { plastron,plastron,plastron};
		
		PNJ MonstreA = new PNJ(8,8,8,50,"4");
		PNJ MonstreB = new PNJ(8,8,8,50,"5");
		PNJ MonstreC = new PNJ(8,8,8,50,"6");	
		
		PNJ [] lMonstres = {null,null,null,MonstreA,MonstreB,MonstreC};
        
        plato.init_play();
        plato.init_mur();
        
        
        int k = 5;
        while (k>2) {
        int casp = 0;
        
	        while (!plato.caseEmpty(casp)) {
	        	
	        	Random r = new Random();
	    		casp = r.nextInt(400);
	    		
	        }
	        plato.setCase(lMonstres[k].getNumPNJ(), casp);
	        k--;
        }
		int nbj = 0;
		
		while(nbj<=1 || nbj>3 ) {
			
			System.out.println("Combien de joueurs , jouable de 2 à 3.");
			nbj = sc.nextInt();
			
		}
		
		int i = 0;
		
		while (i<nbj) {
			
	        listePJs[i].init_type_PJ(sc);
	        listePJs[i].createPJ(sc);
	        System.out.println(listePJs[i]);
	        listePJs[i].etat_PJ();                
	        listeweapons[i].evoweapon();
	        listeweapons[i].initweapon(listePJs[i], listePJs[i].getType());
	        System.out.println(listeweapons[i]);
	        listearmures[i].evoarmure();
	        listearmures[i].initarmure(listePJs[i], listePJs[i].getType());
	        System.out.println(listearmures[i]);
	        
	        int cas = 0;
	        
	        while (!plato.caseEmpty(cas)) {
	        	
	        	Random r = new Random();
	    		cas = r.nextInt(400);
	    		
	        }
	        
	        plato.setCase(listePJs[i].getNumPJ(),cas);
	        plato.affichage();
	        i++;
	        
		}
		
		
		
		while (nbPJinLive(nbj, listePJs)) {
			int j = 0;
			while (j<nbj) {
				listePJs[j].initPA();
				boolean choix = choice(sc,listePJs[j],plato,listePJs, lMonstres);
				while (choix == false && listePJs[j].getPA()>0) {
					choix = choice(sc,listePJs[j],plato,listePJs, lMonstres);
				}
				j++;
			}
	    	
		
		}
		
		sc.close();
		
	}
}