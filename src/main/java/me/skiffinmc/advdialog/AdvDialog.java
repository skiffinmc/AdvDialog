package me.skiffinmc.advdialog;

import me.skiffinmc.advdialog.command.Test;
import me.skiffinmc.advdialog.listener.PlayerListener;
import me.skiffinmc.advdialog.util.UserManager;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created to be apart of the AdvSuite which will
 * be a group of plugins that power AdvCore. A highly
 * customizable spigot questing API. Each component in
 * the suite also forms a fully standalone plugin API.
 * <p>
 * AdvDialog is a lightweight dialog creation system. A dialog
 * is just a state in the chat where all messages are muted and
 * the player is prompted to do somethings.
 * <p>
 * What happens in the dialog box is completely up the the server
 * owner or programmer. Some possible examples may include: character
 * creation, quest dialog, surveys, etc..
 *
 * @author SkiffinMC
 * @since 2018-10-24
 */
public class AdvDialog extends JavaPlugin {

    private static UserManager userManager = new UserManager();

    @Override
    public void onEnable() {
        PluginManager pm = getServer().getPluginManager();

        registerListeners(pm);
        registerCommands();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

    /**
     * Register listeners
     * @param pm plugin manager
     */
    public void registerListeners(PluginManager pm) {
        pm.registerEvents(new PlayerListener(), this);
    }

    /**
     * Registers commands
     */
    public void registerCommands() {
        this.getCommand("test").setExecutor(new Test());
    }
}
