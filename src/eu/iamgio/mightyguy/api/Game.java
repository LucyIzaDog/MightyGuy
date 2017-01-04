package eu.iamgio.mightyguy.api;

import eu.iamgio.libfx.api.CSS;
import eu.iamgio.libfx.api.FXML;
import eu.iamgio.libfx.api.JavaFX;
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
    private Scene scene;

    private Character character;
    private int score;
    private Tutorial tutorial;

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

        if(MightyGuy.isFirstGame())
        {
            tutorial = new Tutorial();
            tutorial.show(scene);
            return;
        }

        JavaFX.startDefaultEvents(scene);
        Loop.Manager.start();
    }

    /**
     * ends the game
     */
    public void end()
    {
        //TODO
    }

    /**
     * resets the game
     */
    public void reset()
    {
        //TODO
    }

    /**
     * @return character
     */
    public Character getCharacter()
    {
        return character;
    }

    /**
     * sets the character
     * @param character new character
     */
    void setCharacter(Character character)
    {
        this.character = character;
    }

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
     * @return game scene
     */
    public Scene getScene()
    {
        return scene;
    }

    /**
     * @return current tutorial
     */
    public Tutorial getTutorial()
    {
        return tutorial;
    }
}
