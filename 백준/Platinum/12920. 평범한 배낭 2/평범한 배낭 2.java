
import java.io.*;
import java.util.*;

public class Main {

    static int[][] dp;
    static int N, M;
    static List<int[]> items;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        items = new ArrayList<>();

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            int V = Integer.parseInt(input[0]); // 무게
            int C = Integer.parseInt(input[1]); // 만족도
            int K = Integer.parseInt(input[2]); // 개수
            for(int j=1; K > 0; j <<= 1){
                int c = Math.min(j, K);
                items.add(new int[]{V*c, C*c});
                K -= c;
            }
        }

        dp = new int[items.size()+1][M+1];

        for(int i=1; i<=items.size(); i++){
            int[] item = items.get(i-1);
            int v = item[0]; // 무게
            int c = item[1]; // 만족도
            dp[i][v] = c;
            for(int j=1; j<=M; j++){
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                dp[i][j] = Math.max(dp[i][j], dp[i][j-1]);
                if(j-v > 0){
                    int vv = dp[i-1][j-v] + c;
                    if(vv > dp[i][j]){
                        dp[i][j] = vv;
                    }
                }
            }
        }

        bw.write(dp[items.size()][M]+"");
        bw.flush();

    }
}