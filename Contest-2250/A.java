import java.util.*;

public class Main {

    static void work(Scanner sc) {
        int n = sc.nextInt();

        long L = 0;
        long R = 1000000001L;

        for (int i = 1; i <= n; i++) {
            long w = sc.nextLong();

            if (i % 2 == 1) {
                R = Math.min(R, w);
            } else {
                L = Math.max(L, w);
            }
        }

        System.out.println(n % 2 == 0 && L + 2 <= R ? "YES" : "NO");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            work(sc);
        }

        sc.close();
    }
}
