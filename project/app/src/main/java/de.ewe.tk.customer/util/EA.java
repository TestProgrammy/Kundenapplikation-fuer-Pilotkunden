package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class EA {
    // von IO.java geholt und angepasst
    public static int readInt(Object aufforderung) {
        System.out.print(aufforderung);
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            String eingabe = input.readLine();
            return Integer.parseInt(eingabe);
        } catch (Exception exc) {
            return readInt(String.format("Falsche Eingabe. %s", aufforderung));
        }
    }

    public static String readString(Object aufforderung) {
        System.out.print(aufforderung);
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            return input.readLine();
        } catch (Exception e) {
            return readString(String.format("Falsche Eingabe. %s", aufforderung));
        }
    }
}
