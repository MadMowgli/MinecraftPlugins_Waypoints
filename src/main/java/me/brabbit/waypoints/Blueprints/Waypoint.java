package me.brabbit.waypoints.Blueprints;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.bukkit.Location;

public class Waypoint {

    // Fields
    private String playerName;
    private String playerUUID;
    private String worldName;
    private String waypointName;
    private String waypointID;
    private double xCord;
    private double yCord;
    private double zCord;

    // Constructor
    public Waypoint(String playerName, String playerUUID, String worldName, String waypointName, double xCord, double yCord, double zCord) {
        this.playerName = playerName;
        this.playerUUID = playerUUID;
        this.worldName = worldName;
        this.waypointName = waypointName;
        this.waypointID = playerName + worldName + waypointName;
        this.xCord = xCord;
        this.yCord = yCord;
        this.zCord = zCord;
    }


    // Getters
    public String getPlayerName() {
        return playerName;
    }

    public String getPlayerUUID() {
        return playerUUID;
    }

    public String getWorldName() {
        return worldName;
    }

    public String getWaypointName() {
        return waypointName;
    }

    public String getWaypointID() {
        return waypointID;
    }

    public double getxCord() {
        return xCord;
    }

    public double getyCord() {
        return yCord;
    }

    public double getzCord() {
        return zCord;
    }

}
