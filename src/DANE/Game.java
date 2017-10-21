package DANE;

import static HELPERS.Artist.DrawQuadTex;
import static HELPERS.Artist.QuickLoad;


import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

import HELPERS.StateManager;
import UI.UI;
import UI.UI.Menu;

public class Game {
	private TileGrid grid;
	private Player player;
	private WaveManager waveManager;
	private UI gameUI;
	private Menu towerPickerMenu;
	private Texture MenuBackground;
	private Enemy[] enemyTypes;

	public Game(TileGrid grid) {
		this.grid = grid;
		enemyTypes = new Enemy[3];
		enemyTypes[0] = new EnemyAlien(0, 14, grid);
		enemyTypes[1] = new EnemyUFO(0, 14, grid);
		enemyTypes[2] = new EnemyTank(0, 14, grid);
		waveManager = new WaveManager (enemyTypes, 2, 0);
		player = new Player(grid, waveManager);
		player.setup();
		this.MenuBackground = QuickLoad("MenuBackGround2");
		setupUI();
	}

	private void setupUI() {
		gameUI = new UI();
		gameUI.createMenu("Wybór wie¿y", 1280, 100, 192, 960, 2, 0);
		towerPickerMenu = gameUI.getMenu("Wybór wie¿y");
		towerPickerMenu.quickAdd("CannonRed", "cannonRedFull");
		towerPickerMenu.quickAdd("CannonBlue", "cannonBlueFull");
		towerPickerMenu.quickAdd("CannonIce", "cannonIceFull");
		

	}

	private void updateUI() {
		gameUI.draw();
		gameUI.drawString(1310, 400, "Lives: " + Player.Lives);
		gameUI.drawString(1310, 500, "Cash: " + Player.Cash);
		gameUI.drawString(1310, 600, "Wave: " + waveManager.getWaveNumber());
		gameUI.drawString(1310, 700, "Soldiers: " + waveManager.getEnemiesPerWave());
		gameUI.drawString(1310, 800, "FPS: " + StateManager.framesInLastSecond);

		if (Mouse.next()) {
			boolean mouseClicked = Mouse.isButtonDown(0);
			if (mouseClicked) {
				if (towerPickerMenu.isButtonClicked("CannonBlue"))

					player.pickTower(new TowerCannonBlue(TowerType.CannonBlue, grid.getTile(0, 0),
							waveManager.getCurrentWave().getEnemyList()));
				
				if (towerPickerMenu.isButtonClicked("CannonRed"))

					player.pickTower(new TowerCannonBlue(TowerType.CannonRed, grid.getTile(0, 0),
							waveManager.getCurrentWave().getEnemyList())); 
				
				if (towerPickerMenu.isButtonClicked("CannonIce"))

					player.pickTower(new TowerCannonIce(TowerType.CannonIce, grid.getTile(0, 0),
							waveManager.getCurrentWave().getEnemyList())); 
			}
		}
	}

	public void update() {
		
		DrawQuadTex(MenuBackground, 1280, 0, 192, 960);
		grid.draw();
		waveManager.update();
		player.update();
		updateUI();

	}

}


