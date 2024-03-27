package cheddarcheese;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class GameMap {
    int tiles[][];

    public GameMap() {
    }

    public void loadMap(String mapName){
        try {
            String filePath = "Map/" + mapName + ".txt";
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            int rows = Integer.parseInt(scanner.nextLine());
            int columns = Integer.parseInt(scanner.nextLine());

            tiles = new int[rows][columns];

            for (int i = 0; i < rows; i++) {
                String[] rowData = scanner.nextLine().split("   ");
                for (int j = 0; j < columns; j++) {
                    tiles[i][j] = Integer.parseInt(rowData[j]);
                }
            }

            scanner.close();

        } catch (FileNotFoundException e) {
            System.out.println("Error: Map file not found.");
            e.printStackTrace();

        } catch (NumberFormatException e) {
            System.out.println("Error: Invalid map data format.");
            e.printStackTrace();

        }
    }
    
}
