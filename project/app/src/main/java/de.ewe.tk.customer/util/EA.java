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
            return readInt(aufforderung);
        }
    }

    public static int readIntAllowEmpty(Object aufforderung) {
        System.out.print(aufforderung);
        String eingabe = "";
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            eingabe = input.readLine();
            return Integer.parseInt(eingabe);
        } catch (Exception exc) {
            if (eingabe.equals("")) {
                return Integer.MIN_VALUE;
            }
            return readInt(aufforderung);
        }
    }

    public static String readString(Object aufforderung) {
        System.out.print(aufforderung);
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
            return input.readLine();
        } catch (Exception e) {
            return readString(aufforderung);
        }
    }
}
