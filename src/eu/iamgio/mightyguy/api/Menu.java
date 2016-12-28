package eu.iamgio.mightyguy.api;

import eu.iamgio.libfx.api.JavaFX;
import eu.iamgio.libfx.api.animations.Animation;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

/**
 * Created by Gio on 29/12/2016.
 */
public class Menu
{
    /**
     * plays the initial animation
     */
    public void playAnimation()
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

    /**
     * applies a simply click effect
     * @param image target image
     */
    public void applyClickEffect(ImageView image)
    {
        image.setFitWidth(image.getFitWidth() - 10);
        image.setFitHeight(image.getFitHeight() - 10);
        image.setTranslateX(image.getTranslateX() + 5);
        image.setTranslateY(image.getTranslateY() + 5);
    }

    /**
     * removes the click effect
     * @param image target image
     */
    public void removeClickEffect(ImageView image)
    {
        image.setFitWidth(image.getFitWidth() + 10);
        image.setFitHeight(image.getFitHeight() + 10);
        image.setTranslateX(image.getTranslateX() - 5);
        image.setTranslateY(image.getTranslateY() - 5);
    }
}
