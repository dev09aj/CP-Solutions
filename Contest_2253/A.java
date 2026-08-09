import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();

            boolean good = true;

            for (int j = 2; j <= n; j++) {
                if ((n + 1) % j == 0) {
                    good = false;
                }
            }

            if (good) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }

        sc.close();
    }
}
