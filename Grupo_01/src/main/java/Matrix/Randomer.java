package Matrix;
import java.util.Random;

public class Randomer {
    
    protected static Random r = new Random();
    protected static String alpha = "ABCDEFGHIJKMNLOPQRSTUVWXYZ";
    
    public static String getRdStr() {
        int n = r.nextInt(alpha.length());
        return Character.toString(alpha.charAt(n));
    }
    
    public static int getRdint() {
        return r.nextInt();
    }
    
}
