package me.brabbit.waypoints.Helpers;

import me.brabbit.waypoints.Blueprints.Waypoint;
import me.brabbit.waypoints.Waypoints;

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


    public static int checkWaypoint(Waypoint waypoint) {

        // Vars
        ArrayList<Waypoint> globalList = Waypoints.waypoints;
        ArrayList<Waypoint> playerList = new ArrayList<>();

        // Populate list
        for(Waypoint globalWaypoint : globalList) {
            if (globalWaypoint.getPlayerUUID().equals(waypoint.getPlayerUUID())) {
                playerList.add(globalWaypoint);
            }
        }

        // Check for maximum number


        // Check for already existing waypoint


        return 0;
    }

}
