package backjoon.divide_and_conquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1074 {

    static int count = 0;

    static void func(int r, int c, int size) {
        if (size == 1) {
            return;
        }

        int halfSize = size / 2;

        if (r < halfSize && c < halfSize) {
            func(r, c, halfSize);
        }

        if (r < halfSize && c >= halfSize) {
            count += (int) Math.pow(halfSize, 2);
            func(r, c - halfSize, halfSize);
        }

        if (r >= halfSize && c < halfSize) {
            count += (int) Math.pow(halfSize, 2) * 2;
            func(r - halfSize, c, halfSize);
        }

        if (r >= halfSize && c >= halfSize) {
            count += (int) Math.pow(halfSize, 2) * 3;
            func(r - halfSize, c - halfSize, halfSize);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 크기
        int r = Integer.parseInt(st.nextToken()); // 행
        int c = Integer.parseInt(st.nextToken()); // 열

        func(r, c, (int) Math.pow(2, n));
        System.out.println(count);
    }
}