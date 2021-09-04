package me.brabbit.waypoints.Commands;

import me.brabbit.waypoints.Blueprints.Waypoint;
import me.brabbit.waypoints.Helpers.Validator;
import me.brabbit.waypoints.Waypoints;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Teleport implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        // Check command spelling & player check
        if (label.equalsIgnoreCase("tp.t")) {
            if (commandSender instanceof Player) {
                Player player = (Player) commandSender;

                // Argument check
                if(args.length != 1) {
                    player.sendMessage(ChatColor.RED + "[WAYPOINT] INVALID NUMBER OF ARGUMENTS");
                    player.sendMessage(ChatColor.RED + "[WAYPOINT] TO TELEPORT TO A WAYPOINT, USE THE FOLLOWING SYNTAX:");
                    player.sendMessage(ChatColor.RED + "[WAYPOINT] tp.t nameofthewaypoint");
                    return true;
                }

                // Validate input
                if (Validator.doesExist(args[0], player)) {

                    // Delete Waypoint from global list
                    Waypoint waypoint = Waypoints.waypoints.stream()
                            .filter(element -> element.getWaypointName().equals(args[0]))
                            .findFirst()
                            .get();

                    player.teleport(waypoint.getLocation());
                    player.sendMessage(ChatColor.RED + "[WAYPOINT] PLAYER TELEPORTED TO WAYPOINT " + args[0]);

                }

            }
        }

        return false;
    }

}
