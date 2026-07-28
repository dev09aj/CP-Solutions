import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();

            int[] cnt = new int[k];

            for (int i = 0; i < n; i++) {
                cnt[i % k] += s.charAt(i) - '0';
            }

            boolean ok = true;
            for (int r = 0; r < k; r++) {
                if (cnt[r] % 2 != 0) {
                    ok = false;
                    break;
                }
            }

            System.out.println(ok ? "YES" : "NO");
        }

        sc.close();
    }
}
