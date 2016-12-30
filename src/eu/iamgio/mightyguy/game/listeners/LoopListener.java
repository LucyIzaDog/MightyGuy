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
    @EventHandler
    public void loop(Loop loop)
    {
        Game game = MightyGuy.getGame();
        Character character = game.getCharacter();

        switch(character.getState())
        {
            case MOVE_RIGHT:
                character.setX(character.getX() + 5);
                break;
            case MOVE_LEFT:
                character.setX(character.getX() - 5);
                break;
        }
    }
}
