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
class Island
{
    /**
     * spawns an island randomly
     */
    void spawn()
    {
        int score = MightyGuy.getGame().getScore();

        final int BOUND_LEFT = 300;
        final int BOUND_RIGHT = 800;

        final int BOUND_UP = 75;
        final int BOUND_DOWN = 450;

        if(score == 0)
        {
            ImageView image = new ImageView(new Image(MightyGuy.class.getResourceAsStream("assets/game/island.png")));
            image.setTranslateX(50);

            int y = new Random().nextInt(BOUND_DOWN - BOUND_UP) + BOUND_UP;

            image.setTranslateY(y);
            image.setId("island_0");
            ((Pane) JavaFX.getRoot()).getChildren().add(image);
        }

        ImageView image = new ImageView(new Image(MightyGuy.class.getResourceAsStream("assets/game/island.png")));

        int x = new Random().nextInt(BOUND_RIGHT - BOUND_LEFT) + BOUND_LEFT;
        int y = new Random().nextInt(BOUND_DOWN - BOUND_UP) + BOUND_UP;

        image.setTranslateX(x);
        image.setTranslateY(y);
        image.setId("island_" + (score + 1));
        ((Pane) JavaFX.getRoot()).getChildren().add(image);

        while(Math.abs(JavaFX.fromId("island_" + score).getTranslateY() - image.getTranslateY()) > 300)
        {
            y = new Random().nextInt(BOUND_DOWN - BOUND_UP) + BOUND_UP;
            image.setTranslateY(y);
        }
    }
}
