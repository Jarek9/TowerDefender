package HELPERS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import DANE.Tile;
import DANE.TileGrid;
import DANE.TileType;

public class Leveler {

	public static void SaveMap(String mapName, TileGrid grid) {
		String mapData = "";
		for (int i = 0; i < grid.getTilesWide(); i = i + 1) {
			for (int j = 0; j < grid.getTilesHigh(); j = j + 1) {
				mapData += getTileID(grid.getTile(i, j));
			}
		}
		try {
			File file = new File(mapName);

			BufferedWriter bw = new BufferedWriter(new FileWriter(file));
			bw.write(mapData);
			bw.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

	public static TileGrid LoadMap(String mapName) {
		TileGrid grid = new TileGrid();
		try {
			BufferedReader br = new BufferedReader(new FileReader(mapName));
			String data = br.readLine();
			for (int i = 0; i < grid.getTilesWide(); i = i + 1) {
				for (int j = 0; j < grid.getTilesHigh(); j = j + 1) {
					grid.setTile(i, j,
							getTileType(data.substring(i * grid.getTilesHigh() + j, i * grid.getTilesHigh() + j + 1)));
				}
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return grid;

	}

	public static TileType getTileType(String ID) {
		TileType type = TileType.NULL;
		switch (ID) {
		case "0":
			type = TileType.Trawa;
			break;
		case "1":
			type = TileType.Ziemia;
			break;
		case "2":
			type = TileType.Woda;
			break;
		case "3":
			type = TileType.NULL;
			break;
		}
		return type;
	}

	public static String getTileID(Tile t) {
		String ID = "E";
		switch (t.getType()) {
		case Trawa:
			ID = "0";
			break;
		case Ziemia:
			ID = "1";
			break;
		case Woda:
			ID = "2";
			break;
		case NULL:
			ID = "3";
			break;

		}
		return ID;
	}

}
