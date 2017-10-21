package DANE;

import java.util.concurrent.CopyOnWriteArrayList;

import static HELPERS.Clock.*;
import static HELPERS.Artist.*;

public class Wave {

	private float timeSinceLastSpawn, spawnTime;
	private Enemy[] enemyTypes;
	private CopyOnWriteArrayList<Enemy> enemyList;
	private int enemiesPerWave, enemiesSpawned;
	private boolean waveCompleted;

	public Wave(Enemy[] enemyTypes, float spawnTime, int enemiesPerWave) {
		this.enemyTypes = enemyTypes;
		this.spawnTime = spawnTime;
		this.enemiesPerWave = enemiesPerWave;
		this.enemiesSpawned = 0;
		this.enemyList = new CopyOnWriteArrayList<Enemy>();
		this.waveCompleted = false;

		spawn();

	}

	public void update() {
		boolean allEnemiesDead = true;
		if (enemiesSpawned < enemiesPerWave){
			timeSinceLastSpawn += Delta();
		if (timeSinceLastSpawn > spawnTime) {

			spawn();
			timeSinceLastSpawn = 0;

		}
		}

		for (Enemy e : enemyList) {
			if (e.isAlive()) {
				allEnemiesDead = false;
				e.update();
				e.draw();
			} else
				enemyList.remove(e);

		}
		if (allEnemiesDead)
		{
			waveCompleted = true;
		}

	}

	private void spawn() {
		int enemyChosen = 0 + (int) (Math.random() * 3);

		enemyList.add(new Enemy(enemyTypes[enemyChosen].getTexture(), enemyTypes[enemyChosen].getStartTile(), enemyTypes[enemyChosen].getTileGrid(), TILE_SIZE, TILE_SIZE,
				enemyTypes[enemyChosen].getSpeed(), enemyTypes[enemyChosen].getHealth()));
		enemiesSpawned = enemiesSpawned + 1;
	}

	public boolean isCompleted() {
		return waveCompleted;
	}
	
	public CopyOnWriteArrayList<Enemy> getEnemyList()
	{
		return enemyList;
	}

}
