package DANE;

import org.newdawn.slick.opengl.Texture;

import static HELPERS.Artist.*;

public enum ProjectileType {
	
	CannonBall(QuickLoad("projectileRedBall"),  10, 500),
	IceBall(QuickLoad("projectileIceBall"),  10, 500);
	
	
	Texture texture;
	int damage;
	float speed;
	
	ProjectileType(Texture texture, int damage, float speed)
	{
		this.texture = texture;
		this.damage = damage;
		this.speed = speed;
	}

}
