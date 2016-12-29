package eu.iamgio.mightyguy.api;

import eu.iamgio.libfx.api.JavaFX;
import eu.iamgio.mightyguy.game.MightyGuy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

/**
 * Created by Gio on 29/12/2016.
 * Represents the main character
 */
public class Character
{
    /**
     * spawns the character
     */
    public void spawn()
    {
        ImageView image = new ImageView(new Image(MightyGuy.class.getResourceAsStream(
                "assets/game/player/p_stand.png")));
        image.setTranslateX(70);
        image.setTranslateY(JavaFX.fromId("island_0").getTranslateY() - 90);
        image.setId("char");
        ((Pane) JavaFX.getRoot()).getChildren().add(image);
    }
}
