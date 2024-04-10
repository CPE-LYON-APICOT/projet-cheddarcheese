package cheddarcheese.Tiles;

import cheddarcheese.Player;

public class Foodbox extends Tile implements InteractTile{
    public Foodbox(String label, String path, int x, int y) {
        super(label, path, x, y);
    }

    @Override
    public void interact(Player p) {
        System.out.println("Foodbox");
    }
}
