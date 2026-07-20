import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int k = sc.nextInt();

            int[] a = new int[k];
            int max = Integer.MIN_VALUE;
            int count2 = 0;

            for (int i = 0; i < k; i++) {
                a[i] = sc.nextInt();

                if (a[i] > max)
                    max = a[i];

                if (a[i] == 2)
                    count2++;
            }

            if (max > 2 || count2 > 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }

        sc.close();
    }
}
