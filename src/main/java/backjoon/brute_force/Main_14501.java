package backjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_14501 {

    static int[] work, price;
    static int N;
    static int ans = 0;

    static void func(int day, int sum) {
        if (day == N + 1) {
            ans = Math.max(ans, sum);
            return;
        }
        if (day > N + 1) {
            return;
        }
        func(day + work[day], sum + price[day]);
        func(day + 1, sum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        work = new int[N + 1];
        price = new int[N + 1];

        for (int n = 1; n <= N; n++) {
            String[] input = br.readLine().split(" ");
            work[n] = Integer.parseInt(input[0]);
            price[n] = Integer.parseInt(input[1]);
        }
        func(1, 0);
        System.out.println(ans);
    }
}