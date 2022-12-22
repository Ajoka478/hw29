package task3.info;

public class Director implements Comparable<Director>{
    private String fullName;
    public String getFullName(){
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return
                "Director = " + fullName;
    }
    @Override
    public int compareTo(Director o) {
        return this.getFullName().compareTo(o.getFullName());
    }

}

