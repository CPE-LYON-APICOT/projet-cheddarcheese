package cheddarcheese;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class GameMap {
    private int tiles[][];

    public GameMap() {
    }

    public void loadMap(String mapName){
        try{
            InputStream is = getClass().getResourceAsStream("/map/"+mapName+".txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int c = 0;
            int r = 0;

            while(c < 9 && r < 9){
                String line = br.readLine();

                while(c < 9) {
                    String values[] = line.split("  ");

                    int val = Integer.parseInt(values[c]);

                    tiles[c][r] = val;
                    c++;
                }
                if(c == 9){
                    c = 0;
                    r++;
                }
            }
            br.close();
        } catch(Exception e) {

        }  
    }

    public int[][] getTiles(){
        return tiles;
    }
    
}
