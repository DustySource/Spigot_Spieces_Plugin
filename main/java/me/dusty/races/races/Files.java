package me.dusty.races.races;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class Files {
private File file;
private YamlConfiguration config;
    public Files(Races races){
        file = new File(races.getDataFolder(), "races.yml");
        if (!file.exists()) {
        try{
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        }

        config = YamlConfiguration.loadConfiguration(file);

    }

public void setRace(Player player, RaceEnums raceEnums){
config.set(player.getUniqueId().toString(), raceEnums.name());
save();
}
public void setRace(UUID uuid, RaceEnums raceEnums){
    config.set(uuid.toString(), raceEnums.name());
    save();
}



    public RaceEnums getRace(Player player) {
        return RaceEnums.valueOf(config.getString(player.getUniqueId().toString()));
    }
    private void save() {
        try {
            config.save(file);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
