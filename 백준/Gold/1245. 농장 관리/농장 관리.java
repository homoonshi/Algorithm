import java.io.*;
import java.util.*;

public class Main {

    static int N, M;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        int[][] map = new int[N][M];

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        boolean[][] visit = new boolean[N][M];
        int res = 0;

        int[] dx = {0, 0, 1, -1, 1, -1, 1, -1};
        int[] dy = {1, -1, 0, 0, 1, -1, -1, 1};

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(visit[i][j]) continue;
                Deque<int[]> deque = new ArrayDeque<>();
                deque.addLast(new int[]{i, j});
                boolean top = true;
                visit[i][j] = true;
                while(!deque.isEmpty()){
                    int[] temp = deque.pollFirst();
                    int x = temp[0];
                    int y = temp[1];
                    for(int k=0; k<8; k++){
                        int nx = x + dx[k];
                        int ny = y + dy[k];
                        if(!isIn(nx, ny)) continue;
                        if(map[x][y] < map[nx][ny]){
                            top = false;
                            continue;
                        }
                        if(map[x][y] == map[nx][ny] && !visit[nx][ny]){
                            deque.addLast(new int[]{nx, ny});
                            visit[nx][ny] = true;
                        }
                    }
                }
                if(top) res++;
            }
        }

        bw.write(res+"");
        bw.flush();
    }

    static boolean isIn(int x, int y){
        if(x>=0 && x<N && y>=0 && y<M){
            return true;
        }
        return false;
    }

}