import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] map;
    static int[][] dp;
    static int res;

    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        map = new int[N][M];
        dp = new int[N][M];

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        res = 0;
        DFS(0,0,map[0][0]);
        res = dp[0][0]-1;

        bw.write(res+"");
        bw.flush();

    }


    public static void DFS(int x,int y,int h){

        if(dp[x][y]==0) {
            dp[x][y] = 1;
        }

        int sum = 0;

        for(int i=0; i<4; i++){

            int nx = x + dx[i];
            int ny = y + dy[i];

            if(!isIn(nx,ny)) continue;
            
            if(dp[nx][ny]==1){
                continue;
            }

            if(map[nx][ny]<h){

                if( nx == N-1 && ny == M-1 ){
                    dp[x][y]++;
                    continue;
                }

                if(dp[nx][ny]>1){
                    sum += dp[nx][ny]-1;
                    continue;
                }

                DFS(nx,ny,map[nx][ny]);
                if(dp[nx][ny]>1){
                    sum += dp[nx][ny]-1;
                }

            }

        }

        dp[x][y] += sum;

    }

    public static boolean isIn(int x,int y){
        if(x>=0&&x<N&&y>=0&&y<M){
            return true;
        }
        return false;
    }


}