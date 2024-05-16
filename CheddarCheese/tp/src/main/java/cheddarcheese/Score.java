package cheddarcheese;

import java.util.Observable;

import cheddarcheese.Foods.Interfaces.Recette;

public class Score extends Observable {
    private static Score instance;
    private int score;
    private int recipesCount;

    public int getScore() {
        return score;
    }

    private Score() {

    };

    public static Score getInstance() {

        if (instance == null) {
            instance = new Score();
        }

        return instance;
    }

    public void augmenterScore(int scoreEnPlus) {
        this.score += scoreEnPlus;

        this.setChanged();
        this.notifyObservers(instance);
    }

    public void finirRecette(Recette curRecipe) {
        augmenterScore(100+40*curRecipe.ingredients().length);
        this.recipesCount++;

        if (this.recipesCount % 3 == 0) {
            augmenterScore(50);
        }
    }
}
