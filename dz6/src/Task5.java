import java.util.Arrays;

public class Task5 {
    public static void main(String[] args) {
        int[] arr = {-1, 2, 1, -4};
        int target = 1;

        Arrays.sort(arr);
        int[] bestTriplet = new int[3];
        int minDifference = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 2; i++) {
            int leftIdx = i + 1;
            int rightIdx = arr.length - 1;

            while (leftIdx < rightIdx) {
                int sum = arr[i] + arr[leftIdx] + arr[rightIdx];
                int diff = Math.abs(sum - target);

                if (diff == 0) {
                    System.out.printf("%d %d %d%n", arr[i], arr[leftIdx], arr[rightIdx]);
                    return;
                }

                if (diff < minDifference) {
                    minDifference = diff;
                    bestTriplet[0] = arr[i];
                    bestTriplet[1] = arr[leftIdx];
                    bestTriplet[2] = arr[rightIdx];
                }

                if (sum < target) {
                    leftIdx++;
                } else {
                    rightIdx--;
                }
            }
        }
        System.out.println(Arrays.toString(bestTriplet));
    }
}