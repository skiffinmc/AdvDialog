package me.skiffinmc.advdialog.command;

import me.skiffinmc.advdialog.dialog.SimpleDialog;
import me.skiffinmc.advdialog.util.UserManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Test implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            player.setLevel(player.getLevel() + 2);
            UserManager.addUser(player, new SimpleDialog());
        }

        return true;
    }
}
