package backjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] input = br.readLine().split(" ");
        int[] arr = new int[n];
        int idx = 0;

        for (String s : input) {
            arr[idx++] = Integer.parseInt(s);
        }

        Arrays.sort(arr);
        int left = 0, right = n - 1;
        int sum, temp = Integer.MAX_VALUE;
        int ans1 = 0, ans2 = 0;

        while (left < right) {
            sum = arr[left] + arr[right];
            if (Math.abs(sum) < temp) {
                temp = Math.abs(sum);
                ans1 = arr[left];
                ans2 = arr[right];
            }

            if (sum > 0) right--;
            else left++;
        }

        System.out.println(ans1 + " " + ans2);
    }
}