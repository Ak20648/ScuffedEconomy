package kitseconomy.kitseco;

import kitseconomy.kitseco.Commands.BalanceCommand;
import kitseconomy.kitseco.Commands.InfoCommand;
import kitseconomy.kitseco.EventListener.DeathTax;
import kitseconomy.kitseco.EventListener.NewPlayer;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.ChatColor;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public final class KitsEco extends JavaPlugin {

    public static Economy econ = null;

    @Override
    public void onEnable() {
        if(!hasEconomy()){
            System.out.println(ChatColor.RED + "This plugin requires vault!");
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
        getCommand("balance").setExecutor(new BalanceCommand(this));
        getCommand("info").setExecutor(new InfoCommand(this));
        getServer().getPluginManager().registerEvents(new DeathTax(this), this);
        getServer().getPluginManager().registerEvents(new NewPlayer(this), this);



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

        econ = rsp.getProvider();

        return econ != null;
    }

    public static Economy getEconomy() {
        return econ;
    }
}
