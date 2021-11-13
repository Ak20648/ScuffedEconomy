package kitseconomy.kitseco.Commands;

import kitseconomy.kitseco.KitsEco;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BalanceCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){

        if (sender instanceof Player){
            Player player = (Player) sender;
            Economy eco = KitsEco.getEconomy();

            if (args.length == 0){
                player.sendMessage(String.format(ChatColor.GREEN + "Balance: " + ChatColor.GREEN + eco.getBalance(player)));
            }
        }
        return false;
    }
}
