
import java.io.*;
import java.util.*;

public class Main {

    static int m, n;
    static int[][] map;
    static int[][] visited;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);

        map = new int[m][n];
        visited = new int[m][n];

        for(int i=0; i<m; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(input[j]);
                visited[i][j] = -1;
            }
        }

        int res = BFS();
        bw.write(res+"");
        bw.flush();
    }

    public static int BFS(){
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};

        if(map[0][0]==-1){
            return -1;
        }else if(m==1 && n==1){
            return map[0][0];
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.add(new int[]{0, 0, map[0][0]});

        while (!pq.isEmpty()) {
            int[] temp = pq.poll();
            int x = temp[0], y = temp[1], cost = temp[2];

            if (x == m - 1 && y == n - 1) return cost;

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (!isIn(nx, ny) || map[nx][ny] == -1) continue;

                int newCost = cost + map[nx][ny];

                if (visited[nx][ny] == -1 || visited[nx][ny] > newCost) {
                    visited[nx][ny] = newCost;
                    pq.add(new int[]{nx, ny, newCost});
                }
            }
        }

        return -1;
    }

    public static boolean isIn(int x, int y){
        if(x>=0 && x<m && y>=0 && y<n){
            return true;
        }
        return false;
    }

}