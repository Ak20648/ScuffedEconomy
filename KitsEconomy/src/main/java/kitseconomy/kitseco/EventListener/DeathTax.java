package kitseconomy.kitseco.EventListener;

import kitseconomy.kitseco.KitsEco;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathTax implements Listener {

    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        Player player = e.getEntity();
        Economy eco = KitsEco.getEconomy();
        Double bal = Double.valueOf(eco.getBalance(player));
        Double tax = bal/10;
        eco.withdrawPlayer(player, tax);
    }
}
