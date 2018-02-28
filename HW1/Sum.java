import java.util.*;

//right way is to do it by symbol, but you can also use this:
public class Sum{
    public static void main (String[] args){
        int sum = 0;
        for (int i = 0; i<args.length; i++) {
            args[i]=args[i].replaceAll("\\p{javaWhitespace}+"," ");
            args[i]=args[i].trim();
            String[] a = args[i].split(" ");
            for (int j = 0; j<a.length; j++){
                if (!a[j].isEmpty())
                    sum+=Integer.parseInt(a[j]);
            }
        }
        System.out.println(sum);
    }
}
