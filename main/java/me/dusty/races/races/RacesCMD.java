package me.dusty.races.races;

import org.apache.commons.lang3.EnumUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionDefault;

import java.util.Objects;
import java.util.UUID;


public class RacesCMD implements CommandExecutor {
    private Races races;
    public RacesCMD(Races races){
        this.races = races;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {





        Player player = (Player) sender;
        UUID uuid = player.getUniqueId();

            if (Races.getFiles().getRace(player).equals(RaceEnums.PHANTOM)){

            }
        if (Races.getFiles().getRace(player).equals(RaceEnums.UNBORN)){

        player.getInventory().addItem(new ItemStack(Material.COMPASS));
        }





        if (args.length == 1) {
            if (Races.getFiles().getRace(player).equals(RaceEnums.UNBORN)){





                    Races.getFiles().setRace((Bukkit.getPlayer(sender.getName()).getUniqueId()), RaceEnums.valueOf(args[0].toUpperCase()));

                    player.sendMessage(ChatColor.GREEN + "Changed Races");

                } else {
                player.sendMessage(ChatColor.RED + "YOU ALREADY CHOSE A RACE CONTACT AN ADMIN FOR A RESET");
            }

            } else {
                player.sendMessage(ChatColor.RED + "Error");
            }






        return false;
    }
}














