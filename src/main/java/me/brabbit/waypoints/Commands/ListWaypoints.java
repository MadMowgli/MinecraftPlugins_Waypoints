package me.brabbit.waypoints.Commands;

import me.brabbit.waypoints.Blueprints.Waypoint;
import me.brabbit.waypoints.Waypoints;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandExecutor;

import java.util.ArrayList;
import java.util.List;

public class ListWaypoints implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        // Check command spelling & player check
        if (label.equalsIgnoreCase("YOURCOMMAND")) {
            if (commandSender instanceof Player) {
                // Player command
                Player player = (Player) commandSender;

                // Get all waypoints from global list that match the current player
                ArrayList<Waypoint> waypoints = new ArrayList<Waypoint>();
                for(Waypoint waypoint : Waypoints.waypoints) {
                    if (waypoint.getPlayerUUID().equals(player.getUniqueId().toString())) {
                        waypoints.add(waypoint);
                    }
                }

                // List waypoints
                player.sendMessage(ChatColor.YELLOW + "[WAYPOINTS] Your waypoints are: ");
                player.sendMessage(ChatColor.YELLOW + "-----------------------");
                for (Waypoint waypoint : waypoints) {
                    player.sendMessage(ChatColor.YELLOW + "[WAYPOINTS] - " + waypoint.getWaypointName());
                }
                player.sendMessage(ChatColor.YELLOW + "-----------------------");



            } else {
                // Console command

            }

        }

        return false;
    }

}
