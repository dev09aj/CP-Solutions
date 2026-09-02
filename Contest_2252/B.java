import java.io.*;
import java.util.*;

public class Main {

    static void solve(Scanner sc) {
        int n = sc.nextInt();
        String s = sc.next();

        int n0 = 0, n1 = 0;

        for (char c : s.toCharArray()) {
            if (c == '0') {
                n0++;
            } else {
                n1++;
            }
        }

        int deltaN = n0 - n1;

        if (Math.abs(deltaN) > 2) {
            System.out.println(-1);
            return;
        }

        int L = 1;
        int L0 = (s.charAt(0) == '0') ? 1 : 0;
        int L1 = (s.charAt(0) == '1') ? 1 : 0;

        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                L++;

                if (s.charAt(i) == '0') {
                    L0++;
                } else {
                    L1++;
                }
            }
        }

        int deltaL = L0 - L1;

        int ans = (n - L) + Math.max(0, Math.abs(deltaN - deltaL) - 1);

        System.out.println(ans);
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
