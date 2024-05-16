package cheddarcheese;

import java.util.Observable;

import cheddarcheese.Foods.Interfaces.Recette;
import javafx.scene.text.Text;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.io.InputStream;

public class Score extends Observable {
    private static Score instance;
    private int score;
    private int recipesCount;
    private Text visual;

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

        this.visual.setText(String.valueOf(score));

        this.setChanged();
        this.notifyObservers(instance);

        String soundFile = "music/coin.wav";
        InputStream inputStream = getClass().getResourceAsStream(soundFile);
    
        if (inputStream != null) {
            try {
                String url = getClass().getResource(soundFile).toURI().toString();
    
                Media sound = new Media(url);
                MediaPlayer mediaPlayer = new MediaPlayer(sound);
                mediaPlayer.play();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            System.err.println("Failed to load sound file: " + soundFile);
        }
    }

    public void finirRecette(Recette curRecipe) {
        augmenterScore(100+40*curRecipe.ingredients().length);
        this.recipesCount++;

        if (this.recipesCount % 3 == 0) {
            augmenterScore(50);
        }
    }

    public void setTextVisual(Text textVisual) {
        this.visual = textVisual;
    }
}
