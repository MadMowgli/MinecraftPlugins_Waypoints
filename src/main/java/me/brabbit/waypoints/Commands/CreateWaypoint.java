package me.brabbit.waypoints.Commands;

import me.brabbit.waypoints.Blueprints.Waypoint;
import me.brabbit.waypoints.Helpers.Validator;
import me.brabbit.waypoints.Waypoints;
import org.bukkit.ChatColor;
import org.bukkit.Location;
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

                // Create waypoint
                Location playerLocation = player.getLocation();
                String world = playerLocation.getWorld().getName();
                String waypointName = args[0];
                double x = playerLocation.getX();
                double y = playerLocation.getY();
                double z = playerLocation.getZ();
                Waypoint waypoint = new Waypoint(player.getName(), player.getUniqueId().toString(), world, waypointName, x, y, z);


                // Waypoint validation
                switch (Validator.checkWaypoint(waypoint)) {

                    // Valid waypoint
                    case 0:
                        // Save waypoint
                        Waypoints.waypoints.add(waypoint);
                        commandSender.sendMessage(ChatColor.YELLOW + "[WAYPOINTS] WAYPOINT " + args[0] + " CREATED.");
                        return true;

                    // Maximum number of waypoints already reached
                    case 1:
                        player.sendMessage(ChatColor.RED + "[WAYPOINT] MAXIMUM NUMBER OF WAYPOINTS REACHED");
                        player.sendMessage(ChatColor.RED + "[WAYPOINT] EACH PLAYER CAN ONLY CREATE UP TO 15 WAYPOINTS");
                        player.sendMessage(ChatColor.RED + "[WAYPOINT] DELETE A WAYPOINT USING tp.delete nameofwaypoint");
                        break;

                    // Waypoint with this name already exists
                    case 2:
                        player.sendMessage(ChatColor.RED + "[WAYPOINT] WAYPOINT WITH THIS NAME ALREADY EXISTS");
                        player.sendMessage(ChatColor.RED + "[WAYPOINT] CHOOSE ANOTHER NAME FOR YOUR WAYPOINT");

                }

                return true;

            } else {
                // Console command
                commandSender.sendMessage("[WAYPOINT] This is no console command.");
                return true;
            }

        }

        return false;
    }

}
