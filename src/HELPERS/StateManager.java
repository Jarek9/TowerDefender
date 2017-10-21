package HELPERS;

import DANE.Editor;
import DANE.Game;
import DANE.MainMenu;
import DANE.TileGrid;

import static HELPERS.Leveler.LoadMap;

public class StateManager {
	
	public static enum GameState
	{
		MAINMENU, GAME, EDITOR
	}
	
	public static GameState gameState = GameState.MAINMENU;
	public static MainMenu mainMenu;
	public static Game game;
	public static Editor editor;
	
	public static long nextSecond = System.currentTimeMillis() + 1000;
	public static int framesInLastSecond = 0;
	public static int framesInCurrentSecond = 0;
	
	static TileGrid map = LoadMap("mapTest");
	
	public static void update()
	{
		switch(gameState)
		{
		case MAINMENU:
			if (mainMenu == null)
			{
				mainMenu = new MainMenu();				
			}
			mainMenu.update();
				break;
				case GAME:
					if (game == null)
					{
						game = new Game(map);
					}
				game.update();
				break;
				case EDITOR:
				if (editor == null)
				{
					editor = new Editor();
				}
				editor.update();
				break;
							
		}
		
		long currentTime = System.currentTimeMillis();
		if (currentTime > nextSecond)
		{
			nextSecond += 1000;
			framesInLastSecond = framesInCurrentSecond;
			framesInCurrentSecond = 0;
		}
		
		framesInCurrentSecond = framesInCurrentSecond + 1;
		
		
	}
	
	public static void setState(GameState newState)
	{
		gameState = newState;
	}

}
