public class Task1 {
    public static void main(String[] args) {
        int[] numbers = {1, 3, 5, 7, 9};
        int targetValue = 6;
        int resultIndex = -1;

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] <= targetValue) {
                resultIndex = i;
            } else {
                break;
            }
        }
        System.out.println(resultIndex);
    }
}