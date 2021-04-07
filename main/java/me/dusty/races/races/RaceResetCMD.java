package me.dusty.races.races;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;



public class RaceResetCMD implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player player = (Player) sender;

        if (player.isOp()) {
            if (args.length == 2) {


                Races.getFiles().setRace((Bukkit.getOfflinePlayer(args[0]).getUniqueId()), RaceEnums.valueOf(args[1].toUpperCase()));

                player.sendMessage(ChatColor.GREEN + "Changed Races");

            } else {
                player.sendMessage(ChatColor.RED + "YOU ALREADY CHOSE A RACE CONTACT AN ADMIN FOR A RESET");
            }


        } else{
            player.sendMessage(ChatColor.RED + "ERROR");
        }








        return false;
    }
}
