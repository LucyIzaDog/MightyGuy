package eu.iamgio.mightyguy.api;

import eu.iamgio.libfx.api.JavaFX;
import eu.iamgio.libfx.api.events.Loop;
import eu.iamgio.mightyguy.game.MightyGuy;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Created by Gio on 29/12/2016.
 * Represents the initial tutorial screen
 */
public class Tutorial
{
    private boolean active;

    /**
     * shows the tutorial
     * @param scene scene
     */
    void show(Scene scene)
    {
        ImageView image = new ImageView(new Image(MightyGuy.class.getResourceAsStream("assets/game/tutorial.png")));
        image.setFitWidth(900);
        image.setFitHeight(500);
        image.setId("tutorial");

        ((Pane) JavaFX.getRoot()).getChildren().add(image);

        JavaFX.startDefaultEvents(scene);

        active = true;
    }

    /**
     * hides the tutorial
     * @param scene scene
     */
    public void hide(Scene scene)
    {
        ((Pane) JavaFX.getRoot()).getChildren().remove(JavaFX.fromId("tutorial"));

        Loop.Manager.start();

        active = false;
    }

    /**
     * @return true if the tutorial is active
     */
    public boolean isActive()
    {
        return active;
    }
}
