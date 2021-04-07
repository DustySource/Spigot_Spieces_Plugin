package me.dusty.races.races;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.*;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class RaceListener implements Listener {
    ArrayList<Player> phantomEnabled = new ArrayList<>();
    ArrayList<Player> endermanEnabled = new ArrayList<>();
    ArrayList<Player> holyEnabled = new ArrayList<>();
    ArrayList<Player> demonEnabled = new ArrayList<>();
    ArrayList<Player> wsEnabled = new ArrayList<>();
    ArrayList<Player> foxEnabled = new ArrayList<>();
    ArrayList<Player> dragonborneEnabled = new ArrayList<>();
    ArrayList<Player> pFirst = new ArrayList<>();
    ArrayList<Player> mooshEnabled = new ArrayList<>();
    ArrayList<Player> fairyEnabled = new ArrayList<>();
    ArrayList<Player> mermaidEnabled = new ArrayList<>();
    ArrayList<Player> drunkEnabled = new ArrayList<>();
    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        if (!e.getPlayer().hasPlayedBefore()) {
            Races.getFiles().setRace(e.getPlayer(), RaceEnums.UNBORN);

        }
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {

        Player player = e.getPlayer();
        RaceEnums raceEnums = Races.getFiles().getRace(player);

        for (Player onlinePlayers : e.getRecipients()) {
            onlinePlayers.sendMessage(raceEnums.getColor() + raceEnums.getName() + " " + player.getName() + ": " + e.getMessage());
        }
        e.setCancelled(true);
    }

    @EventHandler
    public void onClickVex(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if (Races.getFiles().getRace(player).equals(RaceEnums.PHANTOM)) {
            if (player.getItemInHand().getType().equals(Material.COMPASS)) {
                if (phantomEnabled.contains(player)) {
                    e.getPlayer().getInventory().removeItem(new ItemStack(Material.CLOCK));
                    player.sendMessage(ChatColor.BLUE + "You have disabled Phantom-State");
                    phantomEnabled.remove(player);
                    pFirst.add(player);

                    e.getPlayer().setInvisible(false);
                    e.getPlayer().setMaxHealth(20);
                    e.getPlayer().setHealth(player.getHealth());
                } else {

                    if (!pFirst.contains(player)) {
                        player.sendMessage(net.md_5.bungee.api.ChatColor.BLACK + "" + net.md_5.bungee.api.ChatColor.MAGIC + "You" + org.bukkit.ChatColor.BOLD + "" +
                                net.md_5.bungee.api.ChatColor.RED + "You have discovered your new dark power" + net.md_5.bungee.api.ChatColor.BLACK + "" + org.bukkit.ChatColor.MAGIC + "You");
                    }
                    player.sendMessage(ChatColor.BLUE + "You have enabled Phantom-State");
                    phantomEnabled.add(player);
                    e.getPlayer().getInventory().addItem(new ItemStack(Material.CLOCK));

                    e.getPlayer().setInvisible(true);
                    e.getPlayer().setMaxHealth(8);
                    e.getPlayer().setHealth(8);
                }

            }


        }
        if (Races.getFiles().getRace(player).equals(RaceEnums.DRAGONBORNE)) {


            if (player.getItemInHand().getType().equals(Material.COMPASS)) {
                if (dragonborneEnabled.contains(player)) {
                    player.sendMessage(ChatColor.YELLOW + "You have disabled Dragon-State");
                    dragonborneEnabled.remove(player);
                    pFirst.add(player);
                    e.getPlayer().setAllowFlight(false);
                    e.getPlayer().setWalkSpeed(0.2f);
                    e.getPlayer().setMaxHealth(20);
                    e.getPlayer().setHealth(player.getHealth());
                } else {

                    if (!pFirst.contains(player)) {
                        player.sendMessage(net.md_5.bungee.api.ChatColor.BLACK + "" + net.md_5.bungee.api.ChatColor.MAGIC + "You" + org.bukkit.ChatColor.BOLD + "" +
                                net.md_5.bungee.api.ChatColor.DARK_PURPLE + "You feel your body is corrupted with ancient energy " + net.md_5.bungee.api.ChatColor.BLACK + "" + org.bukkit.ChatColor.MAGIC + "You");
                    }
                    player.sendMessage(ChatColor.DARK_PURPLE + "You have enabled Dragon-State");
                    dragonborneEnabled.add(player);


                    e.getPlayer().setWalkSpeed(0.1052f);
                    e.getPlayer().setFlySpeed(0.02f);
                    e.getPlayer().setAllowFlight(true);
                    e.getPlayer().setMaxHealth(22);
                    e.getPlayer().setHealth(10);
                }


            }
        }
        if (Races.getFiles().getRace(player).equals(RaceEnums.HOLY)) {
            if (player.getItemInHand().getType().equals(Material.CLOCK)){
                if (holyEnabled.contains(player)) {
                    double z = 0;
                    double y = 0;
                    double x = 0;
                    ItemStack item = new ItemStack(Material.SPLASH_POTION);
                    PotionMeta meta = (PotionMeta) item.getItemMeta();

                    meta.addCustomEffect(new PotionEffect(PotionEffectType.HEAL, 1, 0), true);
                    item.setItemMeta(meta);
                    Vector vector = new Vector();
                    vector.setX(player.getLocation().getX() - x);
                    vector.setY((player.getLocation().getY()) - y);
                    vector.setZ(player.getLocation().getZ() - z);
                    vector.multiply(0.7);
                    ThrownPotion thrownPotion = (ThrownPotion) Bukkit.getWorld("world").spawnEntity(player.getLocation(), EntityType.SPLASH_POTION);
                    thrownPotion.setVelocity(vector);
                    thrownPotion.setItem(item);
                    thrownPotion.setBounce(true);
                }
            }
            if (player.getItemInHand().getType().equals(Material.COMPASS)) {
                if (holyEnabled.contains(player)) {

                    player.sendMessage(ChatColor.WHITE + "You have disabled Holy-"+ChatColor.GOLD+"State");
                    holyEnabled.remove(player);
                    pFirst.add(player);
                    e.getPlayer().getInventory().removeItem(new ItemStack(Material.CLOCK));

                    e.getPlayer().setMaxHealth(20);
                    e.getPlayer().setHealth(6);
                    e.getPlayer().setAllowFlight(false);
                } else {

                    if (!pFirst.contains(player)) {
                        player.sendMessage(net.md_5.bungee.api.ChatColor.WHITE + "" + net.md_5.bungee.api.ChatColor.MAGIC + "You" + org.bukkit.ChatColor.BOLD + "" +
                                net.md_5.bungee.api.ChatColor.GOLD + "You have awakened your Holy Power" + net.md_5.bungee.api.ChatColor.WHITE + "" + org.bukkit.ChatColor.MAGIC + "You");
                    }
                    player.sendMessage(ChatColor.GOLD + "You have enabled Holy-"+ChatColor.WHITE+"State");
                    holyEnabled.add(player);

                        e.getPlayer().getInventory().addItem(new ItemStack(Material.CLOCK));


                    e.getPlayer().setMaxHealth(10);
                    e.getPlayer().setHealth(10);
                    e.getPlayer().setAllowFlight(true);
                    e.getPlayer().setFlySpeed(0.015f);

                }

            }


        }
        if (Races.getFiles().getRace(player).equals(RaceEnums.DEMON)) {

            if (player.getItemInHand().getType().equals(Material.COMPASS)) {
                if (demonEnabled.contains(player)) {
                    player.sendMessage(ChatColor.RED + "You have disabled Demon-State");
                    demonEnabled.remove(player);
                    pFirst.add(player);
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999999,  5));
                    e.getPlayer().setWalkSpeed(0.2f);
                    e.getPlayer().setMaxHealth(20);
                    e.getPlayer().setHealth(player.getHealth());
                } else {

                    if (!pFirst.contains(player)) {
                        player.sendMessage(net.md_5.bungee.api.ChatColor.BLACK + "" + net.md_5.bungee.api.ChatColor.MAGIC + "You" + org.bukkit.ChatColor.BOLD + "" +
                                net.md_5.bungee.api.ChatColor.DARK_RED + "Your body is shrouded in a dark aura" + net.md_5.bungee.api.ChatColor.BLACK + "" + org.bukkit.ChatColor.MAGIC + "You");
                    }
                    player.sendMessage(ChatColor.BLACK + "You have enabled Demon-State");
                    demonEnabled.add(player);
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999999,  5));
                    e.getPlayer().setWalkSpeed(0.16f);
                    e.getPlayer().setMaxHealth(28);
                    e.getPlayer().setHealth(player.getHealth());
                    e.getPlayer().setFlySpeed(0.015f);


                }


            }
        }
        if (Races.getFiles().getRace(player).equals(RaceEnums.FOX)) {

            if (player.getItemInHand().getType().equals(Material.COMPASS)) {
                if (foxEnabled.contains(player)) {
                    player.sendMessage(ChatColor.WHITE + "You have disabled Fox-State");
                    foxEnabled.remove(player);
                    pFirst.add(player);
                    e.getPlayer().setSneaking(false);
                    e.getPlayer().setWalkSpeed(0.2f);
                    e.getPlayer().setMaxHealth(20);
                    e.getPlayer().setHealth(player.getHealth());
                } else {

                    if (!pFirst.contains(player)) {
                        player.sendMessage(net.md_5.bungee.api.ChatColor.BLACK + "" + net.md_5.bungee.api.ChatColor.MAGIC + "You" + org.bukkit.ChatColor.BOLD + "" +
                                net.md_5.bungee.api.ChatColor.GOLD + "You tap into your natural senses" + net.md_5.bungee.api.ChatColor.BLACK + "" + org.bukkit.ChatColor.MAGIC + "You");
                    }
                    player.sendMessage(ChatColor.GOLD + "You have enabled Fox-State");
                    foxEnabled.add(player);
                    e.getPlayer().setSneaking(true);
                    e.getPlayer().setWalkSpeed(0.32f);
                    e.getPlayer().setMaxHealth(16);
                    e.getPlayer().setHealth(16);


                }


            }
        }
        if (Races.getFiles().getRace(player).equals(RaceEnums.ENDERMAN)) {

            if (player.getItemInHand().getType().equals(Material.COMPASS)) {
                if (endermanEnabled.contains(player)) {
                    player.sendMessage(ChatColor.DARK_PURPLE + "You have disabled Enderman-State");
                    endermanEnabled.remove(player);
                    pFirst.add(player);
                    e.getPlayer().getInventory().removeItem(new ItemStack(Material.CLOCK));
                    e.getPlayer().setWalkSpeed(0.2f);
                    e.getPlayer().setMaxHealth(20);
                    e.getPlayer().setHealth(player.getHealth());
                } else {

                    if (!pFirst.contains(player)) {
                        player.sendMessage(net.md_5.bungee.api.ChatColor.BLACK + "" + net.md_5.bungee.api.ChatColor.MAGIC + "You" + org.bukkit.ChatColor.BOLD + "" +
                                net.md_5.bungee.api.ChatColor.DARK_PURPLE + "You discover your sealed power" + net.md_5.bungee.api.ChatColor.BLACK + "" + org.bukkit.ChatColor.MAGIC + "You");
                    }
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "You have enabled Enderman-State");
                    endermanEnabled.add(player);
                    e.getPlayer().getInventory().addItem(new ItemStack(Material.CLOCK));
                    e.getPlayer().setWalkSpeed(0.2f);
                    e.getPlayer().setMaxHealth(20);
                    e.getPlayer().setHealth(player.getHealth());

                }


            }
        }
        if (Races.getFiles().getRace(player).equals(RaceEnums.WITHERSKELETON)) {

            if (player.getItemInHand().getType().equals(Material.COMPASS)) {
                if (wsEnabled.contains(player)) {
                    player.sendMessage(ChatColor.DARK_PURPLE + "You have disabled WitherSkeleton-State");
                    wsEnabled.remove(player);
                    pFirst.add(player);
                    e.getPlayer().getInventory().removeItem(new ItemStack(Material.CLOCK));
                    e.getPlayer().setWalkSpeed(0.2f);
                    e.getPlayer().setMaxHealth(20);
                    e.getPlayer().setHealth(player.getHealth());
                } else {

                    if (!pFirst.contains(player)) {
                        player.sendMessage(net.md_5.bungee.api.ChatColor.BLACK + "" + net.md_5.bungee.api.ChatColor.MAGIC + "You" + org.bukkit.ChatColor.BOLD + "" +
                                net.md_5.bungee.api.ChatColor.DARK_PURPLE + "You discover your sealed power" + net.md_5.bungee.api.ChatColor.BLACK + "" + org.bukkit.ChatColor.MAGIC + "You");
                    }
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "You have enabled WitherSkeleton-State");
                    wsEnabled.add(player);

                    e.getPlayer().setWalkSpeed(0.2f);
                    e.getPlayer().setMaxHealth(20);
                    e.getPlayer().setHealth(player.getHealth());

                }


            }
        }
        if (Races.getFiles().getRace(player).equals(RaceEnums.MOOSHROOM)) {

            if (player.getItemInHand().getType().equals(Material.COMPASS)) {
                if (mooshEnabled.contains(player)) {
                    player.sendMessage(ChatColor.DARK_PURPLE + "You have disabled Mooshroom-State");
                    mooshEnabled.remove(player);
                    pFirst.add(player);
                    e.getPlayer().getInventory().removeItem(new ItemStack(Material.SUSPICIOUS_STEW));
                    e.getPlayer().setWalkSpeed(0.2f);
                    e.getPlayer().setMaxHealth(20);
                    e.getPlayer().setHealth(player.getHealth());
                } else {

                    if (!pFirst.contains(player)) {
                        player.sendMessage(net.md_5.bungee.api.ChatColor.BLACK + "" + net.md_5.bungee.api.ChatColor.MAGIC + "You" + org.bukkit.ChatColor.BOLD + "" +
                                net.md_5.bungee.api.ChatColor.DARK_PURPLE + "You discover your power to make stew?...." + net.md_5.bungee.api.ChatColor.BLACK + "" + org.bukkit.ChatColor.MAGIC + "You");
                    }
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "You have enabled Mooshroom-State");
                    mooshEnabled.add(player);
                    e.getPlayer().getInventory().addItem(new ItemStack(Material.SUSPICIOUS_STEW));
                    e.getPlayer().setWalkSpeed(0.2f);
                    e.getPlayer().setMaxHealth(20);
                    e.getPlayer().setHealth(player.getHealth());


                }


            }
        }
        if (Races.getFiles().getRace(player).equals(RaceEnums.FAIRY)) {

            if (player.getItemInHand().getType().equals(Material.COMPASS)) {
                if (fairyEnabled.contains(player)) {
                    player.sendMessage(ChatColor.DARK_PURPLE + "You have disabled Fairy-State");
                    fairyEnabled.remove(player);
                    pFirst.add(player);
                    for (PotionEffect effect : player.getActivePotionEffects()) {
                        player.removePotionEffect(effect.getType());
                    }
                    e.getPlayer().setWalkSpeed(0.05f);
                    e.getPlayer().setMaxHealth(20);
                    e.getPlayer().setAllowFlight(false);
                    e.getPlayer().setFlySpeed(0.1f);
                    e.getPlayer().setHealth(player.getHealth());
                } else {

                    if (!pFirst.contains(player)) {
                        player.sendMessage(net.md_5.bungee.api.ChatColor.GOLD + "" + net.md_5.bungee.api.ChatColor.MAGIC + "You" + org.bukkit.ChatColor.BOLD + "" +
                                net.md_5.bungee.api.ChatColor.LIGHT_PURPLE + "You sprout Fairy wings!" + net.md_5.bungee.api.ChatColor.GOLD + "" + org.bukkit.ChatColor.MAGIC + "You");
                    }
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "You have enabled Fairy-State");
                    fairyEnabled.add(player);

                    e.getPlayer().setWalkSpeed(0.05f);
                    e.getPlayer().setMaxHealth(8);
                    e.getPlayer().setHealth(player.getHealth());
                    e.getPlayer().setAllowFlight(true);
                    e.getPlayer().setFlySpeed(0.13f);
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 9999999, 0));

                }


            }
        }
        if (Races.getFiles().getRace(player).equals(RaceEnums.MERMAID)) {

            if (player.getItemInHand().getType().equals(Material.COMPASS)) {
                if (mermaidEnabled.contains(player)) {
                    player.sendMessage(ChatColor.BLUE + "You have disabled Mermaid-State");
                    mermaidEnabled.remove(player);
                    pFirst.add(player);
                    for (PotionEffect effect : player.getActivePotionEffects()) {
                        player.removePotionEffect(effect.getType());
                    }
                    e.getPlayer().setSwimming(true);
                    e.getPlayer().setWalkSpeed(0.05f);
                    e.getPlayer().setMaxHealth(20);
                    e.getPlayer().setAllowFlight(false);
                    e.getPlayer().setFlySpeed(0.1f);
                    e.getPlayer().setHealth(player.getHealth());
                } else {

                    if (!pFirst.contains(player)) {
                        player.sendMessage(net.md_5.bungee.api.ChatColor.GOLD + "" + net.md_5.bungee.api.ChatColor.MAGIC + "You" + org.bukkit.ChatColor.BOLD + "" +
                                net.md_5.bungee.api.ChatColor.LIGHT_PURPLE + "Your gills open!" + net.md_5.bungee.api.ChatColor.GOLD + "" + org.bukkit.ChatColor.MAGIC + "You");
                    }
                    player.sendMessage(ChatColor.LIGHT_PURPLE + "You have enabled Mermaid-State");
                    mermaidEnabled.add(player);
                    e.getPlayer().setSwimming(true);
                    e.getPlayer().setWalkSpeed(0.05f);
                    e.getPlayer().setMaxHealth(18);
                    e.getPlayer().setHealth(player.getHealth());
                    e.getPlayer().setAllowFlight(false);
                    e.getPlayer().setFlySpeed(0.13f);



                }


            }
        }
        if (Races.getFiles().getRace(player).equals(RaceEnums.DRUNK)) {

            if (player.getItemInHand().getType().equals(Material.COMPASS)) {
                if (drunkEnabled.contains(player)) {
                    player.sendMessage(ChatColor.BLUE + "You have disabled Drunk-State but still may be drunk");
                    drunkEnabled.remove(player);
                    pFirst.add(player);

                    e.getPlayer().setSwimming(true);
                    e.getPlayer().setWalkSpeed(0.2f);
                    e.getPlayer().setMaxHealth(14);
                    e.getPlayer().setAllowFlight(false);
                    e.getPlayer().setFlySpeed(0.1f);
                    e.getPlayer().setHealth(player.getHealth());
                } else {

                    if (!pFirst.contains(player)) {
                        player.sendMessage(net.md_5.bungee.api.ChatColor.GOLD + "" + net.md_5.bungee.api.ChatColor.MAGIC + "You" + org.bukkit.ChatColor.BOLD + "" +
                                net.md_5.bungee.api.ChatColor.AQUA + "You take your first drink...." + net.md_5.bungee.api.ChatColor.GOLD + "" + org.bukkit.ChatColor.MAGIC + "You");
                    }
                    player.sendMessage(ChatColor.DARK_RED + "You have enabled Drunk-State");
                    drunkEnabled.add(player);

                    e.getPlayer().setWalkSpeed(0.02f);
                    e.getPlayer().setMaxHealth(14);
                    e.getPlayer().setHealth(player.getHealth());
                    e.getPlayer().setAllowFlight(false);
                    e.getPlayer().setFlySpeed(0.13f);
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 20 * 300, 4));
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20 * 300, 2));
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 20 * 300, 4));
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20 * 300, 1));
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 20 * 300, 4));
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20 * 300, 4));

                }


            }
        }
    }

    @EventHandler
            public void pvp(EntityDamageByEntityEvent e) {


        if (e.getDamager() instanceof Player) {
            if (phantomEnabled.contains(e.getDamager())) {

                e.setCancelled(true);

            }


        }
    }
    Random rand = new Random();



