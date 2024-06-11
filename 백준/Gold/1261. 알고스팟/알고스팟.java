import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int[][] dist;
    static boolean[][] visit;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");

        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        map = new int[M + 1][N + 1];
        dist = new int[M + 1][N + 1];
        visit = new boolean[M + 1][N + 1];

        for (int i = 1; i <= M; i++) {
            inputs = br.readLine().split("");
            for (int j = 1; j <= N; j++) {
                map[i][j] = Integer.parseInt(inputs[j - 1]);
                dist[i][j] = Integer.MAX_VALUE; // 거리 배열 초기화
            }
        }

        int result = BFS();

        bw.write(result + "");
        bw.flush();
    }

    public static int BFS() {

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{1, 1, 0});
        dist[1][1] = 0;

        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        while (!deque.isEmpty()) {
            int[] temp = deque.pollFirst();
            int x = temp[0];
            int y = temp[1];
            int c = temp[2];

            if (visit[x][y]) continue;
            visit[x][y] = true;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                int nc = c;

                if (!isIn(nx, ny)) continue;

                if (map[nx][ny] == 0) {
                    nc = c;
                } else if (map[nx][ny] == 1) {
                    nc = c + 1;
                }

                if (dist[nx][ny] > nc) {
                    dist[nx][ny] = nc;
                    if (map[nx][ny] == 0) {
                        deque.addFirst(new int[]{nx, ny, nc});
                    } else {
                        deque.addLast(new int[]{nx, ny, nc});
                    }
                }
            }
        }

        return dist[M][N];
    }

    public static boolean isIn(int x, int y) {
        return x > 0 && x <= M && y > 0 && y <= N;
    }
}
