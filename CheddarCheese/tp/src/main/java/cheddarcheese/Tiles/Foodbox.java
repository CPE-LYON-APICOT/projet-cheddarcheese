package cheddarcheese.Tiles;

import cheddarcheese.Player;
import cheddarcheese.Tomato;

public class Foodbox extends Table implements InteractTile{
    public Foodbox(String label, String path, int x, int y) {
        super(label, path, x, y);
    }

    @Override
    public void interact(Player p) {
        System.out.println("Foodbox");

        if(this.holding == null){
            Tomato tomato = new Tomato(getY(), getX());
            setItem(tomato);
        }
    }
}
