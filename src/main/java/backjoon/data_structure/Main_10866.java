package backjoon.data_structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main_10866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        LinkedList<Integer> dq = new LinkedList<>();

        int N = Integer.parseInt(br.readLine());

        for (int n = 0; n < N; n++) {
            String[] input = br.readLine().split(" ");

            switch (input[0]) {
                case "push_front" :
                    dq.offerFirst(Integer.parseInt(input[1]));
                    break;

                case "push_back" :
                    dq.offerLast(Integer.parseInt(input[1]));
                    break;

                case "pop_front" :
                    if (dq.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(dq.pollFirst()).append("\n");
                    }
                    break;

                case "pop_back" :
                    if (dq.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(dq.pollLast()).append("\n");
                    }
                    break;

                case "size" :
                    sb.append(dq.size()).append("\n");
                    break;

                case "empty" :
                    if (dq.isEmpty()) {
                        sb.append(1).append("\n");
                    } else {
                        sb.append(0).append("\n");
                    }
                    break;

                case "front" :
                    if (dq.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(dq.peekFirst()).append("\n");
                    }
                    break;

                case "back" :
                    if (dq.isEmpty()) {
                        sb.append(-1).append("\n");
                    } else {
                        sb.append(dq.peekLast()).append("\n");
                    }
                    break;
            }
        }
        System.out.println(sb);
    }
}