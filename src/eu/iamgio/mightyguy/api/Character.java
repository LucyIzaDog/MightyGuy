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
    public enum State
    {
        MOVE_RIGHT,
        MOVE_LEFT,
        JUMP,
    }

    private State state;
    private ImageView image;

    /**
     * spawns the character
     */
    public void spawn()
    {
        image = new ImageView(new Image(MightyGuy.class.getResourceAsStream(
                "assets/game/player/p_move_right.png")));
        image.setTranslateX(70);
        image.setTranslateY(JavaFX.fromId("island_0").getTranslateY() - 90);
        image.setId("char");
        ((Pane) JavaFX.getRoot()).getChildren().add(image);

        MightyGuy.getGame().setCharacter(this);
    }

    /**
     * @return current state
     */
    public State getState()
    {
        return state;
    }

    /**
     * moves the character to the right
     */
    public void moveRight()
    {
        setState(State.MOVE_RIGHT);
    }

    /**
     * moves the character to the left
     */
    public void moveLeft()
    {
        setState(State.MOVE_LEFT);
    }

    /**
     * makes the character jumping
     */
    public void jump()
    {
        setState(State.JUMP);
    }

    /**
     * sets the state
     * @param state new state
     */
    private void setState(State state)
    {
        this.state = state;

        switch(state)
        {
            case MOVE_RIGHT:
                image.setImage(new Image(MightyGuy.class.getResourceAsStream(
                        "assets/game/player/p_move_right.png")));
                break;
            case MOVE_LEFT:
                image.setImage(new Image(MightyGuy.class.getResourceAsStream(
                        "assets/game/player/p_move_left.png")));
                break;
            case JUMP:
                image.setImage(new Image(MightyGuy.class.getResourceAsStream(
                        "assets/game/player/p_jump.png")));
                break;
        }
    }
}
