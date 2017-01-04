package eu.iamgio.mightyguy.game.listeners;

import eu.iamgio.customevents.api.EventHandler;
import eu.iamgio.customevents.api.Listener;
import eu.iamgio.libfx.api.JavaFX;
import eu.iamgio.libfx.api.events.Loop;
import eu.iamgio.mightyguy.api.Character;
import eu.iamgio.mightyguy.api.Game;
import eu.iamgio.mightyguy.api.Island;
import eu.iamgio.mightyguy.game.MightyGuy;
import javafx.scene.image.ImageView;

/**
 * Created by Gio on 30/12/2016.
 */
public class LoopListener implements Listener
{
    private double initY = 0;

    @EventHandler
    public void loop(Loop loop) throws InterruptedException
    {
        Game game = MightyGuy.getGame();
        Character character = game.getCharacter();

        character.move();

        JavaFX.getRoot().getChildrenUnmodifiable().forEach(node ->
        {
            if(node.getTranslateX() > -500)
                if(node instanceof ImageView)
                    if(((ImageView) node).getImage().getHeight() == 53)
                        node.setTranslateX(node.getTranslateX() - (game.getScore() + 1.2) / 3);
        });

        /*if(character.hitsIsland())
        {
            switch(character.getState())
            {
                case FALL_RIGHT:
                case JUMP_RIGHT:
                case MOVE_RIGHT:
                    character.fallLeft();
                    break;
                case FALL_LEFT:
                case JUMP_LEFT:
                case MOVE_LEFT:
                    character.fallRight();
                    break;
            }

            return;
        }*/

        if(character.isOnGround())
        {
            switch(character.getState())
            {
                case FALL_RIGHT:
                    character.moveRight();
                    character.setVelocity(1);
                    break;
                case FALL_LEFT:
                    character.moveLeft();
                    character.setVelocity(-1);
                    break;
            }
        }
        else
        {
            switch(character.getState())
            {
                case MOVE_RIGHT:
                    character.fallRight();
                    break;
                case MOVE_LEFT:
                    character.fallLeft();
                    break;
            }
        }

        if(character.isOnNewIsland())
        {
            game.setScore(game.getScore() + 1);
            new Island().spawn();
        }
    }
}
