package me.dusty.races.races;

import org.bukkit.ChatColor;
import org.bukkit.permissions.Permission;

public enum RaceEnums {
    DEMON("Demon", ChatColor.DARK_RED),
    ENDERMAN("Enderman", ChatColor.GREEN),
    DRAGONBORNE("Dragon"+ChatColor.YELLOW+"borne", ChatColor.DARK_PURPLE),
    PHANTOM("Phantom", ChatColor.BLUE),
    WITHERSKELETON("Wither Skeleton",ChatColor.GRAY),
    FOX("Fox", ChatColor.YELLOW),
    HOLY("Ho"+ ChatColor.GOLD+ "ly",ChatColor.WHITE),
    MOOSHROOM("Mooshroom",ChatColor.GOLD),
    FAIRY("Fairy",ChatColor.LIGHT_PURPLE),
    MERMAID("Mermaid",ChatColor.DARK_BLUE),
    DRUNK("Drunk",ChatColor.YELLOW),
    UNBORN("Unborn",ChatColor.DARK_GRAY );


    private String name;
    private ChatColor color;


    private RaceEnums(String name, ChatColor color){
    this.name = name;
    this.color = color;


    }
    public String getName() { return name;}
    public ChatColor getColor() { return color;}

}

