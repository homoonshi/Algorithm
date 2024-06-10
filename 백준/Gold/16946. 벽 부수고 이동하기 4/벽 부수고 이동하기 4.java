import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int[][] indexMap;
    static int[] parent;
    static int[] size;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        long beforeTime = System.currentTimeMillis(); // 코드 실행 전에 시간 받아오기

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        map = new int[N][M];
        indexMap = new int[N][M];
        parent = new int[N * M];
        size = new int[N * M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j) - '0';
                int index = i * M + j;
                parent[index] = index;
                size[index] = 1;
            }
        }

        initUnionFind();
        count();

        bw.write(sb.toString());
        bw.flush();

    }

    public static void initUnionFind() {
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    int currentIndex = i * M + j;
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (isIn(x, y) && map[x][y] == 0) {
                            int neighborIndex = x * M + y;
                            union(currentIndex, neighborIndex);
                        }
                    }
                }
            }
        }
    }

    public static void count() {
        int[] dx = {1, 0, 0, -1};
        int[] dy = {0, 1, -1, 0};

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    Set<Integer> uniqueParents = new HashSet<>();
                    int count = 1;
                    for (int k = 0; k < 4; k++) {
                        int x = i + dx[k];
                        int y = j + dy[k];
                        if (isIn(x, y) && map[x][y] == 0) {
                            int neighborIndex = x * M + y;
                            int parentIndex = find(neighborIndex);
                            if (uniqueParents.add(parentIndex)) {
                                count += size[parentIndex];
                            }
                        }
                    }
                    sb.append(count % 10);
                } else {
                    sb.append("0");
                }
            }
            sb.append("\n");
        }
    }

    public static boolean isIn(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            if (size[rootX] < size[rootY]) {
                parent[rootX] = rootY;
                size[rootY] += size[rootX];
            } else {
                parent[rootY] = rootX;
                size[rootX] += size[rootY];
            }
        }
    }
}
