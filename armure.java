package programme;

public class armure extends equipement{

    private int encombrement;
    private int solidite;
    private int XParmure;
    private int niveauarmure;


    public armure (int encombrement, int solidite, int XParmure, int niveauarmure) {

        this.encombrement = encombrement;
        this.solidite = solidite;
        this.XParmure = XParmure;
        this.niveauarmure = niveauarmure;

    }

    public void initarmure (PJ joueur, String type) {

        if (type == "Archer") {
            this.encombrement = (100/this.XParmure)/2;
            this.solidite = (3*this.XParmure)/10;
        }

        else {
            this.encombrement = (100/this.XParmure)+2;
            this.solidite = (7*this.XParmure)/10;
        }

    }

	public void evoarmure() {

        if (this.niveauarmure==1) {
            this.XParmure = 10;
        }
        else if (this.niveauarmure==2) {
            this.XParmure = 25;
        }
        else if (this.niveauarmure==3) {
            this.XParmure = 50;
        }

    }
	
	public void upXParmure() {		
		this.XParmure = this.XParmure+10;		
	}
	
    public int getNiveauarmure() {   	
		return niveauarmure;	
	}
	
    public int getEncombrement() {  	
		return encombrement;		
	}

	public int getSolidite() {		
		return solidite;		
	}
	
    public void setEncombrement(int encombrement) {
		this.encombrement = encombrement;
	}

	public void setSolidite(int solidite) {
		this.solidite = solidite;
	}

	public String toString () {
        return ("Votre armure est de niveau "+this.niveauarmure+". Il possède "+this.encombrement+" en encombrement et "+this.solidite+" en solidité.");
    }

}