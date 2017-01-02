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

            if(game.getTutorial().isActive())
            {
                game.getTutorial().hide(game.getScene());
                return;
            }

            Character character = game.getCharacter();
            KeyCode code = e.getKeyEvent().getCode();

            if(code == KeyCode.W || code == KeyCode.UP || code == KeyCode.SPACE && character.isOnGround())
            {
                if(character.getState() == Character.State.MOVE_RIGHT)
                    character.jumpRight();
                else if(character.getState() == Character.State.MOVE_LEFT)
                    character.jumpLeft();
            }
            else if(code == KeyCode.A || code == KeyCode.LEFT)
            {
                if(!character.isOnGround() && character.getState() == Character.State.FALL_RIGHT)
                {
                    character.fallLeft();
                    return;
                }

                if(!(character.isOnGround() ||
                        character.getState() == Character.State.FALL_RIGHT ||
                        character.getState() == Character.State.FALL_LEFT))
                    return;

                character.setVelocity(character.getVelocity() == 1 ? -1 : character.getVelocity() - 1);
                if(character.getVelocity() <= 0)
                    character.moveLeft();
            }
            else if(code == KeyCode.D || code == KeyCode.RIGHT)
            {
                if(!character.isOnGround() && character.getState() == Character.State.FALL_LEFT)
                {
                    character.fallRight();
                    return;
                }

                if(!(character.isOnGround() ||
                        character.getState() == Character.State.FALL_RIGHT ||
                        character.getState() == Character.State.FALL_LEFT))
                    return;

                character.setVelocity(character.getVelocity() == -1 ? 1 : character.getVelocity() + 1);
                if(character.getVelocity() >= 0)
                    character.moveRight();
            }
        }
    }
}
