package backjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10799 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> st = new Stack<>();
        String[] input = br.readLine().split("");

        int num = 0; // 잘려진 막대기 개수

        for (int i = 0; i < input.length; i++) {
            if (input[i].equals("(")) {
                st.push(input[i]);
            } else {
                st.pop();

                if (input[i-1].equals("(")) {
                    num += st.size();
                } else {
                    num++;
                }
            }
        }
        System.out.println(num);
    }
}