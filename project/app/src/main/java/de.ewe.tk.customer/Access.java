import java.io.BufferedReader;
import java.io.FileReader;

public class Access {
    private static String file = "C:/Users/XEDUSOLD/Kundenapplikation-fuer-Pilotkunden/project/app/src/main/java/de.ewe.tk.customer/access.csv";
    public static String user;
    public static String password;

    public static boolean readFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            user = reader.readLine();
            password = reader.readLine();
            reader.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}