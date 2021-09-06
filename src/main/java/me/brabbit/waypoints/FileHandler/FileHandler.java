package me.brabbit.waypoints.FileHandler;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import me.brabbit.waypoints.Blueprints.Waypoint;
import me.brabbit.waypoints.Waypoints;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

public class FileHandler {

    // Fields
    public static final String FILE_DIR = Waypoints.getPlugin().getDataFolder().getAbsolutePath();
    public static final String FILE_PATH = FILE_DIR + "Waypoints.json";



    //------------------------ Write method 2 - GSON compliant
    public static void writeToFile_GSON(ArrayList<Waypoint> listToWrite) throws IOException {

        Gson gson = new Gson();
        File file = new File(FILE_PATH);
        Writer writer = new FileWriter(file, false);

        gson.toJson(listToWrite, writer);
        writer.flush();
        writer.close();

        System.out.println("[WAYPOINTS] Waypoints written to json file");

    }


    //------------------------ Read method - GSON COMPLIANT
    private static void loadFromFile_GSON() throws IOException {

        // Vars
        Gson gson = new Gson();
        File file = new File(FILE_PATH);

        // Check if file exists
        if(file.exists()) {
            Reader reader = new FileReader(file);
            Waypoint[] waypoints = gson.fromJson(reader, Waypoint[].class);
            Waypoints.waypoints = new ArrayList<Waypoint>(Arrays.asList(waypoints));
        }

    }

    /* ----------------------------------------------------------------------------------------------------------------
    *   DEPRECATED
    * ----------------------------------------------------------------------------------------------------------------/

    //------------------------ Write method - NOT COMPATIBLE WITH GSON
     */
//    public static void writeToFile(ArrayList<Waypoint> listToWrite) throws IOException {
//
//        Gson gson = new Gson();
//        File file = new File(FILE_PATH);
//        FileOutputStream fileOutputStream = new FileOutputStream(FileHandler.FILE_PATH, false);
//        fileOutputStream.write(gson.toJson(listToWrite).getBytes(StandardCharsets.UTF_8));
//        fileOutputStream.write("\n".getBytes(StandardCharsets.UTF_8));
//        fileOutputStream.close();
//
//    }

//    //------------------------ Read method
//    private static String readFromFile() throws IOException {
//
//        // Vars
//        StringBuilder stringBuilder = new StringBuilder();
//        InputStream inputStream = new FileInputStream(FileHandler.FILE_PATH);
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//
//        // Reading
//        String line;
//        while ((line = bufferedReader.readLine()) != null) {
//            stringBuilder.append(line);
//        }
//        return stringBuilder.toString();
//    }



//    //------------------------ Deserialize method
//    public static ArrayList<Waypoint> deserializeFromGson(String jsonString) {
//
//        Gson gson = new Gson();
//        Type typeOfArrayList = new TypeToken<ArrayList<Waypoint>>() {
//        }.getType();
//        return gson.fromJson(jsonString, typeOfArrayList);
//
//    }


//    //------------------------ Startup load method
//    public static void loadJsonFromFile() throws IOException {
//
//        if (Waypoints.waypoints.isEmpty()) {
//            Waypoints.waypoints.addAll(FileHandler.deserializeFromGson(FileHandler.readFromFile()));
//        }
//
//    }

}
