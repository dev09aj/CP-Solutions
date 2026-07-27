import java.util.*;

public class Main {

    static final int INF = (int) 1e9;

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        String s = sc.next();

        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][0] = 0;

        for (int i = 0; i < n; i++) {
            int[][] ndp = new int[n + 1][n + 1];
            for (int j = 0; j <= n; j++) {
                Arrays.fill(ndp[j], INF);
            }

            for (int cntF = 0; cntF <= i; cntF++) {
                for (int curS = 0; curS <= i; curS++) {
                    if (dp[cntF][curS] == INF) continue;

                    if (s.charAt(i) != 'T') {
                        ndp[cntF + 1][curS + 1] = Math.min(
                                ndp[cntF + 1][curS + 1],
                                Math.max(dp[cntF][curS], curS + 1)
                        );
                    }

                    if (s.charAt(i) != 'F') {
                        int newS = Math.max(0, curS - 1);
                        ndp[cntF][newS] = Math.min(
                                ndp[cntF][newS],
                                dp[cntF][curS]
                        );
                    }
                }
            }

            dp = ndp;
        }

        int rs = 0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                rs = Math.max(rs, i - dp[i][j]);
            }
        }

        System.out.println(rs);
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
