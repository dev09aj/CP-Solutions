import java.util.*;

public class Main {

    static void solve(Scanner sc) {
        int n = sc.nextInt();

        Integer[] a = new Integer[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        // Sort in descending order
        Arrays.sort(a, Collections.reverseOrder());

        // Check for duplicates
        for (int i = 0; i < n - 1; i++) {
            if (a[i].equals(a[i + 1])) {
                System.out.println("-1");
                return;
            }
        }

        // Print the array
        for (int x : a) {
            System.out.print(x + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        while (T-- > 0) {
            solve(sc);
        }

        sc.close();
    }
}
