package me.lava.betterrtp;

import me.lava.betterrtp.cmds.*;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class BetterRTP extends JavaPlugin {

    public static BetterRTP instance;
    private FileConfiguration config;
    private String cmdStart;
    @Override
    public void onEnable() {
        FileConfiguration config = getConfig();
        config.options().copyDefaults(true);
        saveConfig();
        cmdStart = config.getString("prefix", "&c&l[BETTERRTP]&7 ");
        instance = this;
        Objects.requireNonNull(this.getCommand("rtp")).setExecutor(new rtp());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public String fetchCmdStart() {
        return ChatColor.translateAlternateColorCodes('&', cmdStart);
    }
}
