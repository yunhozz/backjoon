package backjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1978 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        int ans = 0;

        for (int n = 0; n < N; n++) {
            int num = Integer.parseInt(input[n]);
            int i;

            if (num == 1) {
                continue;
            }
            for (i = 2; i < Math.sqrt(num); i++) {
                if (num % i == 0) {
                    break;
                }
            }
            if (i > Math.sqrt(num)) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}