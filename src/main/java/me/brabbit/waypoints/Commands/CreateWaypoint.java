package me.brabbit.waypoints.Commands;

import me.brabbit.waypoints.Blueprints.Waypoint;
import me.brabbit.waypoints.Helpers.Validator;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CreateWaypoint implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        // Check command spelling & player check
        if (label.equalsIgnoreCase("tp.create")) {
            if (commandSender instanceof Player) {
                // Player command
                Player player = (Player) commandSender;

                // Argument check
                if(args.length != 1) {
                    player.sendMessage(ChatColor.RED + "[WAYPOINT] INVALID NUMBER OF ARGUMENTS");
                    player.sendMessage(ChatColor.RED + "[WAYPOINT] TO CREATE A WAYPOINT, USE THE FOLLOWING SYNTAX:");
                    player.sendMessage(ChatColor.RED + "[WAYPOINT] tp.create nameofthewaypoint");
                    return true;
                }

                // Waypoint validation
                switch (Validator.checkWaypoint()) {

                    // Valid waypoint
                    case 0:
                        // Get waypoint info
                        Location playerLocation = player.getLocation();
                        String world = playerLocation.getWorld().getName();
                        String waypointName = args[0];
                        int x = playerLocation.getBlockX();
                        int y = playerLocation.getBlockY();
                        int z = playerLocation.getBlockZ();
                        Waypoint waypoint = new Waypoint(player.getName(), world, waypointName, x, y, z);

                        return true;

                    // Maximum number of waypoints already reached
                    case 1:
                        break;

                    // Waypoint with this name already exists
                    case 2:


                }

                return true;

            } else {
                // Console command

            }

        }

        return false;
    }

}
