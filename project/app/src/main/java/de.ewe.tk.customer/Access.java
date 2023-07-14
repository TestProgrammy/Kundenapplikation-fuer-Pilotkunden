import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Access {
    // gefällt mir so nicht....
    private static String file = new File("").getAbsolutePath()
            + "\\app\\src\\main\\java\\de.ewe.tk.customer\\access.csv";
    private static String file2 = new File("").getAbsolutePath()
            + "\\project\\app\\src\\main\\java\\de.ewe.tk.customer\\access.csv";
    private static String file3 = getPath();
    static String user;
    static String password;

    public static boolean readFile() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            user = reader.readLine();
            password = reader.readLine();
            reader.close();
            return true;
        } catch (Exception e) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(file2));
                user = reader.readLine();
                password = reader.readLine();
                reader.close();
                return true;
            } catch (Exception e2) {
                return false;
            }
        }
    }

    private static String getPath() {
        return "";
    }
}