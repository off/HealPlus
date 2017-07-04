package com.glenjendary.healplus;

/* HealPlus Created} by Glenjendary on 4/07/2017. */

import com.glenjendary.healplus.com.glenjendary.healplus.commands.HealHealth;
import com.glenjendary.healplus.com.glenjendary.healplus.commands.HealSaturation;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

public class Main extends JavaPlugin {

    public void onEnable() {

        PluginDescriptionFile pdfFile = getDescription();
        Logger logger = getLogger();

        registerEvents();
        registerCommands();

        logger.info(pdfFile.getName() + " has been enabled with version "
                + pdfFile.getVersion());

    }


    public void registerEvents() {

        PluginManager pm = getServer().getPluginManager();


    }

    public void registerCommands() {
        getCommand("heal").setExecutor(new HealHealth(this));
        getCommand("saturate").setExecutor(new HealSaturation(this));
    }



    public void onDisable() {
        PluginDescriptionFile pdfFile = getDescription();
        Logger logger = getLogger();

        logger.info(pdfFile.getName() + " has been disabled with version "
                + pdfFile.getVersion());
    }

}
