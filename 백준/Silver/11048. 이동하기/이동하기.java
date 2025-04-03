
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

        int[][] map = new int[N+1][M+1];

        for(int i=1; i<=N; i++){
            input = br.readLine().split(" ");
            for(int j=1; j<=M; j++){
                map[i][j] = Integer.parseInt(input[j-1]);
            }
        }

        int[][] dp = new int[N+1][M+1];

        int[] dx = {1, 0, 1};
        int[] dy = {0, 1, 1};

        dp[1][1] = map[1][1];

        for(int i=1; i<=N; i++){
            for(int j=1; j<=M; j++){

                for(int k=0; k<3; k++){

                    int nx = i + dx[k];
                    int ny = j + dy[k];

                    if(!isIn(nx, ny)){
                        continue;
                    }

                    dp[nx][ny] = Math.max(dp[nx][ny], dp[i][j] + map[nx][ny]);

                }

            }
        }

        bw.write(dp[N][M]+"");
        bw.flush();

    }

    public static boolean isIn(int x, int y){
        if(x>=1 && x<=N && y>=1 && y<=M){
            return true;
        }
        return false;
    }
}