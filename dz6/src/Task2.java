import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int val = scanner.nextInt();
        int expectedSquare = scanner.nextInt();

        System.out.println(calculateSquareBitwise(val) == expectedSquare);
    }

    private static int calculateSquareBitwise(int n) {
        int multiplicand = Math.abs(n);
        int multiplier = Math.abs(n);
        int sum = 0;

        while (multiplier > 0) {
            if ((multiplier & 1) == 1) {
                sum += multiplicand;
            }
            multiplicand <<= 1;
            multiplier >>= 1;
        }
        return sum;
    }
}