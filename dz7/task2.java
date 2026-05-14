public class task2 {
    public static void main(String[] args) {
        int n = 13;
        int periodLimit = n % 60;

        if (periodLimit == 0) {
            System.out.println(0);
            return;
        }

        int prev = 0;
        int curr = 1;

        for (int i = 2; i <= periodLimit; i++) {
            int nextVal = (prev + curr) % 10;
            prev = curr;
            curr = nextVal;
        }

        System.out.println(curr);
    }
}