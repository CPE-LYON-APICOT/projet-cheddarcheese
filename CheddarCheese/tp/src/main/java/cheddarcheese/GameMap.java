package cheddarcheese;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import cheddarcheese.Tiles.*;

public class GameMap {
    private Tile tiles[][];
    private int sizeX = 9;
    private int sizeY = 9;

    public GameMap() {
        tiles = new Tile[sizeX][sizeY];
    }

    public void loadMap(String mapName){
        int mapTiles[][] = new int[sizeX][sizeY];

        Floor floor = new Floor("Floor", "sprites/floor.png", 0, 0);
        Wall wall = new Wall("Wall", "sprites/wall.png", 0, 0);
        Table table = new Table("Table", "sprites/table.png", 0, 0);
        CuttingTable cuttingTable = new CuttingTable("CuttingTable", "sprites/cutting_table.png", 0, 0);
        Deposit deposit = new Deposit("Deposit", "sprites/deposit.png", 0, 0);
        Bin bin = new Bin("Bin", "sprites/bin.png", 0, 0);
        FoodboxClosed foodboxClosed = new FoodboxClosed("FoodboxClosed", "sprites/foodbox_closed.png", 0, 0);
        Inventory inventory = new Inventory("Inventory", "sprites/inventory.png", 0, 0);

        try{
            InputStream is = getClass().getResourceAsStream("Map/"+mapName+".txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int c = 0;
            int r = 0;

            while(c < sizeY && r < sizeX){
                String line = br.readLine();

                while(c < 9) {
                    String values[] = line.split("\\s+");
                    int val = Integer.parseInt(values[c]);

                    mapTiles[c][r] = val;
                    c++;
                }
                if(c == sizeY){
                    c = 0;
                    r++;
                }
            }
            br.close();

            for(int i = 0; i < 9;i++){
                for(int j = 0; j < 9; j++) {

                    Tile tile = new Tile("Tile", floor.getPath(), i, j);
                
                    switch(mapTiles[i][j]) {
                        case 0: tile.setPath(floor.getPath()); break;
                        case 1: tile.setPath(wall.getPath()); break;
                        case 2: tile.setPath(table.getPath()); break;
                        case 3: tile.setPath(cuttingTable.getPath()); break;
                        case 4: tile.setPath(deposit.getPath()); break;
                        case 5: tile.setPath(bin.getPath()); break;
                        case 6: tile.setPath(foodboxClosed.getPath()); break;
                        case 8: tile.setPath(inventory.getPath()); break;
                        case 9: tile.setPath(floor.getPath()); break;
                    }

                    this.tiles[i][j] = tile;
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }  
    }

    public Tile[][] getTiles(){
        return tiles;
    }
}