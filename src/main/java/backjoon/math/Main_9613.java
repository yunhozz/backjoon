package backjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9613 {

    static int gcd(int a, int b) {
        if (a == 0) return b;
        return gcd(b % a, a);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            long sum = 0;

            for (int j = 1; j < n; j++) {
                for (int k = j + 1; k < n + 1; k++) {
                    int a = Integer.parseInt(input[j]);
                    int b = Integer.parseInt(input[k]);
                    sum += gcd(a, b);
                }
            }

            System.out.println(sum);
        }
    }
}