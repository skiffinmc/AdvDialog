package me.skiffinmc.advdialog.util;

import me.skiffinmc.advdialog.dialog.IDialog;
import org.bukkit.entity.Player;
import org.yaml.snakeyaml.events.Event;

import java.util.Map;
import java.util.HashMap;
import java.util.UUID;

/**
 * Manager class to manage the user that are currently in dialog.
 * Users are added to the list when they enter dialog and removed
 * when they exit.
 *
 * @author SkiffinMC
 * @since 2018-10-25
 */
public class UserManager {

    private static Map<UUID, User> users = new HashMap<>();

    /**
     * Gets the list of users in dialog
     * @return list of users
     */
    public static Map<UUID, User> getUsers() {
        return users;
    }

    /**
     * Adds a user to the list
     * @param player the player to add
     * @return if it was successful
     */
    public static boolean addUser(Player player) {
        if (users.containsKey(player.getUniqueId())) {
            return false;
        }

        users.put(player.getUniqueId(), new User(player));

        return true;
    }

    /**
     * Adds a user to the list with a dialog
     * @param player the player to add
     * @param dialog the dialog to add
     * @return if it was successful
     */
    public static boolean addUser(Player player, IDialog dialog) {
        if (users.containsKey(player.getUniqueId())) {
            return false;
        }

        users.put(player.getUniqueId(), new User(player, dialog));

        return true;
    }

    /**
     * Removes a user from the list
     * @param player the player to remove
     * @return if it was successful
     */
    public static boolean removeUser(Player player) {
        if (!users.containsKey(player.getUniqueId())) {
            return false;
        }

        users.remove(player.getUniqueId());

        return true;
    }

    /**
     * Gets the user object by the UUID
     * @param id the uuid to search for
     * @return the user object
     */
    public static User getUser(UUID id) {
        return users.get(id);
    }

    /**
     * Does the user list have the specified player
     * @param id the UUID of the player
     * @return is the player in the list
     */
    public static boolean containsUser(UUID id) {
        return users.containsKey(id);
    }
}
