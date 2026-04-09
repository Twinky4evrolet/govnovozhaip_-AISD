import java.util.HashSet;
import java.util.Set;

public class Task6 {
    public static Integer getCommonElement(int[] first, int[] second, int[] third) {
        Set<Integer> set1 = new HashSet<>();
        for (int val : first) {
            set1.add(val);
        }

        Set<Integer> set2 = new HashSet<>();
        for (int val : second) {
            if (set1.contains(val)) {
                set2.add(val);
            }
        }

        for (int val : third) {
            if (set2.contains(val)) {
                return val;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 4};
        int[] arr2 = {2, 4, 6, 8};
        int[] arr3 = {2, 5, 7, 9};

        System.out.println(getCommonElement(arr1, arr2, arr3));
    }
}