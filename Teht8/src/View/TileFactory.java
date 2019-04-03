package View;


public class TileFactory {

	private final int tileSize = 128;

	public Tile createTile(int xPos, int yPos, int i, int j) {
		Tile tile = new Tile(tileSize, xPos, yPos, i, j);
		return tile;
	}

	public int getTileSize() {
		return tileSize;
	}
}
