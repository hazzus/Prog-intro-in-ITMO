import java.util.*;

public class ReverseMax {
    public static void main(String[] args) {
        List <String> s = new ArrayList <String>();
        int len = 0;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            s.add(sc.nextLine());
            len++;
        }
        int[] maxLine = new int[len];  
        List <Integer> maxCol = new ArrayList <Integer>();
        int[] lenLine = new int[len];
        int maxLenLine = 0;
        for (int j = 0; j < len; j++) {
            Scanner str = new Scanner (s.get(j));
            int z = 0;
            while (str.hasNextInt()) {
                int o = str.nextInt();
                if (z == 0) maxLine[j] = o;
                else 
                    if (o > maxLine[j]) maxLine[j] = o;
                if (z + 1 > maxLenLine) {
                    maxCol.add(o);
                    maxLenLine = z + 1;
                }
                else
                    if (o > maxCol.get(z)) maxCol.set(z,o);
                z++;
            }
            lenLine[j] = z;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < lenLine[i]; j++) {
                if (maxLine[i] > maxCol.get(j)) 
                    System.out.print(maxLine[i] + " ");
                else
                    System.out.print(maxCol.get(j) + " ");
            }
            System.out.println();
        }
        
    }
    
}
