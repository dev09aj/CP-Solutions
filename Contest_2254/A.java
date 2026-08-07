import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        while (t-- > 0) {
            int[] v = new int[3];

            for (int i = 0; i < 3; i++) {
                v[i] = sc.nextInt();
            }

            Arrays.sort(v);

            System.out.println(Math.min(v[2] - v[1], v[1] - v[0]));
        }

        sc.close();
    }
}
