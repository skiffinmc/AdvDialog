package me.skiffinmc.advdialog.dialog;

import me.skiffinmc.advdialog.dialog.storage.DialogData;
import org.bukkit.entity.Player;

/**
 * Stores data about the dialog.
 *
 * @author SkiffinMC
 * @since 2018-10-25
 */
public class Dialog {
    private Player player;
    private DialogData data;
    private String currentNodeId;

    Dialog(Player player, DialogData dialogData) {
        this.player = player;
        data = dialogData;
    }

    /**
     * The player object that is this user
     * @return the player object
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Sends the users input to the dialog.
     * @param input the users input
     */
    public void sendInput(String input) {
        processInput(input);
    }

    /**
     * Processes the input
     * @param input the users input
     */
    private void processInput(String input) {

    }
}
