package DANE;
import java.util.concurrent.CopyOnWriteArrayList;
import static HELPERS.Artist.*;
public class TowerCannonBlue extends Tower {

	public TowerCannonBlue(TowerType type, Tile startTile, CopyOnWriteArrayList<Enemy> enemies) {
		super(type, startTile, enemies);
	}

	@Override
	public void shoot(Enemy target) {
		super.projectiles.add(
				new ProjectileCannonBall(super.type.projectileType, super.target, super.getX(), super.getY(), TILE_SIZE / 2, TILE_SIZE / 2));
		super.target.reduceHiddenHealth(super.type.projectileType.damage);
	}

}
