import java.math.BigInteger;
import java.util.regex.Pattern;

public class SumBigInteger{
    public static void main (String[] args){
        BigInteger sum = new BigInteger("0");
        for (int i = 0; i < args.length; i++) {
            String[] a = args[i].split("\\p{javaWhitespace}+");
            for (int j = 0; j < a.length; j++){
                if (!a[j].isEmpty())
                    sum = sum.add(new BigInteger(a[j]));
            }
        }
        System.out.println(sum);
    }
}
