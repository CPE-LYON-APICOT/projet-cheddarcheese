package cheddarcheese;

abstract public class Item {
    int xPos;
    int yPos;
    String name;
    
    public Item(int xPos, int yPos, String name) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.name = name;
    }

    public int getXPos() {
        return this.xPos;
    }

    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    public int getYPos() {
        return this.yPos;
    }

    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item xPos(int xPos) {
        setXPos(xPos);
        return this;
    }

    public Item yPos(int yPos) {
        setYPos(yPos);
        return this;
    }

    public Item name(String name) {
        setName(name);
        return this;
    }
}
