package kitseconomy.kitseco.Commands;

import kitseconomy.kitseco.KitsEco;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BalanceCommand implements CommandExecutor {

    static KitsEco plugin;
    Economy economy = KitsEco.getEconomy();

    public BalanceCommand(KitsEco main) {
        plugin = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        if (sender instanceof Player){
            Player player = (Player) sender;
            if (args.length == 0){
                player.sendMessage(String.format(ChatColor.GREEN + "Balance: " + ChatColor.GREEN + economy.getBalance(player)));
            }
        }
        return false;
    }
}
