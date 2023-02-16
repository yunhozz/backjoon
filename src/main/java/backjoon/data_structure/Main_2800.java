package backjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class Main_2800 {

    static TreeSet<String> answer = new TreeSet<>();

    static class Node {
        private final int open;
        private final int close;

        public Node(int open, int close) {
            this.open = open;
            this.close = close;
        }
    }

    static void func(int count, List<Node> nodes, boolean[] check, char[] input) {
        if (count >= nodes.size()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < input.length; i++) {
                if (!check[i]) {
                    sb.append(input[i]);
                }
            }

            answer.add(sb.toString());
            return;
        }

        Node node = nodes.get(count);
        check[node.open] = true;
        check[node.close] = true;
        func(count + 1, nodes, check, input);

        check[node.open] = false;
        check[node.close] = false;
        func(count + 1, nodes, check, input);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Integer> st = new Stack<>();
        char[] input = br.readLine().toCharArray();
        List<Node> nodes = new ArrayList<>();

        for (int i = 0; i < input.length; i++) {
            char c = input[i];
            if (c == '(') {
                st.push(i);
            } else if (c == ')') {
                nodes.add(new Node(i, st.pop()));
            }
        }

        boolean[] check = new boolean[input.length];
        func(0, nodes, check, input);

        boolean first = true;
        for (String ans : answer) {
            if (first) {
                first = false;
                continue;
            }

            sb.append(ans).append("\n");
        }

        System.out.println(sb);
    }
}