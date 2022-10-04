package backjoon.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main_19637 {

    static class Type {
        String name;
        long power;

        public Type(String name, long power) {
            this.name = name;
            this.power = power;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String[] input1 = br.readLine().split(" ");
        int N = Integer.parseInt(input1[0]); // 칭호 개수
        int M = Integer.parseInt(input1[1]); // 캐릭터 개수

        List<Type> types = new ArrayList<>();

        for (int n = 0; n < N; n++) {
            String[] input2 = br.readLine().split(" ");
            Type type = new Type(input2[0], Long.parseLong(input2[1]));
            types.add(type);
        }
        for (int m = 0; m < M; m++) {
            long power = Long.parseLong(br.readLine());
            int min = 0;
            int max = types.size() - 1;

            while (min <= max) {
                int mid = (min + max) / 2;

                if (power > types.get(mid).power) {
                    min = mid + 1;
                } else {
                    max = mid - 1;
                }
            }
            sb.append(types.get(min).name).append("\n");
        }
        System.out.println(sb);
    }
}