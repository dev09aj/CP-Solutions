import java.util.*;

public class Main {

    static void solve(Scanner sc) {
        int n = sc.nextInt();

        long[] a = new long[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextLong();
        }

        long[] d = new long[n - 1];

        for (int i = 0; i < n - 1; i++) {
            d[i] = a[i + 1] - a[i];
        }

        for (int i = 0; i < n - 1; ) {
            int j = i;

            while (j < n - 1 && 
                   ((d[j] & 1) == (d[i] & 1))) {
                j++;
            }

            Arrays.sort(d, i, j);
            i = j;
        }

        StringBuilder sb = new StringBuilder();

        sb.append(a[0]).append(" ");

        long cur = a[0];

        for (int i = 0; i < n - 1; i++) {
            cur += d[i];
            sb.append(cur).append(" ");
        }

        System.out.println(sb);
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
