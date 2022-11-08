package backjoon.data_structure_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main_4358 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();

        int size = 0;

        while (true) {
            String tree = br.readLine();

            if (tree == null || tree.length() == 0) {
                break;
            }
            size++;

            if (map.containsKey(tree)) {
                map.replace(tree, map.get(tree) + 1);

            } else {
                map.put(tree, 1);
            }
        }
        List<Map.Entry<String, Integer>> entries = map.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toList());

        for (Map.Entry<String, Integer> entry : entries) {
            sb.append(entry.getKey())
                    .append(" ")
                    .append(String.format("%.4f", (double) entry.getValue() / size * 100))
                    .append("\n");
        }
        System.out.println(sb);
    }
}