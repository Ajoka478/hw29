package task3.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import task3.info.Movie;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FileService {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path PATH = Paths.get("task3/data/movies.json");


    public static List<Movie> parseMovies(){
        Map<String, List<Movie>> map = new HashMap<>();
        Type itemsMapType = new TypeToken<Map<String, List<Movie>>>() {}.getType();
        String json = "";
        try{
            json = Files.readString(PATH);
        }catch (IOException e){
            System.out.println("Error " + e.toString());
        }
        map = GSON.fromJson(json, itemsMapType);
        return map.get("movies");
    }
}