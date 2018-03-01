import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Scanner {
    InputStreamReader in;

    Scanner (InputStream name) {
         try {
             in = new InputStreamReader(name, "UTF-8");
         }
         catch (UnsupportedEncodingException e) {
             System.err.println("Error: " + e.toString());
             new InputStreamReader(System.in);
         }
    }

    public boolean hasNextLine() {
        try {
            return in.ready();
        } catch (IOException e) {
            System.err.print("Error:" + e.toString());
            return false;
        }
    }

    public String nextLine() {
        int c = 0;
        try {
            c = in.read();
        } catch (IOException e) {
            System.err.print("Error:" + e.toString());
            return "";
        }
        StringBuilder word = new StringBuilder();
        while (c != -1 && c != '\n') {
            word.append((char) c);
            try {
                c = in.read();
            } catch (IOException e) {
                System.err.print("Error:" + e.toString());
                c = -1;
            }
        }

        return word.toString();
    }
}
