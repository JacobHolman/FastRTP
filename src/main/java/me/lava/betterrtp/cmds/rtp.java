package me.lava.betterrtp.cmds;

import me.lava.betterrtp.BetterRTP;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Location;

public class rtp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(BetterRTP.instance.fetchCmdStart() + "This command can only be executed by a player.");
            return true;
        }
        Player player = (Player) sender;
        World world = player.getWorld();
        double radius = 100.0;
        double x = world.getSpawnLocation().getX() + (Math.random() * radius * 2 - radius);
        double z = world.getSpawnLocation().getZ() + (Math.random() * radius * 2 - radius);
        double y = world.getHighestBlockYAt((int) x, (int) z) + 1;
        player.teleport(new Location(world, x, y, z));
        player.sendMessage(BetterRTP.instance.fetchCmdStart() + "You have been randomly teleported.");
        return true;
    }
}
