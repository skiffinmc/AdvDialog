package me.skiffinmc.advdialog.util;

import me.skiffinmc.advdialog.dialog.IDialog;
import org.bukkit.entity.Player;

/**
 * Stores data about the user. A user shouldn't be created until they have
 * entered a dialog box. Object should be deleted once they have exited a
 * dialog box.
 *
 * @author SkiffinMC
 * @since 2018-10-25
 */
public class User {
    private Player player;
    private IDialog dialog;
    private boolean hasDialog;

    public User(Player player)
    {
        this.player = player;
        hasDialog = false;
    }

    public User(Player player, IDialog dialog)
    {
        this.player = player;
        this.dialog = dialog;
        hasDialog = true;
    }

    /**
     * Gets the dialog object being used to generate the dialog
     * @return the dialog object
     */
    public IDialog getDialog() {
        return dialog;
    }

    /**
     * Sets the dialog object being used to generate the dialog
     * @param dialog the dialog object
     */
    public void setDialog(IDialog dialog) {
        this.dialog = dialog;
        hasDialog = true;
    }

    /**
     * The player object that is this user
     * @return the player object
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Does this user have a set dialog
     * @return if dialog is set
     */
    public boolean hasDialog() {
        return hasDialog;
    }
}
