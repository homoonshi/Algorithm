
import java.io.*;
import java.util.*;

public class Main {

    public static int[][] map;
    public static List<int[]> virus;
    public static List<int[]> space;
    public static int N, M;
    public static int[][] wall;
    public static int res;
    public static int count;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");
        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][M];
        virus = new ArrayList<>();
        space = new ArrayList<>();

        wall = new int[3][2];
        res = 0;
        count = 0;

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j]==0){
                    space.add(new int[]{i, j});
                    count++;
                }else if(map[i][j]==2){
                    virus.add(new int[]{i, j});
                }
            }
        }

        selectWall(0, 0);

        bw.write(res+"");
        bw.flush();

    }

    public static void selectWall(int count, int start){

        if(count == 3){
            int[][] m = new int[N][M];

            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    m[i][j] = map[i][j];
                }
            }

            for(int i=0; i<3; i++){
                m[wall[i][0]][wall[i][1]] = 1;
            }

            res = Math.max(res, virus(m));
            return;
        }

        if(start>=space.size() || space.size()-start < 3-count){
            return;
        }

        for(int i=start; i<space.size(); i++){
            int[] t = space.get(i);
            wall[count][0] = t[0];
            wall[count][1] = t[1];
            selectWall(count+1, i+1);
        }

    }

    public static int virus(int[][] m){
        int[] dx = {0, 0, 1, -1};
        int[] dy = {-1, 1, 0, 0};

        boolean[][] visit = new boolean[N][M];

        Deque<int[]> deque = new ArrayDeque<>();

        for (int[] v : virus) {
            deque.add(new int[]{v[0], v[1]});
        }

        int r = count - 3;

        while(!deque.isEmpty()){
            int[] t = deque.pollFirst();

            if(visit[t[0]][t[1]]) continue;
            visit[t[0]][t[1]] = true;

            for(int i=0; i<4; i++){
                int nx = t[0] + dx[i];
                int ny = t[1] + dy[i];

                if(!isIn(nx, ny) || m[nx][ny] == 1 || m[nx][ny] == 2) continue;

                m[nx][ny] = 2;
                deque.add(new int[]{nx, ny});
                r--;
            }
        }

        return r;
    }

    public static boolean isIn(int x,int y){
        if(x>=0 && x<N && y>=0 && y<M){
            return true;
        }
        return false;
    }

}