package eu.iamgio.mightyguy.game.listeners;

import eu.iamgio.customevents.api.EventHandler;
import eu.iamgio.customevents.api.Listener;
import eu.iamgio.libfx.api.events.Loop;
import eu.iamgio.mightyguy.api.Character;
import eu.iamgio.mightyguy.api.Game;
import eu.iamgio.mightyguy.game.MightyGuy;

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

        if(character.isOnGround())
        {
            switch(character.getState())
            {
                case FALL_RIGHT:
                    character.moveRight();
                    break;
                case FALL_LEFT:
                    character.moveLeft();
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
    }
}
