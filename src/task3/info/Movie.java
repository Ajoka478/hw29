package task3.info;

import java.util.List;

public class Movie {
    private String name;
    private int year;
    private String description;
    private Director director;
    private List<Cast> castList;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }
    public void setYear(Integer year) {
        this.year = year;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Director getDirector() {
        return director;
    }
    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Cast> getCast() {
        return castList;
    }
    public void setCast(List<Cast> cast) {
        this.castList = cast;
    }


    @Override
    public String toString() {
        return  String.format("\n %-13s | %-5s | %-8s | %-17s | %-30s", name, year, description, director, castList);
    }


}


