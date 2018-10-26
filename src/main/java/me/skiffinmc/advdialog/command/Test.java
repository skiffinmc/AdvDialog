package me.skiffinmc.advdialog.command;

import me.skiffinmc.advdialog.AdvDialog;
import me.skiffinmc.advdialog.dialog.DialogManager;
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


            DialogManager.addDialog(player, AdvDialog.data);
        }

        return true;
    }
}
