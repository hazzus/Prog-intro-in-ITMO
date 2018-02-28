import java.util.*;
import java.io.*;
import java.lang.*;

public class WordStatCount {
    public static void main(String[] args) {
        Scanner in;
        try {
            in = new Scanner(new File(args[0]), "UTF-8");
        }
        catch (FileNotFoundException | ArrayIndexOutOfBoundsException e) {
            in = new Scanner("");
            System.err.println("Error occured: " + e.toString());
        }
        Map <String, Integer> words = new LinkedHashMap <String, Integer>();
        while (in.hasNextLine()) {
            char[] newLine = in.nextLine().toCharArray();
            int j = 0, i;
            for (i = 0; i < newLine.length; i++) {
                if (!(Character.isLetter(newLine[i]) || Character.getType(newLine[i]) == Character.DASH_PUNCTUATION || newLine[i] == '\'')) {
                    if (i != j) addToMap(words, new String(newLine, j, i - j).toLowerCase());
                    j = i + 1;
                }
            }
            i--;
            if (i > 0 && (Character.isLetter(newLine[i]) || Character.getType(newLine[i]) == Character.DASH_PUNCTUATION || newLine[i] == '\''))
                if (i != j) addToMap(words, new String(newLine, j, i - j + 1).toLowerCase());
        }
        PrintWriter out;
        try {
            out = new PrintWriter(new File(args[1]));
        }
        catch (FileNotFoundException | ArrayIndexOutOfBoundsException | SecurityException e ) {
            out = new PrintWriter(System.out);
            System.err.println("Error occured: " + e.toString());
        }
        
        words = sortByValue(words);
        
        for (String key : words.keySet())
            out.println(key + " " + words.get(key));
        out.close();
        in.close();
    }
    
    public static void addToMap (Map <String, Integer> map, String key) {
        if (map.containsKey(key)) {
            int val = map.get(key);
            map.replace(key, ++val);
        }
        else
            map.put(key, 1);
    }
    
    public static Map<String, Integer> sortByValue(Map<String, Integer> map)
    {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        list.sort(Comparator.comparingInt(Map.Entry::getValue) );

        Map<String, Integer> result = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list){
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
            
