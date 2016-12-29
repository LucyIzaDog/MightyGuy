package eu.iamgio.mightyguy.api;

import eu.iamgio.libfx.api.CSS;
import eu.iamgio.libfx.api.FXML;
import eu.iamgio.libfx.api.events.Loop;
import eu.iamgio.mightyguy.game.MightyGuy;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Created by Gio on 28/12/2016.
 * Represents the current game
 */
public class Game
{
    private int score;

    /**
     * @return score
     */
    public int getScore()
    {
        return score;
    }

    /**
     * sets the score
     * @param score new score
     */
    public void setScore(int score)
    {
        this.score = score;
    }

    /**
     * starts the game
     */
    public void start()
    {
        Parent root = FXML.load(MightyGuy.class, "scenes/GameScene.fxml");
        Scene scene = new Scene(root, 900, 500);
        CSS.load(MightyGuy.class, scene, "stylesheets/styles.css");

        new Island().spawn();
        new Character().spawn();

        MightyGuy.stage.show(scene, "MightyGuy! v" + MightyGuy.VERSION + " - by iAmGio", false);

        Loop.Manager.start();
    }
}
