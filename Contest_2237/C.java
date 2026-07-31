import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static String next() throws IOException {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(br.readLine());
        }
        return st.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt(next());
    }

    static void run() throws IOException {
        int n = nextInt();
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = nextInt();
        }

        long ans = 0;

        for (int i = 0; i < n; i++) {
            if (ans > a[i]) {
                ans += a[i];
            } else {
                ans = a[i];
            }
        }

        System.out.println(ans);
    }

    public static void main(String[] args) throws Exception {
        int T = nextInt();
        while (T-- > 0) {
            run();
        }
    }
}
