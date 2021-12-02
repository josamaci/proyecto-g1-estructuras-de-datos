package Matrix;
import java.util.Random;

public class Randomer {
    
    protected static Random r = new Random();
    protected static String alpha = "ABCDEFGHIJKMNLOPQRSTUVWXYZ";
    protected static String numbers = "0123456789";
    
    public static String getRdStr() {
        int n = r.nextInt(alpha.length());
        return Character.toString(alpha.charAt(n));
    }
    
    public static String getRdNum() {
        int n = r.nextInt(numbers.length());
        return Character.toString(numbers.charAt(n)); 
    }
    
    public static int getRdint(int limiter) {
        return r.nextInt(limiter);
    }
    
}
