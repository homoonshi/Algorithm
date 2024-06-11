
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input;

        int T = 0;

        while(true){

            T++;
            N = Integer.parseInt(br.readLine());

            if(N==0){
                break;
            }

            map = new int[N][N];

            for(int i=0; i<N; i++){
                input = br.readLine().split(" ");
                for(int j=0; j<N; j++){
                    map[i][j] = Integer.parseInt(input[j]);
                }
            }

            int result = BFS();
            bw.write("Problem "+T+": "+result+"\n");

        }

        bw.flush();

    }

    public static int BFS(){

        boolean[][] visit = new boolean[N][N];
        int[][] dist = new int[N][N];

        for(int i=0; i<N; i++){
            Arrays.fill(dist[i],Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.add(new int[]{0, 0, map[0][0]});
        dist[0][0] = map[0][0];

        int nx,ny,nc;
        int[] temp;

        int[] dx = {1,0,0,-1};
        int[] dy = {0,1,-1,0};

        while(!pq.isEmpty()) {

            temp = pq.poll();

            int x = temp[0];
            int y = temp[1];
            int c = temp[2];

            if (visit[x][y]) continue;
            visit[x][y] = true;

            for(int i=0; i<4; i++){

                nx = temp[0] + dx[i];
                ny = temp[1] + dy[i];

                if(!isIn(nx,ny)) continue;

                nc = temp[2] + map[nx][ny];

                if (dist[nx][ny] > nc) {
                    dist[nx][ny] = nc;
                    pq.add(new int[]{nx, ny, nc});
                }

            }

        }

        return dist[N-1][N-1];

    }

    public static boolean isIn(int x,int y){
        if(x>=0&&x<N&&y>=0&&y<N){
            return true;
        }
        return false;
    }

}
