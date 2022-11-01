package backjoon.data_structure_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main_14425 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        Set<String> strSet = new HashSet<>();
        int count = 0;

        for (int i = 0; i < Integer.parseInt(input[0]); i++) {
            strSet.add(br.readLine());
        }

        for (int i = 0; i < Integer.parseInt(input[1]); i++) {
            if (strSet.contains(br.readLine())) {
                count++;
            }
        }
        System.out.println(count);
    }
}