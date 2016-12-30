package eu.iamgio.mightyguy.api;

import eu.iamgio.libfx.api.JavaFX;
import eu.iamgio.mightyguy.game.MightyGuy;
import javafx.scene.Node;
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
        FALL_RIGHT, FALL_LEFT
    }

    private State state = State.MOVE_RIGHT;
    private ImageView image;
    private Rectangle hitpoint;
    private int velocity = 1;

    private double jumpStartX, jumpStartY;

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
     * @return velocity
     */
    public int getVelocity()
    {
        return velocity;
    }

    /**
     * sets the velocity
     * @param velocity new velocity
     */
    public void setVelocity(int velocity)
    {
        this.velocity = velocity;
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
     * makes the character falling to the right
     */
    public void fallRight()
    {
        setState(State.FALL_RIGHT);
    }

    /**
     * makes the character falling to the left
     */
    public void fallLeft()
    {
        setState(State.FALL_LEFT);
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

        final String PLAYER_ASSETS = "assets/game/player/";

        switch(state)
        {
            case MOVE_RIGHT:
                image.setImage(new Image(MightyGuy.class.getResourceAsStream(
                        PLAYER_ASSETS + "p_move_right.png")));
                break;
            case MOVE_LEFT:
                image.setImage(new Image(MightyGuy.class.getResourceAsStream(
                        PLAYER_ASSETS + "p_move_left.png")));
                break;
            case JUMP_RIGHT:
                image.setImage(new Image(MightyGuy.class.getResourceAsStream(
                        PLAYER_ASSETS + "p_jump_right.png")));
                break;
            case JUMP_LEFT:
                image.setImage(new Image(MightyGuy.class.getResourceAsStream(
                        PLAYER_ASSETS + "p_jump_left.png")));
                break;
            case FALL_RIGHT:
                image.setImage(new Image(MightyGuy.class.getResourceAsStream(
                        PLAYER_ASSETS + "p_fall_right.png")));
                break;
            case FALL_LEFT:
                image.setImage(new Image(MightyGuy.class.getResourceAsStream(
                        PLAYER_ASSETS + "p_fall_left.png")));
                break;
        }
    }

    /**
     * moves the character
     */
    private double y = 1;
    public void move()
    {
        int vel = Math.abs(velocity);

        if(vel == 0)
            return;

        switch(getState())
        {
            case MOVE_RIGHT:
                setX(getX() + 5 * vel);
                break;
            case MOVE_LEFT:
                setX(getX() - 5 * vel);
                break;
            case JUMP_RIGHT:
                if(y == 50 / vel)
                {
                    fallRight();
                    break;
                }
                setX(getX() + 5 * vel);
                setY(getY() - 8 / vel);
                y += 1;
                break;
            case JUMP_LEFT:
                if(y == 50 / vel)
                {
                    fallLeft();
                    break;
                }
                setX(getX() - 5 * vel);
                setY(getY() - 8 / vel);
                y += 1;
                break;
            case FALL_RIGHT:
                y = 0;
                setX(getX() + 5);
                setY(getY() + 5);
                break;
            case FALL_LEFT:
                y = 0;
                setX(getX() - 5);
                setY(getY() + 5);
                break;
        }

    }

    /**
     * @return true if the character is on an island
     */
    public boolean isOnGround()
    {
        for(Node n : JavaFX.getSceneElements())
            if(n.getId() != null && n.getId().startsWith("island"))
            {
                Rectangle islandRectangle = new Rectangle(n.getTranslateX(), n.getTranslateY(), 157, 53);

                if(JavaFX.intersects((Rectangle) JavaFX.fromId("hitpoint"), islandRectangle))
                    return true;
            }

        return false;
    }

    /**
     * @return true if the character is on the next island
     */
    public boolean isOnNewIsland()
    {
        ImageView island = (ImageView) JavaFX.fromId("island_" + (MightyGuy.getGame().getScore()+1));
        Rectangle islandRectangle = new Rectangle(
                island.getTranslateX(), island.getTranslateY(), 157, 53);
        return JavaFX.intersects(
                (Rectangle) JavaFX.fromId("hitpoint"), islandRectangle);
    }

    /**
     * @return true if the character hits an island
     */
    public boolean hitsIsland()
    {
        Rectangle playerRectangle = new Rectangle(
                image.getX(), image.getTranslateY(), 66, 85);

        for(Node n : JavaFX.getSceneElements())
            if(n.getId() != null && n.getId().startsWith("island"))
            {
                Rectangle islandRectangle = new Rectangle(
                        n.getTranslateX(), n.getTranslateY(), 157, 53);

                if(JavaFX.intersects(playerRectangle, islandRectangle))
                    return true;
            }

        return false;
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
