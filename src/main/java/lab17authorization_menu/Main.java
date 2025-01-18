package lab17authorization_menu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    private static final String ADMIN_LOGIN = "Admin_Alyona@gmail.com";
    private static final String ADMIN_PASSWORD = "BOSS+12345";
    private static final String USER_LOGIN = "User_Galina228@gmail.com";
    private static final String USER_PASSWORD = "00000000";

    public static void main(String[] args) {

    }

    public static void UserCheck(String login, String password) throws WrongLoginException, WrongPasswordException {
        String regex = "";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(login);
    }


}
