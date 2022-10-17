package backjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_1935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] input = br.readLine().split("");

        Stack<Double> st = new Stack<>();
        double[] val = new double[N];
        int idx = 0;

        for (int n = 0; n < N; n++) {
            val[n] = Double.parseDouble(br.readLine());
        }

        for (String s : input) {
            switch (s) {
                case "+" :
                    st.push(st.pop() + st.pop());
                    break;

                case "-" :
                    Double a = st.pop();
                    Double b = st.pop();
                    st.push(b - a);
                    break;

                case "*" :
                    st.push(st.pop() * st.pop());
                    break;

                case "/" :
                    Double c = st.pop();
                    Double d = st.pop();
                    st.push(d / c);
                    break;

                default:
                    if (idx < val.length) {
                        st.push(val[idx]);
                        idx++;
                    } else {
                        st.push(val[idx-1]);
                    }
            }
        }
        System.out.printf("%.2f", st.pop());
    }
}