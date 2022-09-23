package backjoon.math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2609 {

    public static int func(int max, int min) {
        if (max % min != 0) {
            int r = max % min;
            return func(min, r);
        } else {
            return min;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);
        int ans = func(Math.max(a, b), Math.min(a, b));

        System.out.println(ans);
        System.out.println(ans * (a / ans) * (b / ans));
    }
}
