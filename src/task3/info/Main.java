package task3.info;

import task1.Cat;
import task2.ActiveCat;
import task3.util.FileService;

import java.util.*;

public class Main {
    private static final String NEW_LINE = "\n";
    private static final List<Movie> MOVIES = new ArrayList<>();
    public static void main(String[] args) {
        MOVIES.addAll(FileService.parseMovies());
       while (true){
           menu();
           userInterface();
       }

    }
    private static void menu(){
        print(NEW_LINE);
        StringBuilder sb = new StringBuilder("Choose an action");
        sb.append(NEW_LINE);
        sb.append("1 - Show all movies").append(NEW_LINE);
        sb.append("2 - Search a movie").append(NEW_LINE);
        sb.append("3 - Sort movies").append(NEW_LINE);

        print(sb.toString());
    }

    private static void userInterface() {
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();

        switch (choice){
            case 1:
                System.out.println("+_____________Printing a collection___________________+");
                MOVIES.forEach(System.out::println);
                break;
            case 2:
                System.out.println("+________________Searching a movie_____________________+");
                searchMoviesByName(askName());
                break;
            case 3:
                sortCriteria();
                break;
            default:
                print("Wrong command");
                userInterface();
        }
    }

    private static String userAnswer(){
        String answer = "";
        Scanner sc = new Scanner(System.in);
        answer = sc.nextLine();
        return answer;
    }

    private static String askName() {
        print("Enter name of the movie:");
        return userAnswer();
    }
    private static void sortCriteria(){
        sortMenu();
        int choice = Integer.parseInt(userAnswer());
        Comparator cm = null;
        switch (choice){
            case 1:
                cm = Comparator.comparing(Movie::getYear);
                break;
            case 2:
                cm = Comparator.comparing(Movie::getName);
                break;
            case 3:
                cm = Comparator.comparing(Movie::getDirector);
                break;
        }
        MOVIES.sort(cm);
        MOVIES.forEach(e->print(e.toString()));
    }
    private static void sortMenu(){
        StringBuilder sb = new StringBuilder("Enter sorting way");
        sb.append(NEW_LINE);
        sb.append("1 - Sort by year").append(NEW_LINE);
        sb.append("2 - Sort by name").append(NEW_LINE);
        sb.append("3 - Sort by director").append(NEW_LINE);

        print(sb.toString());
    }

    private static void print(String message){
        System.out.println(message);
    }
    private static void searchMoviesByName(String str) {
        for (var movie : MOVIES){
            String name = movie.getName();
            if (movie.getName().toLowerCase().contains(str.toLowerCase())){
                System.out.printf("The %s movie is available\n", name);
            }
        }
    }

    private static void getRoles(){
        Map<Cast, Set<Movie>> map = new HashMap<>();

        Set<Cast> actors = new HashSet<>();
        MOVIES.forEach(e->actors.addAll(e.getCast()));

        actors.forEach(e->map.put(e, new HashSet<>()));

        MOVIES.forEach((e->e.getCast().forEach(c->map.get(c).add(e))));

        map.forEach((k,v)->print("\n"+k.getFullName() + ": " + v));
    }
}
