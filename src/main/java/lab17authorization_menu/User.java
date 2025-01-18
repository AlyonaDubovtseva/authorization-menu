package lab17authorization_menu;

public class User {
    String login;
    String password;
    Role role;

    public User(String login, String password, Role role) {
        this.login = login;
        this.role = role;
        this.password = password;
    }
}
