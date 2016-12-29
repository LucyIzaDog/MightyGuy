package eu.iamgio.mightyguy.api;

import eu.iamgio.libfx.api.CSS;
import eu.iamgio.libfx.api.FXML;
import eu.iamgio.libfx.api.JavaFX;
import eu.iamgio.libfx.api.events.Loop;
import eu.iamgio.mightyguy.game.MightyGuy;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Created by Gio on 28/12/2016.
 * Represents the current game
 */
public class Game
{
    public boolean tutorial;
    private Scene scene;

    private Character character;
    private int score;

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
    public void setCharacter(Character character)
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
            showTutorial(scene);
            return;
        }

        JavaFX.startDefaultEvents(scene);
        Loop.Manager.start();
    }

    /**
     * shows the tutorial
     * @param scene scene
     */
    private void showTutorial(Scene scene)
    {
        ImageView image = new ImageView(new Image(MightyGuy.class.getResourceAsStream("assets/game/tutorial.png")));
        image.setFitWidth(900);
        image.setFitHeight(500);
        image.setId("tutorial");

        ((Pane) JavaFX.getRoot()).getChildren().add(image);
        JavaFX.startDefaultEvents(scene);

        tutorial = true;
    }

    /**
     * hides the tutorial
     * @param scene scene
     */
    public void removeTutorial(Scene scene)
    {
        ((Pane) JavaFX.getRoot()).getChildren().remove(JavaFX.fromId("tutorial"));
        Loop.Manager.start();

        tutorial = false;
    }

    /**
     * @return game scene
     */
    public Scene getScene()
    {
        return scene;
    }
}
