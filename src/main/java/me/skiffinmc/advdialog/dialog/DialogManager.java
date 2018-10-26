package me.skiffinmc.advdialog.dialog;

import me.skiffinmc.advdialog.dialog.storage.DialogData;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * Manager class to manage the dialogs that are currently occurring.
 * Dialogs are added to the list when they begin and removed when they
 * are finished. They are stored in a map and they keys are the UUID
 * of the player interacting with the dialog.
 *
 * @author SkiffinMC
 * @since 2018-10-25
 */
public class DialogManager {

    private static Plugin plugin;

    private static Map<UUID, Dialog> dialogs = new HashMap<>();

    /**
     * Initializes the dialog manager, this must be done before
     * you load a dialog from json
     * @param plugin the plugin
     */
    public static void initialize(Plugin plugin) {
        DialogManager.plugin = plugin;
    }

    /**
     * Gets the list of dialogs
     * @return list of dialogs
     */
    public static Map<UUID, Dialog> getDialogs() {
        return dialogs;
    }

    /**
     * Adds a dialog to the list
     * @param player the player in the dialog
     */
    public static void addDialog(Player player, DialogData dialogData) {
        dialogs.put(player.getUniqueId(), new Dialog(player, dialogData));
    }

    /**
     * Removes a dialog from the list
     * @param player the player in the dialog
     * @return if it was successful
     */
    public static boolean removeDialog(Player player) {
        if (!dialogs.containsKey(player.getUniqueId())) {
            return false;
        }

        dialogs.remove(player.getUniqueId());

        return true;
    }

    /**
     * Gets the user object by the UUID
     * @param id the uuid to search for
     * @return the user object
     */
    public static Dialog getPlayerDialog(UUID id) {
        return dialogs.get(id);
    }

    /**
     * Does the dialog list have the specified player
     * @param id the UUID of the player
     * @return is the player in the list
     */
    public static boolean isUserInDialog(UUID id) {
        return dialogs.containsKey(id);
    }


}