@EventHandler
public void stew(PlayerInteractEvent e) {
    HashMap<Player, Long> soup = new HashMap<>();

    Player player = e.getPlayer();
    if (soup.containsKey(player)&& soup.get(player) > System.currentTimeMillis()) {
        long timeRemaining = soup.get(player) - System.currentTimeMillis();
        int intRemaining = (int) (timeRemaining/1000);
        player.sendMessage("You have to wait " + intRemaining + " seconds!!");
    }else{
        soup.put(player, System.currentTimeMillis()+(50*1000));
            if (player.getItemInHand().getType().equals(Material.SUSPICIOUS_STEW)) {
                if (mooshEnabled.contains(e.getPlayer())) {
                    e.getPlayer().getWorld().strikeLightning(e.getPlayer().getLocation());
                    int chance = rand.nextInt(15); //0-2 are included, NOT 3. So if you have ..
                    if (chance == 0) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 20 * 60, 1)); //3 second duration
                    } else if (chance == 1) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 20 * 60, 1)); //3 second duration
                    } else if (chance == 2) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.POISON, 20 * 60, 2)); //3 second duration
                    } else if (chance == 3) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 20 * 60, 2)); //3 second duration
                    } else if (chance == 4) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 20 * 60, 1)); //3 second duration
                    } else if (chance == 5) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.DAMAGE_RESISTANCE, 20 * 30, 1)); //3 second duration
                    } else if (chance == 6) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.HARM, 20 * 30, 1)); //3 second duration
                    } else if (chance == 7) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 20 * 30, 1)); //3 second duration
                    } else if (chance == 8) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.CONFUSION, 20 * 30, 1)); //3 second duration
                    } else if (chance == 9) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.LEVITATION, 20 * 30, 1)); //3 second duration
                    } else if (chance == 10) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.GLOWING, 20 * 30, 1)); //3 second duration
                    } else if (chance == 11) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.HEAL, 20 * 30, 1)); //3 second duration
                    } else if (chance == 12) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 20 * 30, 0)); //3 second duration
                    } else if (chance == 13) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 20 * 30, 0)); //3 second duration
                    } else if (chance == 14) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 20 * 30, 1)); //3 second duration

                    } else {
                        return;
                    }

                }

            }

        }
}



   @EventHandler
    public void invisibleForMobs(EntityTargetEvent e) {

        if (phantomEnabled.contains(e.getTarget())) {
            if (e.getTarget() instanceof Player) {
                e.setCancelled(true);
                e.setTarget(null);
            } else{
            return;
            }

        }
    }
