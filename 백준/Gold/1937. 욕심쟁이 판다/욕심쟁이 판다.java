import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static int n;
    static int map[][];
    static int dp[][];
    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input;

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];

        for(int i=0; i<n; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<n; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        result = 0;
        int count;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                count = DFS(i,j,map[i][j],1);
                result = Math.max(result, count);
            }
        }

        bw.write(result+"");
        bw.flush();

    }

    public static int DFS(int x,int y,int num, int count) {

        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};

        int nx,ny;
        int result = count;

        for (int i = 0; i < 4; i++) {

            nx = x + dx[i];
            ny = y + dy[i];

            if (!isIn(nx, ny)||map[nx][ny]<num) continue;

            if (map[nx][ny] > num) {
                if (dp[nx][ny]!=0){
                    result = Math.max(result, count+dp[nx][ny]);
                    continue;
                }
                result = Math.max(result,DFS(nx,ny,map[nx][ny],count+1));

            }

        }

        dp[x][y] = result-count+1;
        return result;
    }

    public static boolean isIn(int x,int y){
        if(x>=0&&x<n&&y>=0&&y<n){
            return true;
        }
        return false;
    }

}