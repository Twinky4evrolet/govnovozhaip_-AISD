import java.util.Arrays;

public class Task5 {
    public static void main(String[] args) {
        int[] nails = {3, 4, 12, 6, 14, 13};
        Arrays.sort(nails);
        int count = nails.length;
        int[] dp = new int[count];
        dp[1] = nails[1] - nails[0];
        if (count > 2) {
            dp[2] = nails[2] - nails[0];
            for (int i = 3; i < count; i++) {
                dp[i] = Math.min(dp[i-1], dp[i-2]) + (nails[i] - nails[i-1]);
            }
        }
        System.out.println(dp[count - 1]);
    }
}