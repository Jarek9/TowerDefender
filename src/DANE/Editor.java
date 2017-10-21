package DANE;

import static HELPERS.Artist.DrawQuadTex;
import static HELPERS.Artist.HEIGHT;
import static HELPERS.Artist.QuickLoad;
import static HELPERS.Leveler.*;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.opengl.Texture;

import UI.UI;
import UI.UI.Menu;

import static HELPERS.Artist.TILE_SIZE;


public class Editor {

	private TileGrid grid;
	private int index;
	private TileType[] types;
	private UI editorUI;
	private Menu tilePickerMenu;
	private Texture MenuBackground;

	public Editor() {
		this.grid = LoadMap("mapTest");
		this.index = 0;
		this.types = new TileType[3];
		this.types[0] = TileType.Trawa;
		this.types[1] = TileType.Ziemia;
		this.types[2] = TileType.Woda;
		this.MenuBackground = QuickLoad("MenuBackground");
		setupUI();
	}
	
	private void setupUI()
	{
		editorUI = new UI();
		editorUI.createMenu("Wybór pod³o¿a", 1280, 100, 192, 960, 2, 0);
		tilePickerMenu = editorUI.getMenu("Wybór pod³o¿a");
		tilePickerMenu.quickAdd("Trawa", "kwadrat2");
		tilePickerMenu.quickAdd("Ziemia", "kwadrat");
		tilePickerMenu.quickAdd("Woda", "kwadrat3");
	}

	public void update() {
		
		draw();
		
		
		//Mysz
		if (Mouse.next()) {
			boolean mouseClicked = Mouse.isButtonDown(0);
			if (mouseClicked) {
				if (tilePickerMenu.isButtonClicked("Trawa"))
				{
					index = 0;
				}
				else if (tilePickerMenu.isButtonClicked("Ziemia"))
				{
					index = 1;
				}
				else if (tilePickerMenu.isButtonClicked("Woda"))
				{
					index = 2;
				}
					
					else
						setTile();				

			}
		}

		// Klawiatura
		while (Keyboard.next()) {
			if (Keyboard.getEventKey() == Keyboard.KEY_RIGHT && Keyboard.getEventKeyState()) {
				moveIndex();
			}
			if (Keyboard.getEventKey() == Keyboard.KEY_S && Keyboard.getEventKeyState()) 
			{
				SaveMap("mapTest", grid);
			}

		}
	}
	
	private void draw()
	{
		DrawQuadTex(MenuBackground, 1280, 0, 192, 960);
		grid.draw();
		editorUI.draw();
		
	}

	private void setTile() {

		grid.setTile((int) Math.floor(Mouse.getX() / TILE_SIZE),
				(int) Math.floor((HEIGHT - Mouse.getY() - 1) / TILE_SIZE), types[index]);
	}

	//Pozwala na zmianê rodzaju pod³o¿a
	private void moveIndex() {

		index++;
		if (index > types.length - 1) {
			index = 0;
		}
	}

}
