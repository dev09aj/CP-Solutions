import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String s = br.readLine();

            boolean is = true;
            int left = 0, right = n - 1;

            while (left < n && s.charAt(left) == '0') left++;
            while (right >= 0 && s.charAt(right) == '1') right--;

            if (left > right) {
                System.out.println("Bob");
                continue;
            }

            int count = 1;
            for (int i = left; i < right; i++) {
                if (s.charAt(i + 1) == s.charAt(i)) {
                    count++;
                } else {
                    if (count % 2 == 1) is = false;
                    count = 1;
                }
            }

            if (count % 2 == 1) is = false;

            System.out.println(is ? "Bob" : "Alice");
        }
    }
}
