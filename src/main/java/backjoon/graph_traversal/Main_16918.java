package backjoon.graph_traversal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_16918 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        char[][] board = new char[r][c];

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int i = 0; i < r; i++) {
            String[] input = br.readLine().split("");
            int idx = 0;

            for (String s : input) {
                board[i][idx++] = s.charAt(0);
            }
        }

        if (n % 2 == 0) {
            for (char[] b : board) {
                Arrays.fill(b, 'O');
            }

        } else {
            Queue<int[]> bomb = new LinkedList<>();

            for (int sec = 2; sec <= n; sec++) {
                if (sec % 2 == 1) {
                    for (int i = 0; i < r; i++) {
                        for (int j = 0; j < c; j++) {
                            if (board[i][j] == 'O') {
                                bomb.offer(new int[] {i, j});
                            }
                        }
                    }

                    for (char[] b : board) {
                        Arrays.fill(b, 'O');
                    }

                    while (!bomb.isEmpty()) {
                        int[] b = bomb.poll();
                        board[b[0]][b[1]] = '.';

                        for (int i = 0; i < 4; i++) {
                            int nx = b[0] + dx[i];
                            int ny = b[1] + dy[i];

                            if (nx >= 0 && ny >= 0 && nx < r && ny < c) {
                                if (board[nx][ny] == 'O') {
                                    board[nx][ny] = '.';
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) sb.append(board[i][j]);
            sb.append("\n");
        }

        System.out.println(sb);
    }
}