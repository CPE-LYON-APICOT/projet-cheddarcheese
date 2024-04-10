package cheddarcheese.Tiles;

import cheddarcheese.Player;

public class CuttingTable extends Table implements InteractTile{
    public CuttingTable(String label, String path, int x, int y) {
        super(label, path, x, y);
    }

    @Override
    public void interact(Player p) {
        System.out.println("CuttingTable");
    }
}
