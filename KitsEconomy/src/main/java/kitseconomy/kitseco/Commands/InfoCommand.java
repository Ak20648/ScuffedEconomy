package kitseconomy.kitseco.Commands;

import kitseconomy.kitseco.KitsEco;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InfoCommand implements CommandExecutor {
    static KitsEco plugin;

    public InfoCommand(KitsEco main) {
        plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (args.length == 0) {
                player.sendMessage("just a bad economy plugin.");
            }
        }
        return false;
    }

}
