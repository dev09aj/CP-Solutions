import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            boolean ans = false;

            for (int i = 1; i <= n; i++) {
                int x = sc.nextInt();

                if (x == 100) {
                    ans = true;
                }
            }

            if (ans) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

        sc.close();
    }
}
