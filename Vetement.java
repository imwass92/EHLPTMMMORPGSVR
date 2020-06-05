package programme;

public class Vetement {

    private int encombrement;
    private int solidite;
    private int XPVetement;
    private int niveauVetement;


    public Vetement (int encombrement, int solidite, int XPVetement, int niveauVetement) {

        this.encombrement = encombrement;
        this.solidite = solidite;
        this.XPVetement = XPVetement;
        this.niveauVetement = niveauVetement;

    }

    public void initVetement (Joueur joueur, String type) {

        if (type == "Archer") {
            this.encombrement = (100/this.XPVetement)/2;
            this.solidite = (3*this.XPVetement)/10;
        }

        else {
            this.encombrement = (100/this.XPVetement)+2;
            this.solidite = (7*this.XPVetement)/10;
        }

    }

	public void evoVetement() {

        if (this.niveauVetement==1) {
            this.XPVetement = 10;
        }
        else if (this.niveauVetement==2) {
            this.XPVetement = 25;
        }
        else if (this.niveauVetement==3) {
            this.XPVetement = 50;
        }

    }
	
	public void upXPVetement() {
		
		this.XPVetement = this.XPVetement+10;
		
	}
	
    public int getNiveauVetement() {
    	
		return niveauVetement;
		
	}
	
    public int getEncombrement() {
    	
		return encombrement;
		
	}

	public int getSolidite() {
		
		return solidite;
		
	}
	
    public String toString () {

        return ("Votre vetement est de niveau "+this.niveauVetement+". Il possède "+this.encombrement+" en encombrement et "+this.solidite+" en solidité.");

    }

}

