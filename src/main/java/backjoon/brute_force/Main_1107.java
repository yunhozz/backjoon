package backjoon.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1107 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); // 이동하려는 채널 (0 ~ 500000)
        int M = Integer.parseInt(br.readLine()); // 고장난 버튼의 개수
        String[] error = new String[0];

        if (M != 0) {
            error = br.readLine().split(" "); // 고장난 버튼 입력
        }
        int[] arr = new int[1000000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i;
        }
        for (int num : arr) {
            String numStr = String.valueOf(num);
            for (String e : error) {
                if (numStr.contains(e)) {
                    arr[num] = -1;
                    break;
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        if (N != 100) {
            int d = Math.abs(N - 100);
            for (int num : arr) {
                if (num != -1) {
                    int click = String.valueOf(num).length() + Math.abs(N - num);
                    ans = Math.min(ans, click);
                }
            }
            System.out.println(Math.min(ans, d));
        } else {
            System.out.println(0);
        }
    }
}