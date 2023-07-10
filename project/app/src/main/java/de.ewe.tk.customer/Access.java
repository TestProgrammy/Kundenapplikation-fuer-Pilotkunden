import java.io.BufferedReader;
import java.io.FileReader;

public class Access {
    public static String user = "Testuser";// readFile(0);
    public static String password = "Test123456*";// readFile(1);

    public static String readFile(int num) throws Exception {
        String file = "access.csv";
        String value;
        BufferedReader reader = new BufferedReader(new FileReader(file));
        final String user = reader.readLine();
        final String password = reader.readLine();
        reader.close();
        if (num == 0) {
            value = user;
        } else {
            value = password;
        }
        return value;
    }
}