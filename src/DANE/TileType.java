package DANE;

public enum TileType {
	
	Trawa("kwadrat2", true), Ziemia("kwadrat", false), Woda("kwadrat3", false), NULL("kwadrat3", false) ; 
	
	String textureName;
	boolean buildable;
	
	TileType(String textureName, boolean buildable) {
		
		this.textureName = textureName;
		this.buildable = buildable;
	}

}
