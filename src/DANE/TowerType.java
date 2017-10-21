package DANE;

import org.newdawn.slick.opengl.Texture;

import static HELPERS.Artist.*;

public enum TowerType {
	
	CannonRed(new Texture[]{QuickLoad("cannonBase"), QuickLoad("cannonGun")}, ProjectileType.CannonBall, 10, 1000, 3, 10),
	CannonBlue(new Texture[]{QuickLoad("cannonBaseBlue"), QuickLoad("cannonGunBlue")}, ProjectileType.CannonBall, 20, 1000, 3, 20),
	CannonIce(new Texture[]{QuickLoad("cannonIceBase"), QuickLoad("cannonIceGun")}, ProjectileType.IceBall, 30, 1000, 3, 30);
	Texture[] textures;
	ProjectileType projectileType;
	int damage, range, cost;
	float firingSpeed;
	
	
	TowerType(Texture[] textures, ProjectileType projectileType, int damage, int range, float firingSpeed, int cost)
	{
		this.textures = textures;
		this.projectileType = projectileType;
		this.damage = damage;
		this.range = range;
		this.firingSpeed = firingSpeed;
		this.cost = cost;
	}

}
