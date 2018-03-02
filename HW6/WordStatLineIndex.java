import java.util.*;
import java.io.*;
import java.lang.*;

public class WordStatLineIndex {
    public static void main(String[] args) {
        try {
            Scanner in;
            try {
                in = new Scanner(new File(args[0]), "UTF-8");
            } catch (FileNotFoundException | ArrayIndexOutOfBoundsException e) {
                in = new Scanner(System.in);
                System.err.println("Error: " + e.toString());
            }
            //0 - кол-во, а остальные вхождения
            Map<String, List<String>> words = new LinkedHashMap<>();
            int schStr = 1;
            while (in.hasNextLine()) {
                char[] newLine = in.nextLine().toCharArray();
                int j = 0, i;
                int sch = 1;
                for (i = 0; i < newLine.length; i++) {
                    if (!(Character.isLetter(newLine[i]) || Character.getType(newLine[i]) == Character.DASH_PUNCTUATION || newLine[i] == '\'')) {
                        if (i != j) addToMap(words, new String(newLine, j, i - j).toLowerCase(), schStr, sch++);
                        j = i + 1;
                    }
                }
                i--;
                if (i > 0 && (Character.isLetter(newLine[i]) || Character.getType(newLine[i]) == Character.DASH_PUNCTUATION || newLine[i] == '\''))
                    if (i != j) addToMap(words, new String(newLine, j, i - j + 1).toLowerCase(), schStr, sch++);
                schStr++;
            }
            //PrintWriter out;
            try (PrintWriter out = new PrintWriter(new File(args[1]))) {
                
                words = sortByKey(words);
                for (String key : words.keySet()) {
                    out.print(key);
                    for (String i : words.get(key))
                        out.print(" " + i);
                    out.println();
                }
            } catch (FileNotFoundException | ArrayIndexOutOfBoundsException | SecurityException e) {
                
                System.err.println("Error: " + e.toString());
            }
            in.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.toString());
        }
    }

    public static void addToMap(Map<String, List<String>> map, String key, int numberStr, int number) {
        if (map.containsKey(key)) {
            List<String> values = map.get(key);
            values.add(numberStr + ":" + number);
            String am = Integer.toString(Integer.parseInt(values.get(0)) + 1);
            values.set(0, am);
            map.replace(key, values);
        } else {
            List<String> values = new ArrayList<String>();
            values.add("1");
            values.add(numberStr + ":" + number);
            map.put(key, values);
        }
    }

    public static Map<String, List<String>> sortByKey(Map<String, List<String>> map)
    {
        List<Map.Entry<String, List<String>>> list = new LinkedList<>(map.entrySet());
        list.sort(Comparator.comparing(Map.Entry::getKey) );

        Map<String, List<String>> result = new LinkedHashMap<>();
        for (Map.Entry<String, List<String>> entry : list){
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
