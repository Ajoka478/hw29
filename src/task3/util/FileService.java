package task3.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import task3.util.info.Movie;
import task3.util.info.MovieCollection;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileService {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path PATH = Paths.get("task1/data/movies.json");


    public static void parseMovies(){
        String json = "";
        try{
            json = GSON.fromJson(Files.readAllLines(PATH)).getMovies();
        }catch (IOException e){
            System.out.println("Error " + e.toString());
        }
    }
}