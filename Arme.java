package programme;

public class Arme {

    private int maniabilite;
    private int impact;
    private int XPArme;
    private int niveauArme;


    public Arme (int maniabilite, int impact, int XPArme, int niveauArme) {

        this.maniabilite = maniabilite;
        this.impact = impact;
        this.XPArme = XPArme;
        this.niveauArme = niveauArme;

    }

    public void initArme (Joueur joueur, String type) {

        if (type == "Archer") {
            this.maniabilite = (7*this.XPArme)/10;
            this.impact = (3*this.XPArme)/10;
        }

        else {
            this.maniabilite = (3*this.XPArme)/10;
            this.impact = (7*this.XPArme)/10;
        }

    }

	public void evoArme() {

        if (this.niveauArme==1) {
            this.XPArme = 10;
        }
        else if (this.niveauArme==2) {
            this.XPArme = 20;
        }
        else if (this.niveauArme==3) {
            this.XPArme = 30;
        }

    }
	
	public void upXPArme() {
		
		this.XPArme = this.XPArme+10;
		
	}
	
    public int getNiveauArme() {
    	
		return niveauArme;
		
	}

	public int getManiabilite() {
    	
		return maniabilite;
		
	}

	public int getImpact() {
		
		return impact;
		
	}
	
    public String toString () {

        return ("Votre arme est de niveau "+this.niveauArme+". Elle possède "+this.maniabilite+" en maniabilité et "+this.impact+" en impact.");

    }

}
