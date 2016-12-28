package eu.iamgio.mightyguy.game.listeners;

import eu.iamgio.customevents.api.EventHandler;
import eu.iamgio.customevents.api.Listener;
import eu.iamgio.libfx.api.events.mouse.MousePressEvent;
import eu.iamgio.libfx.api.events.mouse.MouseReleaseEvent;
import eu.iamgio.mightyguy.api.Menu;
import eu.iamgio.mightyguy.game.MightyGuy;
import javafx.scene.image.ImageView;

/**
 * Created by Gio on 29/12/2016.
 */
public class ClickListener implements Listener
{
    @EventHandler
    public void onPress(MousePressEvent e)
    {
        if(!MightyGuy.inGame())
            if(e.getMouseEvent().getTarget() instanceof ImageView)
            {
                ImageView image = ((ImageView) e.getMouseEvent().getTarget());

                if(image.getId() == null)
                    return;

                Menu menu = MightyGuy.getMenu();

                if(image.getId().equals("play"))
                {
                    menu.applyClickEffect(image);
                }
                else if(image.getId().equals("shop"))
                {
                    menu.applyClickEffect(image);
                    image.setTranslateX(image.getTranslateX() + 10);
                }
            }
    }

    @EventHandler
    public void onRelease(MouseReleaseEvent e)
    {
        if(!MightyGuy.inGame())
            if(e.getMouseEvent().getTarget() instanceof ImageView)
            {
                ImageView image = ((ImageView) e.getMouseEvent().getTarget());

                if(image.getId() == null)
                    return;

                Menu menu = MightyGuy.getMenu();

                if(image.getId().equals("play"))
                {
                    menu.removeClickEffect(image);
                }
                else if(image.getId().equals("shop"))
                {
                    menu.removeClickEffect(image);
                    image.setTranslateX(image.getTranslateX() - 10);
                }
            }
    }
}
