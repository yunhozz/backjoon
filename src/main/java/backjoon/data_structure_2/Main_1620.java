package backjoon.data_structure_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Main_1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Map<Integer, String> book1 = new HashMap<>();
        Map<String, Integer> book2 = new HashMap<>();
        String[] input = br.readLine().split(" ");

        for (int i = 1; i <= Integer.parseInt(input[0]); i++) {
            String str = br.readLine();
            book1.put(i, str);
            book2.put(str, i);
        }
        for (int i = 0; i < Integer.parseInt(input[1]); i++) {
            String str = br.readLine();

            if (book2.containsKey(str)) {
                bw.write(String.valueOf(book2.get(str)));

            } else {
                bw.write(book1.get(Integer.parseInt(str)));
            }
            bw.newLine();
        }
        bw.flush();
        bw.close();
    }
}