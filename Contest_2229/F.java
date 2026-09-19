import java.io.*;
import java.util.*;

public class Main {

    static void solve() throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int n = fs.nextInt();
        int k = fs.nextInt();

        long[] aa = new long[n];
        for (int i = 0; i < n; i++) {
            aa[i] = fs.nextLong();
        }

        Arrays.sort(aa);

        n--;

        long extra = aa[n];

        long[] temp = new long[n];
        System.arraycopy(aa, 0, temp, 0, n);
        aa = temp;

        long L = 0;
        long R = extra * (long) n;

        while (L != R) {
            long mid = (L + R + 1) / 2;

            int size = 1 << n;

            int[] dpFirst = new int[size];
            long[] dpSecond = new long[size];

            for (int i = 1; i < size; i++) {

                for (int j = 0; (1 << j) <= i; j++) {

                    if ((i & (1 << j)) == 0)
                        continue;

                    int res = i ^ (1 << j);

                    int curFirst = dpFirst[res];
                    long curSecond = dpSecond[res] + aa[j];

                    if (curSecond >= mid) {
                        curFirst++;
                        curSecond = 0;
                    }

                    // Equivalent to:
                    // dp[i] = max(dp[i], cur)
                    if (curFirst > dpFirst[i] ||
                        (curFirst == dpFirst[i] && curSecond > dpSecond[i])) {

                        dpFirst[i] = curFirst;
                        dpSecond[i] = curSecond;
                    }
                }
            }

            if (dpFirst[size - 1] >= k)
                L = mid;
            else
                R = mid - 1;
        }

        System.out.println(L + extra);
    }

    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);

        int tt = fs.nextInt();

        while (tt-- > 0) {
            solveWithScanner(fs);
        }
    }

    static void solveWithScanner(FastScanner fs) throws Exception {

        int n = fs.nextInt();
        int k = fs.nextInt();

        long[] aa = new long[n];

        for (int i = 0; i < n; i++) {
            aa[i] = fs.nextLong();
        }

        Arrays.sort(aa);

        n--;

        long extra = aa[n];

        long[] b = new long[n];
        System.arraycopy(aa, 0, b, 0, n);
        aa = b;

        long L = 0;
        long R = extra * (long) n;

        while (L != R) {

            long mid = (L + R + 1) / 2;

            int size = 1 << n;

            int[] dpFirst = new int[size];
            long[] dpSecond = new long[size];

            for (int i = 1; i < size; i++) {

                for (int j = 0; (1 << j) <= i; j++) {

                    if ((i & (1 << j)) == 0)
                        continue;

                    int res = i ^ (1 << j);

                    int curFirst = dpFirst[res];
                    long curSecond = dpSecond[res] + aa[j];

                    if (curSecond >= mid) {
                        curFirst++;
                        curSecond = 0;
                    }

                    if (curFirst > dpFirst[i] ||
                        (curFirst == dpFirst[i] &&
                         curSecond > dpSecond[i])) {

                        dpFirst[i] = curFirst;
                        dpSecond[i] = curSecond;
                    }
                }
            }

            if (dpFirst[size - 1] >= k)
                L = mid;
            else
                R = mid - 1;
        }

        System.out.println(L + extra);
    }

    static class FastScanner {
        private final InputStream in;
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;

        FastScanner(InputStream in) {
            this.in = in;
        }

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;

                if (len <= 0)
                    return -1;
            }

            return buffer[ptr++];
        }

        long nextLong() throws IOException {
            int c;

            do {
                c = read();
            } while (c <= ' ');

            boolean negative = false;

            if (c == '-') {
                negative = true;
                c = read();
            }

            long res = 0;

            while (c > ' ') {
                res = res * 10 + (c - '0');
                c = read();
            }

            return negative ? -res : res;
        }

        int nextInt() throws IOException {
            return (int) nextLong();
        }
    }
}
