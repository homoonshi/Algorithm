import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long[][] dp;
    static int[][] map;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        map = new int[N][N];

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        dp = new long[N][N];

        dp[0][0] = tracking(0, 0);

        bw.write(dp[0][0]+"");
        bw.flush();

    }

    public static long tracking(int x, int y){

        int[] dx = {0, 1};
        int[] dy = {1, 0};

        if(x == N-1 && y == N-1){
            return 1;
        }

        if(map[x][y]==0){
            return 0;
        }

        if(dp[x][y] != 0){
            return dp[x][y];
        }

        for(int i=0; i<2; i++){

            int nx = x + dx[i] * map[x][y];
            int ny = y + dy[i] * map[x][y];

            if(!isIn(nx, ny)){
                continue;
            }

            dp[x][y] += tracking(nx, ny);

        }

        return dp[x][y];
    }

    public static boolean isIn(int x, int y){
        if(x>=0 && x<N && y>=0 && y<N){
            return true;
        }
        return false;
    }

}