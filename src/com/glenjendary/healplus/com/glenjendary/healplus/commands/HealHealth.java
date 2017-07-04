package com.glenjendary.healplus.com.glenjendary.healplus.commands;

/* HealPlus Created} by Glenjendary on 4/07/2017. */

import com.glenjendary.healplus.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealHealth implements CommandExecutor{


    private Main plugin;
    public HealHealth(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage("You must be a player to use this command!");
        }

        Player player = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("heal")) {
            if (args.length == 0 && player.hasPermission("healplus.help")) {
                player.sendMessage(ChatColor.RED + "Please use /heal <player>");
            } else {
                player.sendMessage(ChatColor.RED + "You do not have permission to use this command!");
            } if (args.length == 1 && player.hasPermission("heal.others")) {
                Player target;
                try {
                    target = Bukkit.getPlayer(args[0]);

                } catch (NullPointerException e) {
                    player.sendMessage(ChatColor.RED + args[0] + "is not a online player!");
                    target = null;
                    return false;
                }
                target.getPlayer().setHealth(target.getPlayer().getMaxHealth());
                target.sendMessage(ChatColor.GREEN + "You have been healed by " + player);
                player.sendMessage(ChatColor.GREEN + "You have healed " + target);
                return true;
                }
            }
        return true;
        }

    }

