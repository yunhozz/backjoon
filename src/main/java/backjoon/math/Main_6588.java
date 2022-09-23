package backjoon.math;

import java.io.IOException;
import java.util.Scanner;

public class Main_6588 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int[] sosu = new int[1000001]; // 0 ~ 1000000
        sosu[1] = 1;

        for (int i = 2; i <= 1000000; i++) {
            for (int j = 2; i * j <= 1000000; j++) {
                if (sosu[i * j] == 0) {
                    sosu[i * j] = 1;
                }
            }
        }

        while (true) {
            int num = sc.nextInt();
            boolean flag = false;

            if (num == 0) {
                break;
            }
            for (int i = 2; i <= num / 2; i++) {
                if (sosu[i] == 0 && sosu[num - i] == 0) {
                    System.out.println(num + " = " + i + " + " + (num - i));
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                System.out.println("Goldbach's conjecture is wrong.");
            }
        }
    }
}