import java.util.HashSet;
import java.util.Set;

public class FibonacciChecker{
    //Task1
    private static final int MAX = 1200000000;
    private static final Set<Integer> fibonacci_set = buildFibonacciSet();

    private static Set<Integer> buildFibonacciSet(){
        Set<Integer> set = new HashSet<>();
        int a = 1;
        int b = 2;
        set.add(a);
        set.add(b);
        while (true) {
            long nextlong = (long) a + (long) b;
            if (nextlong > MAX){
                break;
            }
            int next = (int) nextlong;
            set.add(next);
            a = b;
            b = next;
        }
        return set;
    }
    public static boolean isFibonacci(int n){
        if (n <= 2 || n > MAX){
            return false;
        }
        return fibonacci_set.contains(n);
    }
}