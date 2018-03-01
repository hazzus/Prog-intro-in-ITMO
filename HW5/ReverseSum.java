import java.util.*;

public class ReverseSum {
    public static void main(String[] args) {
        List<String> s = new ArrayList<String>();
        int len = 0;
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            s.add(sc.nextLine());
            len++;
        }

        List<Integer> sumCol = new ArrayList<Integer>();
        int[] lenLine = new int[len];
        int maxLenLine = 0;
        List all = new ArrayList<ArrayList<Integer>>();
        int j = 0;
        while (sc.hasNextLine()) {
            String[] str = sc.nextLine().split(" ");
            int z = 0;
            int sumLine = 0;
            all.add(new ArrayList<Integer>());
            for(int i = 0; i < str.length; i++){
                if (!str[i].isEmpty()){
                    int nextS = Integer.parseInt(str[i]);
                    all.get(j).add(nextS);
                    sumLine += nextS;
                    if (z + 1 > maxLenLine) {
                        sumCol.add(nextS);
                        maxLenLine = z + 1;
                    }
                    else
                        sumCol.set(z, sumCol.get(z) + nextS);
                    z++;
                }
            }
            lenLine[j] = z;
            for (int i = 0; i < lenLine[j]; i++)
                all[j][i] = sumLine - all[j][i];
        j++;
        }
        for (int i = 0; i < len; i++) {
            for (j = 0; j < lenLine[i]; j++) {
                System.out.print(sumCol.get(j) + all.get(i)[j] + " ");
            }
            System.out.println();
        }

    }
}
