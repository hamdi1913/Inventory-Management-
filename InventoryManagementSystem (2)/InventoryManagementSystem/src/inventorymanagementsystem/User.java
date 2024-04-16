package inventorymanagementsystem;
/**
 * @author Hamdi
 */
public class User {
    String username;
    private int password;
    private String devision;

     boolean isAdmin;

    public User(String username, int password, String devision, boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.devision = devision;
        this.isAdmin = isAdmin;
    }

    public String getUsername() {
        return username;
    }

    public int getPassword() {
        return password;
    }

    public String getDevision() {
        return devision;
    }

    public boolean isAdmin() {
        return isAdmin;
    }
    public void setUsername(String username) {
        this.username = username;
    }    
    public void setPassword(int password) {
        this.password = password;
    }

    public void setDevision(String department) {
        this.devision = department;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}