package DANE;



public class EnemyTank extends Enemy{

	public EnemyTank(int tileX, int tileY, TileGrid grid) {
		super(tileX, tileY, grid);		
		this.setTexture("tank");
	}

}
