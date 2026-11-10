package bank;

public class Account {
    public String name;
    protected String email; // Can be accessed by everyone in this package but only by sub-classes in other packages
    private String password; // Can be accessed only inside class Account

    // getters and setters
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String pass) {
        this.password = pass;
    }
}