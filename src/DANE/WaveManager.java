package DANE;

public class WaveManager {
	
	private float timeScinceLastWave, timeBetweenEnemies;
	private int waveNumber, enemiesPerWave;
	private Enemy[] enemyTypes;
	private Wave currentWave;
	
	public WaveManager(Enemy[] enemyTypes, float timeBetweenEnemies, int enemiesPerWave)
	{
		
		this.enemyTypes = enemyTypes;
		this.timeBetweenEnemies = timeBetweenEnemies;
		this.enemiesPerWave =  50 + (int) (Math.random() * 100);
		this.timeScinceLastWave = 0;
		this.waveNumber = 0;		
		this.currentWave = null;
		newWave();
	}
	
	public void update()
	{
		if (!currentWave.isCompleted())
		{
			currentWave.update();
		}
		else 
		{
			newWave();
		}
	}
	
	private void newWave()
	{
		currentWave = new Wave(enemyTypes, timeBetweenEnemies, enemiesPerWave);
		waveNumber = waveNumber + 1;
		
	}
	
	public Wave getCurrentWave()
	{
		return currentWave;
	}
	
	public int getWaveNumber()
	{
		return waveNumber;
	}
	
	public int getEnemiesPerWave()
	{
		return enemiesPerWave;
	}

}
