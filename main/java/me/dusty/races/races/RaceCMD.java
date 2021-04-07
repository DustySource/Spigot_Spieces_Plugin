package me.dusty.races.races;

import net.md_5.bungee.api.ChatColor;


import org.apache.commons.lang3.EnumUtils;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;

import java.util.Objects;
import java.util.UUID;


public class RaceCMD implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {


        Player player = (Player) sender;
        if (args[0].equalsIgnoreCase("help")) {
            sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Do /race start");


        }
        if (args[0].equalsIgnoreCase("start")) {
            sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Choose a Race");
            sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Do /raceset [racename]");
            sender.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Do /race info name of race for a description on each race\n" + ChatColor.RED + "Ex: /race info Demon");
            sender.sendMessage(ChatColor.GREEN + "Enderman, "
                    + ChatColor.DARK_PURPLE + "Dragon" + ChatColor.YELLOW + "borne, " + ChatColor.BLUE + "Phantom, "
                    + ChatColor.GRAY + "WitherSkeleton, " + ChatColor.YELLOW + "Fox, "
                    + ChatColor.DARK_RED + "Demon, " + ChatColor.GOLD + "Holy, " +ChatColor.RED+"Mooshroom, "+ ChatColor.LIGHT_PURPLE+"Fairy, "
                    +ChatColor.BLUE+"Mermaid, "+ChatColor.RED + "Drunk");

        }
        if (args[0].equalsIgnoreCase("info")) {
            sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Information about a race\n" + ChatColor.WHITE + "--------------------------");

            if (args[1].equalsIgnoreCase("Enderman")) {
                sender.sendMessage(ChatColor.GREEN + "ENDERMAN");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "+" + ChatColor.WHITE + "]" + "  " + "Teleport");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "+" + ChatColor.WHITE + "]" + "  " + "NV");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "-" + ChatColor.WHITE + "]" + "  " + "Water does damage");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "-" + ChatColor.WHITE + "]" + "  " + "Weak around pumpkins");
            }
            if (args[1].equalsIgnoreCase("Demon")) {
                sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "DEMON\n" + ChatColor.RED + "Born and raised in the underworld");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "+" + ChatColor.WHITE + "]" + "  " + "Immune to fire and lava");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "+" + ChatColor.WHITE + "]" + "  " + "Strength in Nether\n");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "+" + ChatColor.WHITE + "]" + "  " + "Can fly (Very slowly)\n");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "+" + ChatColor.WHITE + "]" + "  " + "Demonic Clock that deals splash dmg");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "-" + ChatColor.WHITE + "]" + "  " + "Weakness in Overworld");


            }
            if (args[1].equalsIgnoreCase("Dragonborne")) {
                sender.sendMessage(ChatColor.DARK_PURPLE + "" + ChatColor.BOLD + "Dragon" + ChatColor.YELLOW + "" + ChatColor.BOLD + "borne\n"
                        + ChatColor.LIGHT_PURPLE + "Most were sealed away by Endermen along with the Ender Dragon but some survived");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "+" + ChatColor.WHITE + "]" + "  " + "Very Powerful in the End");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "+" + ChatColor.WHITE + "]" + "  " + "No fall damage");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "+" + ChatColor.WHITE + "]" + "  " + "Extra 3 hearts in Dragon State");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "-" + ChatColor.WHITE + "]" + "  " + "Slowness in Dragon-State");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "-" + ChatColor.WHITE + "]" + "  " + "When switching states starts at low health");

            }
            if (args[1].equalsIgnoreCase("Holy")) {
                sender.sendMessage(ChatColor.GOLD + "" + ChatColor.BOLD + "Holy\n"
                        + ChatColor.LIGHT_PURPLE + "Most of the Holy Race was killed and the survivors left weak");

                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "+" + ChatColor.WHITE + "]" + "  " + "Healing Abilities");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "+" + ChatColor.WHITE + "]" + "  " + "Ability to fly(very slow)");

                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "-" + ChatColor.WHITE + "]" + "  " + "Low Health");
            }
            if (args[1].equalsIgnoreCase("Phantom")) {
                sender.sendMessage(ChatColor.DARK_BLUE + "" + ChatColor.BOLD + "Phantom\n"
                        + ChatColor.BLUE + "Aggressive lost souls rarely friendly");


                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "+" + ChatColor.WHITE + "]" + "  " + "Can go invisible with Phantom-State");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "-" + ChatColor.WHITE + "]" + "  " + "1 Heart while in Phantom-State");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "-" + ChatColor.WHITE + "]" + "  " + "Cant open chests or deal damage while in Phantom-State");

            }
            if (args[1].equalsIgnoreCase("Fox")) {
                sender.sendMessage(ChatColor.YELLOW + "" + ChatColor.BOLD + "Fox\n"
                        + ChatColor.GOLD + "A clan of humans began growing Fox-like features after years secluded in Nature");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "+" + ChatColor.WHITE + "]" + "  " + "Cute <3");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "+" + ChatColor.WHITE + "]" + "  " + "Faster");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "-" + ChatColor.WHITE + "]" + "  " + "Less health");

            }
            if (args[1].equalsIgnoreCase("WitherSkeleton")) {
                sender.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "Wither Skeleton\n"
                        + ChatColor.RED + "Servant in the Underworld");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "+" + ChatColor.WHITE + "]" + "  " + "Speed in Nether");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "+" + ChatColor.WHITE + "]" + "  " + "Immune to fire");



            }
            if (args[1].equalsIgnoreCase("Mooshroom")) {
                sender.sendMessage(ChatColor.RED + "" + ChatColor.BOLD + "Mooshroom\n"
                        + ChatColor.GOLD + "A strange species that makes great stew");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "+" + ChatColor.WHITE + "]" + "  " + "Can create stew with random effects");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "-" + ChatColor.WHITE + "]" + "  " + "Gets struck by lightning everytime stew is made");



            }
            if (args[1].equalsIgnoreCase("Fairy")) {
                sender.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Fairy\n"
                        + ChatColor.GOLD + "A divine creature");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "+" + ChatColor.WHITE + "]" + "  " + "Fast Fly");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "-" + ChatColor.WHITE + "]" + "  " + "Low Health");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "-" + ChatColor.WHITE + "]" + "  " + "Slow Walking");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "-" + ChatColor.WHITE + "]" + "  " + "Weak");



            }
            if (args[1].equalsIgnoreCase("Mermaid")) {
                sender.sendMessage(ChatColor.LIGHT_PURPLE + "" + ChatColor.BOLD + "Mermaid\n"
                        + ChatColor.GOLD + "A water dwelling creature");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "+" + ChatColor.WHITE + "]" + "  " + "Breathe under water forever");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "+" + ChatColor.WHITE + "]" + "  " + "When state active faster swimming in water");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "+" + ChatColor.WHITE + "]" + "  " + "When state active regen in water");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "-" + ChatColor.WHITE + "]" + "  " + "Barely able to move on land");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "-" + ChatColor.WHITE + "]" + "  " + "Weakness is applied outside of water");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "-" + ChatColor.WHITE + "]" + "  " + "Poison outside of water");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "-" + ChatColor.WHITE + "]" + "  " + "When state active one less heart");



            }
            if (args[1].equalsIgnoreCase("Drunk")) {
                sender.sendMessage(ChatColor.DARK_RED + "" + ChatColor.BOLD + "Drunk\n"
                        + ChatColor.GOLD + "A water dwelling creature");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "+" + ChatColor.WHITE + "]" + "  " + "Puts out large amount of damage when drunk");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.GREEN + "+" + ChatColor.WHITE + "]" + "  " + "Resistance");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "-" + ChatColor.WHITE + "]" + "  " + "Low health");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "-" + ChatColor.WHITE + "]" + "  " + "Extreme Nauesua");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "-" + ChatColor.WHITE + "]" + "  " + "Extreme Blindness");
                sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.RED + "-" + ChatColor.WHITE + "]" + "  " + "Slowness");



            }



        }
        if (args[0].equalsIgnoreCase("test")){

        }
return true;
    }
}










