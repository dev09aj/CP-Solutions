import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            long[] a = new long[n];
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(st.nextToken());
            }

            long ans = 1000000000L;
            long sum = 0;

            for (int i = 0; i < n; i++) {
                sum += a[i];

                ans = Math.min(ans, sum / (i + 1));

                System.out.print(ans + " ");
            }

            System.out.println();
        }
    }
}
