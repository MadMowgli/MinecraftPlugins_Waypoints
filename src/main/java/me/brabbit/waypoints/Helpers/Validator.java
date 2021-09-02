package me.brabbit.waypoints.Helpers;

import me.brabbit.waypoints.Blueprints.Waypoint;
import me.brabbit.waypoints.Waypoints;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Validator {

    /*
    * Validates the given waypoint and returns a validation statement:
    * 0 = Valid waypoint
    * 1 = Maximum number of waypoints already reached
    * 2 = Waypoint with this name already exists
    */

    // Fields
    private static final int MAX_WAYPOINTS = 15;


    // Validation method for waypoint creation
    public static int checkWaypoint(Waypoint waypoint) {

        // Vars
        ArrayList<Waypoint> globalList = Waypoints.waypoints;
        ArrayList<Waypoint> playerList = new ArrayList<>();

        // Populate list
        for(Waypoint globalWaypoint : globalList) {
            if (globalWaypoint.getPlayerUUID().equals(waypoint.getPlayerUUID())) { playerList.add(globalWaypoint); }
        }

        // Check for maximum number
        if (playerList.size() > MAX_WAYPOINTS) { return 1; }

        // Check for already existing waypoint
        for (Waypoint waypoint1 : playerList) {
            if (waypoint.getWaypointID().equalsIgnoreCase(waypoint1.getWaypointID())) { return 2; }
        }

        // Valid waypoint
        return 0;
    }

    // Validation method for waypoint deletion
    public static boolean doesExist(String name, Player player) {

        // Vars
        ArrayList<Waypoint> globalList = Waypoints.waypoints;
        ArrayList<Waypoint> playerList = new ArrayList<>();

        // Populate list
        for(Waypoint globalWaypoint : globalList) {
            if (globalWaypoint.getPlayerUUID().equals(player.getUniqueId().toString())) {
                playerList.add(globalWaypoint);
            }
        }

        // Check if waypoint exists
        for(Waypoint waypoint : playerList) {
            if (waypoint.getWaypointName().equals(name)) {
                return true;
            }
        }

        // None found
        return false;

    }

}
