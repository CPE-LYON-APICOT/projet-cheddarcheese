package cheddarcheese.Tiles;

import cheddarcheese.Item;

public interface ItemHolder{
    public void setItem(Item item);
    public Item getItem();
    public Item popItem();
}