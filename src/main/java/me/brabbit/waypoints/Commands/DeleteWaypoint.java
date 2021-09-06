package me.brabbit.waypoints.Commands;

import me.brabbit.waypoints.Blueprints.Waypoint;
import me.brabbit.waypoints.Helpers.Validator;
import me.brabbit.waypoints.Waypoints;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandExecutor;

import java.util.ArrayList;

public class DeleteWaypoint implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        // Check command spelling & player check
        if (label.equalsIgnoreCase("tp.delete")) {
            if (commandSender instanceof Player) {
                // Player command
                Player player = (Player) commandSender;

                // Argument check
                if(args.length != 1) {
                    player.sendMessage(ChatColor.RED + "[WAYPOINT] INVALID NUMBER OF ARGUMENTS");
                    player.sendMessage(ChatColor.RED + "[WAYPOINT] TO DELETE A WAYPOINT, USE THE FOLLOWING SYNTAX:");
                    player.sendMessage(ChatColor.RED + "[WAYPOINT] tp.delete nameofthewaypoint");
                    return true;
                }

                // Validate input
                if (Validator.doesExist(args[0], player)) {

                    // TODO: Add dialogue to re-confirm that the player actually wants to delete the wp

                    // Delete Waypoint from global list
                    Waypoint waypoint = Waypoints.waypoints.stream()
                            .filter(element -> element.getWaypointName().equals(args[0]))
                            .findFirst()
                            .get();

                    Waypoints.waypoints.remove(waypoint);
                    player.sendMessage(ChatColor.YELLOW + "[WAYPOINT] WAYPOINT " + args[0] + " DELETED");

                }


            } else {
                // Console command

            }

        }

        return false;
    }

}
