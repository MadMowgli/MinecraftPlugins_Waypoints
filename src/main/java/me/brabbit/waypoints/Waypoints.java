package me.brabbit.waypoints;

import me.brabbit.waypoints.Blueprints.Waypoint;
import me.brabbit.waypoints.Commands.CreateWaypoint;
import me.brabbit.waypoints.Commands.DeleteWaypoint;
import me.brabbit.waypoints.Commands.ShareWaypoint;
import me.brabbit.waypoints.Commands.Teleport;
import me.brabbit.waypoints.FileHandler.FileHandler;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;
import java.util.ArrayList;

public final class Waypoints extends JavaPlugin {

    // Globals
    public static Waypoints plugin;
    public static ArrayList<Waypoint> waypoints = new ArrayList<Waypoint>();

    // Getters
    public static Waypoints getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        // Plugin startup logic

        // Get instance of plugin
        plugin = this;

        // Load Gson
        // BUGGY ATM
        try {
            FileHandler.loadJsonFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Register commands
        this.getCommand("tp.create").setExecutor(new CreateWaypoint());
        this.getCommand("tp.delete").setExecutor(new DeleteWaypoint());
//        this.getCommand("tp.share").setExecutor(new ShareWaypoint());
        this.getCommand("tp.t").setExecutor(new Teleport());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic

        try {
            FileHandler.writeToFile_GSON(waypoints);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}
