package backjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10815 {

    static int[] deck, arr;
    static StringBuilder sb = new StringBuilder();

    static void func(int card, int start, int end) {
        if (start > end) {
            sb.append(0).append(" ");
            return;
        }
        int mid = (start + end) / 2;
        if (deck[mid] > card) {
            func(card, start, mid - 1);
        }
        else if (deck[mid] < card) {
            func(card, mid + 1, end);
        }
        else {
            sb.append(1).append(" ");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] input1 = br.readLine().split(" ");
        int M = Integer.parseInt(br.readLine());
        String[] input2 = br.readLine().split(" ");

        deck = new int[N];
        arr = new int[M];
        int idx = 0;

        for (String s : input1) {
            deck[idx++] = Integer.parseInt(s);
        }
        idx = 0;
        for (String s : input2) {
            arr[idx++] = Integer.parseInt(s);
        }
        Arrays.sort(deck);
        for (int n : arr) {
            func(n, 0, deck.length - 1);
        }
        System.out.println(sb);
    }
}