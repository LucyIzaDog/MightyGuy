package eu.iamgio.mightyguy.api;

import eu.iamgio.libfx.api.JavaFX;
import eu.iamgio.mightyguy.game.MightyGuy;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;

/**
 * Created by Gio on 29/12/2016.
 * Represents the main character
 */
public class Character
{
    public enum State
    {
        MOVE_RIGHT, MOVE_LEFT,
        JUMP_RIGHT, JUMP_LEFT,
    }

    private State state = State.MOVE_RIGHT;
    private ImageView image;
    private Rectangle hitpoint;

    /**
     * spawns the character
     */
    void spawn()
    {
        image = new ImageView(new Image(MightyGuy.class.getResourceAsStream(
                "assets/game/player/p_move_right.png")));
        image.setTranslateX(70);
        image.setTranslateY(JavaFX.fromId("island_0").getTranslateY() - 90);
        image.setId("char");

        hitpoint = new Rectangle(
                image.getX() + 100, image.getTranslateY() + 92, 5, 5);
        hitpoint.setId("hitpoint");
        hitpoint.setOpacity(0);

        ((Pane) JavaFX.getRoot()).getChildren().addAll(image, hitpoint);

        MightyGuy.getGame().setCharacter(this);
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
     * makes the character jumping to the right
     */
    public void jumpRight()
    {
        setState(State.JUMP_RIGHT);
    }

    /**
     * makes the character jumping to the left
     */
    public void jumpLeft()
    {
        setState(State.JUMP_LEFT);
    }

    /**
     * @return current state
     */
    public State getState()
    {
        return state;
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
            case JUMP_RIGHT:
                image.setImage(new Image(MightyGuy.class.getResourceAsStream(
                        "assets/game/player/p_jump_right.png")));
                break;
            case JUMP_LEFT:
                image.setImage(new Image(MightyGuy.class.getResourceAsStream(
                        "assets/game/player/p_jump_left.png")));
                break;
        }
    }

    /**
     * @return true if the character is on an island
     */
    public boolean isOnGround()
    {
        ImageView island = (ImageView) JavaFX.fromId("island_" + (MightyGuy.getGame().getScore()+1));
        Rectangle islandRectangle = new Rectangle(island.getX(), island.getY(), island.getFitWidth(), island.getFitHeight());
        ((Pane) JavaFX.getRoot()).getChildren().add(islandRectangle);
        return JavaFX.intersects(
                (Rectangle) JavaFX.fromId("hitpoint"), islandRectangle);
    }

    /**
     * @return x
     */
    public double getX()
    {
        return image.getX();
    }

    /**
     * @return y
     */
    public double getY()
    {
        return image.getTranslateY();
    }

    /**
     * sets the x value
     * @param x x coordinate
     */
    public void setX(double x)
    {
        image.setX(x);
        hitpoint.setX(x + 90);
    }

    /**
     * sets the y value
     * @param y y coordinate
     */
    public void setY(double y)
    {
        image.setTranslateY(y);
        hitpoint.setTranslateY(y + 92);
    }
}
