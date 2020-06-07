package programme;

public class Potion {
	
	private boolean Soin;
	private boolean Explosion;
	
	public Potion (boolean Soin, boolean Explosion) {
		this.Soin = Soin;
		this.Explosion= Explosion;
	}

	public boolean isSoin() {
		return Soin;
	}

	public void setSoin(boolean soin) {
		Soin = soin;
	}

	public boolean isExplosion() {
		return Explosion;
	}

	public void setExplosion(boolean explosion) {
		Explosion = explosion;
	}
	
}