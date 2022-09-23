package backjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main_10972 {

    static int N;
    static int[] num;

    static boolean nextNum() {
        int i = num.length - 1;
        int j = num.length - 1;

        while (i > 0 && num[i - 1] > num[i]) {
            i--;
        }
        if (i == 0) {
            return false;
        }
        while (num[j] < num[i - 1]) {
            j--;
        }
        swap(i - 1, j);
        j = num.length - 1;

        while (i < j) {
            swap(i, j);
            i++;
            j--;
        }
        return true;
    }

    static void swap(int idx1, int idx2) {
        int temp = num[idx1];
        num[idx1] = num[idx2];
        num[idx2] = temp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split(" ");
        num = Arrays.stream(input).mapToInt(Integer::parseInt).toArray();

        if (nextNum()) {
            for (int i = 0; i < N; i++) {
                System.out.print(num[i] + " ");
            }
        } else {
            System.out.println("-1");
        }
    }
}