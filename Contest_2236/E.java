import java.util.*;

public class Main {
    static void solve(Scanner sc) {
        int n = sc.nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt() - 1;
        }

        boolean[][] able = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            int[] used = new int[n];
            int mn = a[i];
            int mx = a[i];

            for (int j = i; j < n; j++) {
                if (used[a[j]] == 1) break;

                used[a[j]] = 1;
                mn = Math.min(mn, a[j]);
                mx = Math.max(mx, a[j]);

                if (mx - mn == j - i) {
                    able[mn][mx] = true;
                }
            }
        }

        for (int ans = n; ans > 0; ans--) {
            for (int i = 0; i + 2 * ans <= n; i++) {
                if (able[i][i + ans - 1] && able[i + ans][i + 2 * ans - 1]) {
                    System.out.println(ans);
                    return;
                }
            }
        }

        System.out.println(0);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {
            solve(sc);
        }

        sc.close();
    }
}
