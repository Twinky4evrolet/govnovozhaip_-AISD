import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args){
        int[] test1 = {2, 3, 5, 7, 9, 69, 1199999999, 1300000000};
        for (int n : test1){
            System.out.println(n + "->" + FibonacciChecker.isFibonacci(n) );
        }
    }
}
