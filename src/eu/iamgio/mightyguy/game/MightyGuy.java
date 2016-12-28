package eu.iamgio.mightyguy.game;

import eu.iamgio.libfx.api.CSS;
import eu.iamgio.libfx.api.FXML;
import eu.iamgio.libfx.api.JavaFX;
import eu.iamgio.libfx.api.animations.Animation;
import eu.iamgio.libfx.api.elements.SimpleStage;
import eu.iamgio.mightyguy.api.Game;
import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

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

        playInitialAnimation();
    }

    private void playInitialAnimation()
    {
        Node title = JavaFX.fromId("title_img");
        title.setTranslateY(title.getTranslateY() + 600);
        new Animation(Animation.Type.MOVEMENT_Y, title.getTranslateY() - 600, Duration.seconds(1), false)
                .play(title);
        title.setOpacity(0);
        new Animation(Animation.Type.FADE, 1, Duration.seconds(1), false)
                .play(title);

        Node play = JavaFX.fromId("play");
        play.setOpacity(0);
        new Animation(Animation.Type.FADE, 1, Duration.seconds(1.5), false)
                .play(play);

        Node shop = JavaFX.fromId("shop");
        shop.setOpacity(0);
        new Animation(Animation.Type.FADE, 1, Duration.seconds(1.5), false)
                .play(shop);
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
