package kitseconomy.kitseco.EventListener;

import kitseconomy.kitseco.KitsEco;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class NewPlayer implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        Player player = (Player) e.getPlayer();
        Economy eco = KitsEco.getEconomy();
        double startingFee = 500;
        if (!player.hasPlayedBefore()){
            eco.depositPlayer(player, startingFee);
        }
    }
}
