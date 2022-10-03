package backjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10815 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[] input1 = br.readLine().split(" ");
        int M = Integer.parseInt(br.readLine());
        String[] input2 = br.readLine().split(" ");

        int[] deck = new int[N];
        int[] arr = new int[M];
        int idx = 0;

        for (String s : input1) {
            deck[idx++] = Integer.parseInt(s);
        }
        idx = 0;

        for (String s : input2) {
            arr[idx++] = Integer.parseInt(s);
        }
        Arrays.sort(deck);

        for (int num : arr) {
            int min = 0;
            int max = deck.length - 1;
            boolean flag = false;

            while (min <= max && !flag) {
                int mid = (min + max) / 2;

                if (num < deck[mid]) {
                    max = mid - 1;
                } else if (num > deck[mid]) {
                    min = mid + 1;
                } else {
                    flag = true;
                    sb.append(1).append("\n");
                }
            }
            if (!flag) {
                sb.append(0).append("\n");
            }
        }
        System.out.println(sb);
    }
}