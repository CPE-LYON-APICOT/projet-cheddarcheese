package cheddarcheese.Tiles;

import cheddarcheese.Item;

public class Inventory extends Tile implements ItemHolder{
    Item holding;

    public Inventory(String label, String path, int x, int y) {
        super(label, path, x, y);
    }

    public void setItem(Item item){
        holding = item;
    }

    public Item getItem(){
        return holding;
    }

    public Item popItem(){
        Item returning = holding;
        holding = null;
        return returning;
    }

    public void deleteItem(){
        holding.removeImg();
        holding = null;
    }
}