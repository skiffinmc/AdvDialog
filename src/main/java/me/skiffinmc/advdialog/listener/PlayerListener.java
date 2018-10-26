package me.skiffinmc.advdialog.listener;

import me.skiffinmc.advdialog.util.User;
import me.skiffinmc.advdialog.util.UserManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Listens to events that are relevant to the player.
 *
 * @author SkiffinMC
 * @since 2018-10-25
 */
public class PlayerListener implements Listener {

    /**
     * Player chat event is called when a player sends a message.
     * The message will be cancelled if they are in a dialog and
     * will be sent to the dialog object instead. This way people
     * who are not in the dialog will not see the message.
     * It will also remove all recipients that are currently in
     * dialog so they do not receive the message.
     *
     * @param e the asynchronous player chat event
     */
    @EventHandler(priority = EventPriority.NORMAL)
    public void onPlayerChatEvent(AsyncPlayerChatEvent e) {
        Player p = e.getPlayer();

        if (!UserManager.containsUser(p.getUniqueId())) {
            for (User user : UserManager.getUsers().values()) {
                e.getRecipients().remove(user.getPlayer());
            }
        } else {
            e.setCancelled(true);
            User user = UserManager.getUser(p.getUniqueId());

            if (user.hasDialog()) {
                user.getDialog().sendInput(e.getMessage());
            }
        }
    }
}
