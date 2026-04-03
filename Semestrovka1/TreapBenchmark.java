import java.util.Random;

public class TreapBenchmark {
    public static void main(String[] args) {
        int minN = 100;
        int maxN = 10000;
        int step = 100;
        int runsPerSet = 20;

        Random random = new Random();
        System.out.println("N;Insert_Avg_ns;Search_Avg_ns;Delete_Avg_ns");
        warmUp(random);

        for (int n = minN; n <= maxN; n += step) {
            long totalInsertTime = 0;
            long totalSearchTime = 0;
            long totalDeleteTime = 0;

            for (int run = 0; run < runsPerSet; run++) {
                Treap onlineUsers = new Treap();
                int[] userIDs = new int[n];

                for (int i = 0; i < n; i++) {
                    userIDs[i] = random.nextInt(1_000_000);
                }

                long start = System.nanoTime();
                for (int id : userIDs) {
                    onlineUsers.insert(id);
                }
                totalInsertTime += (System.nanoTime() - start);

                start = System.nanoTime();
                for (int id : userIDs) {
                    onlineUsers.contains(id);
                }
                totalSearchTime += (System.nanoTime() - start);

                start = System.nanoTime();
                for (int id : userIDs) {
                    onlineUsers.delete(id);
                }
                totalDeleteTime += (System.nanoTime() - start);
            }

            long avgInsert = totalInsertTime / (runsPerSet * n);
            long avgSearch = totalSearchTime / (runsPerSet * n);
            long avgDelete = totalDeleteTime / (runsPerSet * n);

            System.out.printf("%d;%d;%d;%d%n", n, avgInsert, avgSearch, avgDelete);
        }
    }

    private static void warmUp(Random random) {
        Treap dummy = new Treap();
        for (int i = 0; i < 10000; i++) {
            dummy.insert(random.nextInt());
        }
    }
}