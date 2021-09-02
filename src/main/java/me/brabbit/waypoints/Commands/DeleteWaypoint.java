package me.brabbit.waypoints.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.command.CommandExecutor;

public class DeleteWaypoint implements CommandExecutor {

    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        // Check command spelling & player check
        if (label.equalsIgnoreCase("tp.delete")) {
            if (commandSender instanceof Player) {
                // Player command
                Player player = (Player) commandSender;


            } else {
                // Console command

            }

        }

        return false;
    }

}
