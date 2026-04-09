import java.util.Scanner;
import java.util.Stack;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();
        Scanner wordScanner = new Scanner(inputLine);

        Stack<String> wordStack = new Stack<>();
        while (wordScanner.hasNext()) {
            wordStack.push(wordScanner.next());
        }

        while (!wordStack.isEmpty()) {
            System.out.println(wordStack.pop());
        }
    }
}