package kitseconomy.kitseco;

import kitseconomy.kitseco.Commands.BalanceCommand;
import kitseconomy.kitseco.EventListener.DeathTax;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class KitsEco extends JavaPlugin {

    public static Economy eco = null;

    @Override
    public void onEnable() {
        if(!hasEconomy()){
            System.out.println(ChatColor.RED + "This plugin requires vault!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        getCommand("balance").setExecutor(new BalanceCommand());
        getServer().getPluginManager().registerEvents(new DeathTax(), this);



    }

    @Override
    public void onDisable() {
        System.out.println("KitsEco is now disabled");
    }

    private boolean hasEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null){
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);

        if(rsp == null){
            return false;
        }

        eco = rsp.getProvider();

        return eco != null;
    }

    public static Economy getEconomy() {
        return eco;
    }
}
