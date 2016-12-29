package eu.iamgio.mightyguy.api;

import eu.iamgio.libfx.api.JavaFX;
import eu.iamgio.mightyguy.game.MightyGuy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Random;

/**
 * Created by Gio on 29/12/2016.
 * Represents an island
 */
public class Island
{
    /**
     * spawns an island randomly
     */
    public void spawn()
    {
        int score = MightyGuy.getGame().getScore();
        final int BOUND_UP = 75;
        final int BOUND_DOWN = 450;

        if(score == 0)
        {
            ImageView image = new ImageView(new Image(MightyGuy.class.getResourceAsStream("assets/game/island.png")));
            image.setTranslateX(50);

            int y = new Random().nextInt(BOUND_DOWN);
            while(y < BOUND_UP)
                y = new Random().nextInt(BOUND_DOWN);

            image.setTranslateY(y);
            image.setId("island_" + score);
            ((Pane) JavaFX.getRoot()).getChildren().add(image);
            System.out.println(y);
        }

        ImageView image = new ImageView(new Image(MightyGuy.class.getResourceAsStream("assets/game/island.png")));
        image.setTranslateX(650);

        int y = new Random().nextInt(BOUND_DOWN);
        while(y < BOUND_UP)
            y = new Random().nextInt(BOUND_DOWN);

        image.setTranslateY(y);
        image.setId("island_" + score + 1);
        ((Pane) JavaFX.getRoot()).getChildren().add(image);
    }
}
