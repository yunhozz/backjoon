package backjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_2504 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<String> st = new Stack<>();
        String[] input = br.readLine().split("");

        int ans = 0;
        int temp = 1;
        boolean isValid = true;

        for (int i = 0; i < input.length; i++) {
            String str = input[i];

            if (str.equals("(")) {
                st.push(str);
                temp *= 2;

            } else if (str.equals("[")) {
                st.push(str);
                temp *= 3;

            } else {
                if (st.isEmpty()) {
                    isValid = false;
                    break;
                }

                if (str.equals(")")) {
                    if (!st.peek().equals("(")) {
                        isValid = false;
                        break;
                    }
                    if (input[i - 1].equals("(")) {
                        ans += temp;
                    }
                    st.pop();
                    temp /= 2;

                } else if (str.equals("]")) {
                    if (!st.peek().equals("[")) {
                        isValid = false;
                        break;
                    }
                    if (input[i - 1].equals("[")) {
                        ans += temp;
                    }
                    st.pop();
                    temp /= 3;
                }
            }
        }

        if (isValid && st.isEmpty()) {
            System.out.println(ans);

        } else {
            System.out.println(0);
        }
    }
}