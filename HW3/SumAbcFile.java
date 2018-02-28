import java.util.*;
import java.io.*;

public class SumAbcFile {
    public static void main (String[] args){
        Scanner in;
        int radix = 10;
        try {
            in = new Scanner(new File(args[0]), "UTF-8");
        }
        catch (ArrayIndexOutOfBoundsException | FileNotFoundException e) {
            System.err.println("Error occured: " + e.toString());
            in = new Scanner("");
        }
        int sum = 0;
        while (in.hasNextLine()) {
            String line = in.nextLine().toLowerCase();
            int i, j = 0;
            for (i = 0; i < line.length(); i++)
                if (Character.isWhitespace(line.charAt(i))){ 
                    if (i != j)
                        sum += convertAbcToInt(line.substring(j, i).toCharArray(), radix);
                    j = i + 1;                
                }
            
            if (i > 0 && !Character.isWhitespace(line.charAt(i - 1)))
                if (i != j) sum += convertAbcToInt(line.substring(j, i).toCharArray(), radix);
        }
        PrintWriter out;    
        try {
            out = new PrintWriter(new File(args[1]));
        }
        catch (FileNotFoundException | ArrayIndexOutOfBoundsException e) {
            out = new PrintWriter(System.out);
            System.err.println("Error occured: " + e.toString());
        }
        out.println(sum);
        out.close();
        in.close();
    }
    
    public static int convertAbcToInt(char[] digits, int radix) {
        int converted = 0;
        int mult = 1;
        for (int j = 0; j < digits.length; j++) {
            int convDigit = 0;
            if (Character.isLetter(digits[j]))
                convDigit = (digits[j] - 'a');
            else if (j == 0 && digits[j] == '-')
                mult = -1;
            converted += (int) Math.pow(radix, digits.length - j - 1) * convDigit;
        }
        return converted * mult;
    }
}
