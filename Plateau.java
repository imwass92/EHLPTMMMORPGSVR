package programme;

public class Plateau {

	public static String[] plateau;
	
	
	public Plateau(String[] a) {
		
		this.plateau = a;
		
	}
	
	public void init_play() {
		
		String[] a;
		a = new String [400];
		this.plateau = a;
		
	}
	
	public void init_mur() {
		
		for(int i=0;i<this.plateau.length;i++) {
			
			if (i<20) {
				this.plateau[i] = "#";
			}
			else if (i>379) {
				this.plateau[i] = "#";
			}
			else if (i%20==0) {
				this.plateau[i] = "#";
			}
			else if (i%20==19) {
				this.plateau[i] = "#";
			}
			else {
				this.plateau[i] = " ";
			}
		}
		
	}
	
	public boolean intVal(int i) {
		
		boolean res = true;
		if (i<0 && i>399) {
			res = false;
		}
		return res;
		
	}
	
	public int chercherInd (String numJoueur) {
		
		int i=0;
		int j=0;
		while (j<this.plateau.length && j==i) {
			if (this.plateau[i] != numJoueur) {
				i = i+1;
			}
			j=j+1;
		}
		return i;
		
	}
	
	public boolean caseVide(int i) {
		
		boolean res = false;
		if (this.plateau[i]==" ") {
			res = true;
		}
		return res;
		
	}

	public void affichage() {

        int i = 0;
        while (i<400) {
        	int a = 0;
        	String chaine = "";
        	while (a<20) {
        		chaine = chaine + this.plateau[i];
        		a++;
        		i++;
        	}
        	
        	System.out.println(chaine);  
        	
        }
        
    }
	
	public void setCase(String val, int i) {
		
		if (this.intVal(i) ==false) {
			System.out.println("L'entier n'est pas valide");
		}
		else if (this.caseVide(i)==false ) {
			System.out.println("La case est déjà utilisé");
		}
		else {
			this.plateau[i] = val;
		}
		
	}
	
	public void setCaseJ(String val, int i) {
		
		this.plateau[i] = val;
		
	}
	
	public String getCase(int i) {	
		
		return this.plateau[i];	
		
	}
	
}