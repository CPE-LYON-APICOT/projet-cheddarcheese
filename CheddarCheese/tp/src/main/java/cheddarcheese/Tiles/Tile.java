package cheddarcheese.Tiles;

public class Tile {
    private String label;
    private String path;
    private int x;
    private int y;

    public Tile(String label, String path, int x, int y) {
        this.x = x;
        this.y = y;
        this.path = path;
        this.label = label;
    }

    /**
     * Getters/Setters
     */
    public int getX() {return x;}
    public int getY() {return y;}
    public String getPath() {return path;}
    public String getLabel() {return label;}
    public void setPath(String path) {this.path = path;};
}
