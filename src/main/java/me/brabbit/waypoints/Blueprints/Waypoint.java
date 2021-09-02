package me.brabbit.waypoints.Blueprints;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Waypoint {

    // Fields
    private String playerName;
    private String playerUUID;
    private String worldName;
    private String waypointName;
    private String waypointID;
    private int xCord;
    private int yCord;
    private int zCord;


    // Constructor
    public Waypoint(String playerName, String playerUUID, String worldName, String waypointName, int xCord, int yCord, int zCord) {
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

    public int getxCord() {
        return xCord;
    }

    public int getyCord() {
        return yCord;
    }

    public int getzCord() {
        return zCord;
    }

}
