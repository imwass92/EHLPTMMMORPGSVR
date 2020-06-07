package programme;

public class map {

	public static String[] map;
	
	
	public map(String[] a) {
		
		this.map = a;
		
	}
	
	public void init_play() {
		
		String[] a;
		a = new String [400];
		this.map = a;
		
	}
	
	public void init_mur() {
		
		for(int i=0;i<this.map.length;i++) {
			
			if (i<20) {
				this.map[i] = "#";
			}
			else if (i>379) {
				this.map[i] = "#";
			}
			else if (i%20==0) {
				this.map[i] = "#";
			}
			else if (i%20==19) {
				this.map[i] = "#";
			}
			else {
				this.map[i] = " ";
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
	
	public int chercherInd (String numPJ) {
		
		int i=0;
		int j=0;
		while (j<this.map.length && j==i) {
			if (this.map[i] != numPJ) {
				i = i+1;
			}
			j=j+1;
		}
		return i;
		
	}
	
	public boolean caseEmpty(int i) {
		
		boolean res = false;
		if (this.map[i]==" ") {
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
        		chaine = chaine + this.map[i];
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
		else if (this.caseEmpty(i)==false ) {
			System.out.println("La case est déjà utilisé");
		}
		else {
			this.map[i] = val;
		}		
	}
	
	public void setCaseJ(String val, int i) {		
		this.map[i] = val;	
	}
	
	public String getCase(int i) {			
		return this.map[i];			
	}
	
}