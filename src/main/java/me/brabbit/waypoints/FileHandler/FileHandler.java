package me.brabbit.waypoints.FileHandler;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import me.brabbit.waypoints.Blueprints.Waypoint;
import me.brabbit.waypoints.Waypoints;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class FileHandler {

    // Fields
    public static final String FILE_DIR = System.getProperty("user.dir");
    public static final String FILE_NAME = "Waypoints.json";
    public static final String FILE_PATH = FILE_DIR + "\\" + FILE_NAME;


    //------------------------ Write method
    public static void writeToFile(ArrayList<Waypoint> listToWrite) throws IOException {

        Gson gson = new Gson();
        FileOutputStream fileOutputStream = new FileOutputStream(FileHandler.FILE_PATH, false);
        fileOutputStream.write(gson.toJson(listToWrite).getBytes(StandardCharsets.UTF_8));
        fileOutputStream.write("\n".getBytes(StandardCharsets.UTF_8));
        fileOutputStream.close();

    }


    //------------------------ Read method
    private static String readFromFile() throws IOException {

        // Vars
        StringBuilder stringBuilder = new StringBuilder();
        InputStream inputStream = new FileInputStream(FileHandler.FILE_PATH);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        // Reading
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            stringBuilder.append(line);
        }
        return stringBuilder.toString();
    }


    //------------------------ Deserialize method
    public static ArrayList<Waypoint> deserializeFromGson(String jsonString) {

        Gson gson = new Gson();
        Type typeOfArrayList = new TypeToken<ArrayList<Waypoint>>() {
        }.getType();
        return gson.fromJson(jsonString, typeOfArrayList);

    }


    //------------------------ Startup load method
    public static void loadJsonFromFile() throws IOException {

        if (Waypoints.waypoints.isEmpty()) {
            Waypoints.waypoints.addAll(FileHandler.deserializeFromGson(FileHandler.readFromFile()));
        }

    }

}
