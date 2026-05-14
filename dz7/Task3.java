public class Task3 {
    public static void main(String[] args) {
        String str = "abcdefghij";

        int prev = 1;
        int curr = 2;
        System.out.print(str.charAt(0));
        while (curr <= str.length()) {
            System.out.print(str.charAt(curr - 1));
            int next = prev + curr;
            prev = curr;
            curr = next;
        }
        System.out.println();
    }
}