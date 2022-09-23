package backjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1476 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int E = Integer.parseInt(input[0]);
        int S = Integer.parseInt(input[1]);
        int M = Integer.parseInt(input[2]);
        int e = 1;
        int s = 1;
        int m = 1;
        int ans = 1;

        while (true) {
            if (e == E && s == S && m == M) {
                System.out.println(ans);
                break;
            } else {
                e++;
                s++;
                m++;
                ans++;

                if (e > 15) {
                    e = 1;
                }
                if (s > 28) {
                    s = 1;
                }
                if (m > 19) {
                    m = 1;
                }
            }
        }
    }
}
