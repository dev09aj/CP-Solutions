import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            long a = sc.nextLong();
            long b = sc.nextLong();
            long x = sc.nextLong();

            long INF = (long) 1e18;
            long ans = INF;
            long i = 0;

            while (a != b) {
                if (b > a) {
                    long temp = a;
                    a = b;
                    b = temp;
                }

                ans = Math.min(ans, Math.abs(a - b) + i);

                a /= x;
                i++;
            }

            ans = Math.min(ans, i);

            System.out.println(ans);
        }

        sc.close();
    }
}
