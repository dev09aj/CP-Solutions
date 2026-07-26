import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int c = sc.nextInt();

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Arrays.sort(a);

            for (int i = 0; i < n; i++) {
                a[i] -= c;
            }

            for (int i = 0; i < n / 2; i++) {
                a[i] = Math.max(a[i], 0);
            }

            long sum = 0;
            for (int x : a) {
                sum += x;
            }

            System.out.println(sum);
        }

        sc.close();
    }
}
