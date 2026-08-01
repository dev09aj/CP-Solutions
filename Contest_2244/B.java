import java.util.*;

public class Main {

    static void I_love_feblokas(Scanner sc) {
        int n = sc.nextInt();
        long[] a = new long[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }

        long cur = 0;
        boolean ok = true;

        for (int i = 0; i < n; i++) {
            cur += a[i];
            long need = (long) (i + 1) * (i + 2) / 2;

            if (cur < need) {
                ok = false;
            }
        }

        if (ok) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int tc = sc.nextInt();

        while (tc-- > 0) {
            I_love_feblokas(sc);
        }

        sc.close();
    }
}
