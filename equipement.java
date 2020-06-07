package programme;

public  class equipement {
	 	private int stat1;//emcombrement et maniabilité
	    private int stat2;//impact et solidité
	    private int XPEquipement;
	    
	    public int getStat1() {
			return stat1;
		}

		public void setStat1(int stat1) {
			this.stat1 = stat1;
		}

		public int getStat2() {
			return stat2;
		}

		public void setStat2(int stat2) {
			this.stat2 = stat2;
		}

		public int getXPEquipement() {
			return XPEquipement;
		}

		public void setXPEquipement(int xPEquipement) {
			XPEquipement = xPEquipement;
		}

		public int getNiveauxEquipement() {
			return niveauxEquipement;
		}

		public void setNiveauxEquipement(int niveauxEquipement) {
			this.niveauxEquipement = niveauxEquipement;
		}

		private int niveauxEquipement;
}
