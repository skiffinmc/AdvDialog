package me.skiffinmc.advdialog.event;

import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class PlayerExitDialogEvent extends Event {

    private static final HandlerList handlers = new HandlerList();
    private Player player;
    private boolean cancelled;

    public PlayerExitDialogEvent(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setCancelled(boolean cancel) {
        cancelled = cancel;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
}
