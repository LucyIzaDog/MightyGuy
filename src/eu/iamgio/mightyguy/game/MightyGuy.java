package eu.iamgio.mightyguy.game;

import eu.iamgio.libfx.api.CSS;
import eu.iamgio.libfx.api.FXML;
import eu.iamgio.libfx.api.elements.SimpleStage;
import eu.iamgio.mightyguy.api.Game;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Gio on 28/12/2016.
 */
public class MightyGuy extends Application
{
    public static SimpleStage stage;

    private static Game game;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXML.load(getClass(), "scenes/MenuScene.fxml");
        Scene scene = new Scene(root, 900, 500);
        CSS.load(getClass(), scene, "stylesheets/styles.css");

        stage = new SimpleStage(primaryStage);
        stage.show(scene, "MightyGuy!", false);
        //TODO icon
    }

    public static void main(String...args)
    {
        launch(args);
    }

    /**
     * @return current game
     */
    public static Game getGame()
    {
        return game;
    }

    /**
     * @return true if there is an active game session
     */
    public static boolean isInGame()
    {
        return game != null;
    }
}
