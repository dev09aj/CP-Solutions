import java.io.*;
import java.util.*;

public class Main {
    static FastScanner fs = new FastScanner(System.in);

    static void solve() throws IOException {
        int n = fs.nextInt();

        int mx = Integer.MIN_VALUE;
        int mn = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int x = fs.nextInt();
            mx = Math.max(mx, x);
            mn = Math.min(mn, x);
        }

        System.out.println((mx - mn + 1) / 2);
    }

    public static void main(String[] args) throws Exception {
        int t = fs.nextInt();
        while (t-- > 0) {
            solve();
        }
    }

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream is) {
            in = is;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c;
            while ((c = read()) <= ' ') {
                if (c == -1) return -1;
            }
            int sign = 1;
            if (c == '-') {
                sign = -1;
                c = read();
            }
            int val = 0;
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }
    }
}
