import java.util.*;

public class ReverseSum {
    public static void main(String[] args) {
        String[] s = new String[0];
        int len = 0;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            s = addStrToArray(s, sc.nextLine());
            len++;
        }
        int[] sumLine = new int[len];
        int[] sumCol = new int[0];
        int[] lenLine = new int[len];
        int maxLenLine = 0;
        int[][] all = new int[len][100000];
        for (int j = 0; j < len; j++) {
            String[] str = s[j].split(" ");
            int z = 0;
            for(int i = 0; i < str.length; i++){
                int nextS = Integer.parseInt(str[i]);
                all[i][z] = nextS;
                sumLine[j] += nextS;
                if (z + 1 > maxLenLine) {
                    sumCol = addIntToArray(sumCol, nextS);
                    maxLenLine = z + 1;
                }
                else
                    sumCol[z] += nextS;
                z++;
            }
            lenLine[j] = z;
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < lenLine[i]; j++) {
                System.out.print(sumLine[i] + sumLine[j] - all[i][j] + " ");
            }
            System.out.println();
        }

    }

    public static String[] addStrToArray(String[] a, String news) {
        int len = a.length;
        String[] b = new String[len + 1];
        for (int i = 0; i < len; i++)
            b[i] = a[i];
        b[len] = news;
        a = null;
        return b;
    }

    public static int[] addIntToArray(int[] a, int news) {
        int len = a.length;
        int[] b = new int[len + 1];
        for (int i = 0; i < len; i++)
            b[i] = a[i];
        b[len] = news;
        a = null;
        return b;
    }

}
