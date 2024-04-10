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
        Foodbox foodbox = new Foodbox("FoodboxClosed", "sprites/foodbox_closed.png", 0, 0);
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
                
                    switch (mapTiles[i][j]) {
                        case 0:
                            tiles[i][j] = new Floor("Floor", floor.getPath(), i, j);
                            break;
                        case 1:
                            tiles[i][j] = new Wall("Wall", wall.getPath(), i, j);
                            break;
                        case 2:
                            tiles[i][j] = new Table("Table", table.getPath(), i, j);
                            break;
                        case 3:
                            tiles[i][j] = new CuttingTable("CuttingTable", cuttingTable.getPath(), i, j);
                            break;
                        case 4:
                            tiles[i][j] = new Deposit("Deposit", deposit.getPath(), i, j);
                            break;
                        case 5:
                            tiles[i][j] = new Bin("Bin", bin.getPath(), i, j);
                            break;
                        case 6:
                            tiles[i][j] = new Foodbox("FoodboxClosed", foodbox.getPath(), i, j);
                            break;
                        case 8:
                            tiles[i][j] = new Inventory("Inventory", inventory.getPath(), i, j);
                            break;
                        case 9:
                            tiles[i][j] = new Floor("Floor", floor.getPath(), i, j);
                            break;
                    }
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