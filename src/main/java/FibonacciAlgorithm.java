import java.util.ArrayList;
import java.util.List;

/**
 * Created by iuriis on 05.07.2016.
 */
public class FibonacciAlgorithm {

    public static long fibRecurs(int n) {
        if (n <= 1) {
            return n;
        }
        return fibRecurs(n - 1) + fibRecurs(n - 2);
    }
    public static long fibList(int n){
        if (n<=1){
            return n;
        }
        long[] fibList = new long[n+1];
        fibList[0] = 0;
        fibList[1] = 1;
        for(int i = 2 ; i <= n;i++){
            fibList[i]=fibList[i-1]+fibList[i-2];
        }
        return fibList[n];
    }
}
