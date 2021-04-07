package me.dusty.races.races;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Enderman;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;

public final class Races extends JavaPlugin {
private static Files files;
    @Override
    public void onEnable() {

        // Plugin startup logic
    getCommand("race").setExecutor(new RaceCMD());
    files = new Files(this);
    Bukkit.getPluginManager().registerEvents(new RaceListener(), this);
        getCommand("raceset").setExecutor(new RacesCMD(this));
        getCommand("racereset").setExecutor(new RaceResetCMD());


        }



    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
public static Files getFiles(){
        return files;
}



//Cooldown
  //  public HashMap<Player, Long> cooldown = new HashMap<>();


    public ArrayList<Player> cooldownEnabled = new ArrayList<>();


}

