package eu.iamgio.mightyguy.game.listeners;

import eu.iamgio.customevents.api.EventHandler;
import eu.iamgio.customevents.api.Listener;
import eu.iamgio.libfx.api.events.KeyPressEvent;
import eu.iamgio.mightyguy.api.Character;
import eu.iamgio.mightyguy.api.Game;
import eu.iamgio.mightyguy.game.MightyGuy;
import javafx.scene.input.KeyCode;

/**
 * Created by Gio on 29/12/2016.
 */
public class KeyListener implements Listener
{
    @EventHandler
    public void onKeyPress(KeyPressEvent e)
    {
        if(MightyGuy.inGame())
        {
            Game game = MightyGuy.getGame();

            if(game.tutorial)
            {
                game.removeTutorial(game.getScene());
                return;
            }

            Character character = game.getCharacter();
            KeyCode code = e.getKeyEvent().getCode();

            if(code == KeyCode.W || code == KeyCode.UP || code == KeyCode.SPACE)
                character.jump();
            else if(code == KeyCode.A || code == KeyCode.LEFT)
                character.moveLeft();
            else if(code == KeyCode.D || code == KeyCode.RIGHT)
                character.moveRight();
        }
    }
}
