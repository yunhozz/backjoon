package backjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1929 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int m = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        int[] sosu = new int[1000001]; // 0 ~ 1000000

        sosu[1] = 1;

        for (int i = 2; i <= 1000000; i++) {
            for (int j = 2; i * j <= 1000000; j++) {
                if (sosu[i * j] == 0) {
                    sosu[i * j] = 1;
                }
            }
        }

        for (int i = m; i <= n; i++) {
            if (sosu[i] == 0) {
                System.out.println(i);
            }
        }
    }
}