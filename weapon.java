package programme;

public class weapon extends equipement{

    private int maniabilite;
    private int impact;
    private int XPweapon;
    private int niveauweapon;


    public weapon (int maniabilite, int impact, int XPweapon, int niveauweapon) {

        this.maniabilite = maniabilite;
        this.impact = impact;
        this.XPweapon = XPweapon;
        this.niveauweapon = niveauweapon;

    }

    public void initweapon (PJ joueur, String type) {

        if (type == "Archer") {
            this.maniabilite = (7*this.XPweapon)/10;
            this.impact = (3*this.XPweapon)/10;
        }

        else {
            this.maniabilite = (3*this.XPweapon)/10;
            this.impact = (7*this.XPweapon)/10;
        }

    }

	public void evoweapon() {

        if (this.niveauweapon==1) {
            this.XPweapon = 10;
        }
        else if (this.niveauweapon==2) {
            this.XPweapon = 20;
        }
        else if (this.niveauweapon==3) {
            this.XPweapon = 30;
        }

    }
	
	public void upXPweapon() {
		
		this.XPweapon = this.XPweapon+10;
		
	}
	
    public int getNiveauweapon() {  	
		return niveauweapon;		
	}

	public int getManiabilite() {  	
		return maniabilite;		
	}

	public int getImpact() {		
		return impact;		
	}
	
    public void setManiabilite(int maniabilite) {
		this.maniabilite = maniabilite;
	}

	public void setImpact(int impact) {
		this.impact = impact;
	}

	public String toString () {
        return ("Votre weapon est de niveau "+this.niveauweapon+". Elle possède "+this.maniabilite+" en maniabilité et "+this.impact+" en impact.");
    }

}