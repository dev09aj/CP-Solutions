import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();

            int x = 10000;
            int y = 0;

            for (int i = 0; i < n; ++i) {
                int z = sc.nextInt();

                x = Math.min(x, z);
                y += x;
            }

            System.out.println(y);
        }

        sc.close();
    }
}
