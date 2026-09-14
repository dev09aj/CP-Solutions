import java.io.*;
import java.util.*;

public class Main {

    static final int N = 5000;

    static int n;
    static int[] l = new int[N + 10];
    static int[] r = new int[N + 10];
    static int[] u = new int[N + 10];
    static int[] v = new int[N + 10];

    static boolean check(int m) {
        int j = 1;

        for (int i = 1; i <= n && j <= m; ++i) {
            int x = m - j + 1;

            if ((j < l[i] || j > r[i]) &&
                (x < u[i] || x > v[i])) {
                ++j;
            }
        }

        return j == m + 1;
    }

    static void work(FastScanner fs) throws Exception {
        n = fs.nextInt();

        for (int i = 1; i <= n; ++i) {
            l[i] = fs.nextInt();
            r[i] = fs.nextInt();
            u[i] = fs.nextInt();
            v[i] = fs.nextInt();
        }

        for (int m = n; m >= 1; --m) {
            if (!check(m)) {
                continue;
            }

            System.out.println(m);
            return;
        }

        System.out.println(0);
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int T = fs.nextInt();

        while (T-- > 0) {
            work(fs);
        }
    }

    // Fast input for competitive programming
    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0;
        private int len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;

                if (len <= 0) {
                    return -1;
                }
            }

            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;

            do {
                c = read();
            } while (c <= ' ');

            int sign = 1;

            if (c == '-') {
                sign = -1;
                c = read();
            }

            int result = 0;

            while (c > ' ') {
                result = result * 10 + (c - '0');
                c = read();
            }

            return result * sign;
        }
    }
}
