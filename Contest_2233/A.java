import java.io.*;
import java.util.*;

public class Main {

    static long intCeil(long x, long d) {
        return (x + d - 1) / d;
    }

    static void solve(Scanner sc) {
        long n = sc.nextLong();
        long x = sc.nextLong();
        long y = sc.nextLong();
        long t = sc.nextLong();

        long ans = intCeil(n, x + y);

        if (t * x <= n) {
            ans = Math.min(
                ans,
                intCeil(n - t * x, x + 10 * y) + t
            );
        }

        System.out.println(ans);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tests = sc.nextInt();

        while (tests-- > 0) {
            solve(sc);
        }

        sc.close();
    }
}
