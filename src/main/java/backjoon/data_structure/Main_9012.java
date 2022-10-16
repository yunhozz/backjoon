package backjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_9012 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> st = new Stack<>();
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String[] input = br.readLine().split("");
            boolean flag = true;

            for (String s : input) {
                if (s.equals("(")) {
                    st.push(0);
                } else {
                    if (st.empty()) {
                        System.out.println("NO");
                        flag = false;
                        break;
                    } else {
                        st.pop();
                    }
                }
            }
            if (flag) {
                if (st.empty()) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            }
            st.clear();
        }
    }
}