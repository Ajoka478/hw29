package task3.info;

public class Cast {
    private String fullName;
    private String role;
    public String getFullName() {
        return fullName;
    }
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    @Override
    public String toString() {
        return String.format("Actor: %-10s | Role: %-10s", fullName, role);

    }
}

