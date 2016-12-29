package eu.iamgio.mightyguy.game;

import eu.iamgio.customevents.api.EventManager;
import eu.iamgio.libfx.api.CSS;
import eu.iamgio.libfx.api.FXML;
import eu.iamgio.libfx.api.JavaFX;
import eu.iamgio.libfx.api.elements.SimpleStage;
import eu.iamgio.mightyguy.api.Game;
import eu.iamgio.mightyguy.api.Menu;
import eu.iamgio.mightyguy.game.listeners.MenuClickListener;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Gio on 28/12/2016.
 */
public class MightyGuy extends Application
{
    public static final String VERSION = "1.0.0";

    public static SimpleStage stage;

    private static boolean firstGame;

    private static Game game;
    private static Menu menu;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        Parent root = FXML.load(getClass(), "scenes/MenuScene.fxml");
        Scene scene = new Scene(root, 900, 500);
        CSS.load(getClass(), scene, "stylesheets/styles.css");

        stage = new SimpleStage(primaryStage);
        stage.show(scene, "MightyGuy! v" + VERSION + " - by iAmGio", false);
        //TODO icon

        JavaFX.startDefaultEvents(scene);
        startEvents();

        menu = new Menu();
        menu.playAnimation();
    }

    private void startEvents()
    {
        EventManager manager = JavaFX.getEventManager();

        manager.registerEvents(new MenuClickListener());
    }

    public static void main(String...args)
    {
        launch(args);
    }

    /**
     * @return current game
     */
    public static Game getGame()
    {
        return game;
    }

    /**
     * creates the game
     */
    public static void createGame()
    {
        game = new Game();
    }

    /**
     * ends the game
     */
    public static void endGame()
    {
        game = null;
    }

    /**
     * @return true if there is an active game session
     */
    public static boolean inGame()
    {
        return game != null;
    }

    /**
     * @return current menu
     */
    public static Menu getMenu()
    {
        return menu;
    }

    /**
     * sets the menu
     * @param menu new menu
     */
    public static void setMenu(Menu menu)
    {
        MightyGuy.menu = menu;
    }

    /**
     * @return true if this is the first game
     */
    public static boolean isFirstGame()
    {
        return firstGame;
    }

    /**
     * sets the first game
     * @param firstGame new first game value
     */
    public static void setFirstGame(boolean firstGame)
    {
        MightyGuy.firstGame = firstGame;
    }
}
