import java.util.*;

public class Reverse {
    public static void main(String[] args) {
        List <String> s = new ArrayList <String>();
        //String[] s1 = new String[0];
        int i = 0;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            s.add(sc.nextLine());
            //s1 = addToArray(s1,sc.nextLine());
            i++;
        }
        for (int j = i-1; j >= 0; j--) {
            String[] a = s.get(j).split(" ");
            for (int k = a.length - 1; k >=0; k--)
                System.out.print(a[k]+" ");
            System.out.println();
        }
    }
    
    public static String[] addToArray(String[] a, String news) {
        int len = a.length;
        String[] b = new String[len + 1];
        for (int i = 0; i < len; i++)
            b[i] = a[i];
        b[len] = news;
        a = null;
        return b;
    }
}