@EventHandler
public void block(BlockBreakEvent e){
    if (phantomEnabled.contains(e.getPlayer())){
        e.setCancelled(true);
        e.getPlayer().sendMessage(ChatColor.RED+"You cannot break blocks in phantom-state");
    } else{
        return;
    }

}

    @EventHandler
    public void catchChestOpen(InventoryOpenEvent e) {

        if (phantomEnabled.contains(e.getPlayer())) {
            if (e.getInventory().getType().equals(InventoryType.CHEST)) {
                e.setCancelled(true);
                e.getPlayer().sendMessage(ChatColor.DARK_BLUE + "YOU CANNOT OPEN CHESTS IN PHANTOM STATE");

            } else{
                return;
            }
        }
    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {

        Material m = e.getItemDrop().getItemStack().getType();

        if (m == Material.COMPASS) {
            e.setCancelled(true);
        }
        Player player = e.getPlayer();
        if (holyEnabled.contains(player)) {
            if (Races.getFiles().getRace(player).equals(RaceEnums.HOLY)) {
                if (m == Material.CLOCK) {
                    e.setCancelled(true);
                }
            }
        }
        else {
            return;
        }

    }

    @EventHandler
    public void onDead(PlayerDeathEvent e){

        e.getDrops().remove(new ItemStack(Material.COMPASS));
        e.getDrops().remove(new ItemStack(Material.CLOCK));

    }

    @EventHandler
    public void onDeathGive(PlayerRespawnEvent e) {

        Player player = e.getPlayer();
        e.getPlayer().getInventory().addItem(new ItemStack(Material.COMPASS));
        if (e.getPlayer().getWorld().getName().equals("world_the_end")) {
            for (PotionEffect effect : player.getActivePotionEffects()) {
                player.removePotionEffect(effect.getType());
            }

        } else{
            return;
        }
        if (Races.getFiles().getRace(player).equals(RaceEnums.DEMON)) {
            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999999,  5));
            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 999999999,  0));
            e.getPlayer().setAllowFlight(false);
        } if (Races.getFiles().getRace(player).equals(RaceEnums.WITHERSKELETON)) {
            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999999,  5));

            e.getPlayer().setAllowFlight(false);
        }
        else{
            return;
        }


        }


        @EventHandler

    public void slowFall(PlayerMoveEvent e ){
            if (dragonborneEnabled.contains(e.getPlayer())) {
            e.getPlayer().setFallDistance(0f);
            }
        }
        @EventHandler
    public void onPlayerTeleport(PlayerTeleportEvent e) {
            Player player = e.getPlayer();
            if(e.getCause().equals(PlayerTeleportEvent.TeleportCause.NETHER_PORTAL)){
                if (Races.getFiles().getRace(player).equals(RaceEnums.DEMON)) {
                    for (PotionEffect effect : player.getActivePotionEffects()) {
                        player.removePotionEffect(effect.getType());
                        e.getPlayer().setAllowFlight(true);
                    }
                   // e.getPlayer().setAllowFlight(true);
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999,  0));
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999999,  5));
                }
                if (Races.getFiles().getRace(player).equals(RaceEnums.WITHERSKELETON)) {
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999999,  5));
                }
            }
            if (e.getPlayer().getWorld().getName().equals("world_nether")) {


                if (e.getCause().equals(PlayerTeleportEvent.TeleportCause.NETHER_PORTAL)) {
                    for (PotionEffect effect : player.getActivePotionEffects()) {
                        player.removePotionEffect(effect.getType());
                        e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 999999999,  0));
                    }
                }
            }
        if(e.getCause().equals(PlayerTeleportEvent.TeleportCause.END_PORTAL)){


            if (Races.getFiles().getRace(player).equals(RaceEnums.DRAGONBORNE)) {
            e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 999999999,  0));
            }
            }


            }
    @EventHandler
    public void mermaid(PlayerMoveEvent e) {

        Player player = e.getPlayer();



            if (Races.getFiles().getRace(player).equals(RaceEnums.MERMAID)) {

                Material m = e.getPlayer().getLocation().getBlock().getType();
                if (m == Material.LEGACY_STATIONARY_WATER || m == Material.WATER) {

                for (PotionEffect effect : player.getActivePotionEffects()) {
                player.removePotionEffect(effect.getType());
                e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING, 9999999, 100));

                if (mermaidEnabled.contains(player)) {
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 99999, 1));
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.DOLPHINS_GRACE, 9999999, 1));

                }


                }
            } else {
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 9999999, 0));
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.POISON, 9999999, 0));
        }




        }

    }


            @EventHandler
            public void onMove(PlayerMoveEvent e){
                Player player = e.getPlayer();
                if (e.getPlayer().getWorld().getName().equals("world")) {
                    if (Races.getFiles().getRace(player).equals(RaceEnums.DEMON)) {
                        e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.WEAKNESS, 999999999,  0));
                        e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999999,  5));
                        e.getPlayer().setAllowFlight(false);

                    }
                }
                if (Races.getFiles().getRace(player).equals(RaceEnums.ENDERMAN)) {
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.NIGHT_VISION, 999999999,  0));
                }
    }
    HashMap<Player, Long> enderPearl = new HashMap<>();
    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if(enderPearl.containsKey(player) && enderPearl.get(player) > System.currentTimeMillis()) {

            long longRemaining =enderPearl.get(player) - System.currentTimeMillis();
            int intRemaining = (int) (longRemaining / 1000);
            player.sendMessage(ChatColor.BOLD +""+ChatColor.GREEN +"You must wait " +intRemaining +ChatColor.BOLD +""+ChatColor.GREEN+ " more seconds before pearling");


        } else {
            if (endermanEnabled.contains(player)) {
                if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    if (player.getItemInHand().getType().equals(Material.CLOCK)) {
                        player.launchProjectile(EnderPearl.class);
                        enderPearl.put(player, System.currentTimeMillis() + (5 * 1000));

                    }
                }
            }
        }
    }

    HashMap<Player, Long> fireBall = new HashMap<>();
    HashMap<Player, Long> dFireBall = new HashMap<>();

    @EventHandler
    public void fireBall(PlayerInteractEvent e) {
        Player player = e.getPlayer();
        if(fireBall.containsKey(player) && fireBall.get(player) > System.currentTimeMillis()) {
        long longRemaining =fireBall.get(player) - System.currentTimeMillis();
        int intRemaining = (int) (longRemaining / 1000);
        player.sendMessage(ChatColor.BOLD +""+ChatColor.RED +"You are still preparing another for " +intRemaining +ChatColor.BOLD +""+ChatColor.RED+ " more seconds");

        }
        else{
            if (demonEnabled.contains(player)) {
                if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    if (player.getItemInHand().getType().equals(Material.FIRE_CHARGE)) {
                        player.launchProjectile(Fireball.class);
                        player.getInventory().removeItem(new ItemStack(Material.FIRE_CHARGE));
                        fireBall.put(player, System.currentTimeMillis() + (5 * 1000));

                    }
                }


            }
        }
        //Dragon Borne
        if(dFireBall.containsKey(player) && dFireBall.get(player) > System.currentTimeMillis()) {
            long long2Remaining =dFireBall.get(player) - System.currentTimeMillis();
            int int2Remaining = (int) (long2Remaining / 1000);
            player.sendMessage(ChatColor.BOLD +""+ChatColor.RED +"You are still preparing another for " +int2Remaining +ChatColor.BOLD +""+ChatColor.RED+ " more seconds");

        }
        else{
            if (dragonborneEnabled.contains(player)) {
                if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    if (player.getItemInHand().getType().equals(Material.FIRE_CHARGE)) {
                        player.launchProjectile(DragonFireball.class);
                        player.getInventory().removeItem(new ItemStack(Material.FIRE_CHARGE));
                        dFireBall.put(player, System.currentTimeMillis() + (30 * 1000));

                    }
                }


            }
        }
        }
    @EventHandler
    public void enderPearl(PlayerTeleportEvent e) {
        Player player = e.getPlayer();

        if (e.getCause() == PlayerTeleportEvent.TeleportCause.ENDER_PEARL) {
            if (Races.getFiles().getRace(player).equals(RaceEnums.ENDERMAN)) {
                e.setCancelled(true);

                player.teleport(e.getTo());
            }
        }
    }
    @EventHandler
    public void autofireres(PlayerMoveEvent e) {

        Player player = e.getPlayer();



        if (Races.getFiles().getRace(player).equals(RaceEnums.WITHERSKELETON)) {

            Material m = e.getPlayer().getLocation().getBlock().getType();
            if (m == Material.FIRE || m == Material.LAVA) {
                e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999999,  5));
            }
        }
        if (Races.getFiles().getRace(player).equals(RaceEnums.DEMON)) {

            Material m = e.getPlayer().getLocation().getBlock().getType();
            if (m == Material.FIRE || m == Material.LAVA) {
                e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 999999999,  5));
            }
        }
            }

    HashMap<Player, Long> phantomNerf = new HashMap<>();
    @EventHandler
    public String phantom(PlayerInteractEvent e) {
        Player player = e.getPlayer();

        if (phantomNerf.containsKey(player) && phantomNerf.get(player) > System.currentTimeMillis()) {
            long long2Remaining = phantomNerf.get(player) - System.currentTimeMillis();
            int int2Remaining = (int) (long2Remaining / 1000);
            player.sendMessage(ChatColor.BOLD + "" + ChatColor.RED + "You are still preparing another for " + int2Remaining + ChatColor.BOLD + "" + ChatColor.RED + " more seconds");
        } else {
            double rotation = (player.getLocation().getYaw() - 90) % 360;
            if (rotation < 0) {
                rotation += 360.0;
            }


            if (phantomEnabled.contains(player)) {
                phantomNerf.put(player, System.currentTimeMillis() + (5 * 1000));
                Location loc = player.getLocation();
                if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    if (player.getItemInHand().getType().equals(Material.CLOCK)) {
                        if (0 <= rotation && rotation < 22.5) {
                            loc.add(-2, 0, 0);
                            player.teleport(loc);
                            return "Real W";
                        } else if (22.5 <= rotation && rotation < 67.5) {
                            loc.add(-2, 0, -2);
                            player.teleport(loc);
                            return "Real NW";
                        } else if (67.5 <= rotation && rotation < 112.5) {
                            loc.add(0, 0, -2);
                            player.teleport(loc);
                            return "Real N";
                        } else if (112.5 <= rotation && rotation < 157.5) {
                            loc.add(2, 0, -2);
                            player.teleport(loc);
                            return "Actual NE";

                        } else if (157.5 <= rotation && rotation < 202.5) {
                            loc.add(2, 0, 0);
                            player.teleport(loc);
                            return "Actual E";
                        } else if (202.5 <= rotation && rotation < 247.5) {
                            loc.add(2, 0, 1.4);
                            player.teleport(loc);
                            return "Actual SE";
                        } else if (247.5 <= rotation && rotation < 292.5) {
                            loc.add(0, 0, 2);
                            player.teleport(loc);
                            return "Actual S";
                        } else if (292.5 <= rotation && rotation < 337.5) {
                            loc.add(-2, 0, 1.3);
                            player.teleport(loc);
                            return "Actual SW";
                        } else if (337.5 <= rotation && rotation < 360.0) {
                            loc.add(-2, 0, 0);
                            player.teleport(loc);
                            return "Real NW?";
                        } else {
                            return null;
                        }


                    }
                }
            }


        }
        return null;
    }

}
















