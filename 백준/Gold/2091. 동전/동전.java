
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int[][] coins = new int[5][2];

        int X = Integer.parseInt(input[0]);

        coins[1][0] = 1;
        coins[2][0] = 5;
        coins[3][0] = 10;
        coins[4][0] = 25;

        coins[1][1] = Integer.parseInt(input[1]);
        coins[2][1] = Integer.parseInt(input[2]);
        coins[3][1] = Integer.parseInt(input[3]);
        coins[4][1] = Integer.parseInt(input[4]);

        int[][] dp = new int[5][X + 1];

        for (int i = 1; i <= 4; i++){
            for(int j = 1; j <= coins[i][1]; j++){
                if(coins[i][0]*j > X){
                    break;
                }
                dp[i][coins[i][0]*j] = j;
            }
        }

        for (int i = 2; i <= 4; i++) {
            int use = 1;
            int start = 0;
            for (int j = 1; j <= X; j++) {
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j]);
                if (coins[i][0] <= j) {
                    if (start > 0 && (j - start) % coins[i][0] == 0) {
                        use++;
                    }
                    if (dp[i][j - coins[i][0]] > 0 && dp[i][j - coins[i][0]] + 1 > dp[i][j] && coins[i][1] >= use) {
                        dp[i][j] = dp[i][j - coins[i][0]] + 1;
                        if (start == 0 && dp[i-1][j]==0) {
                            start = j;
                        }
                    }else if(dp[i-1][j] == 0 && dp[i][j] > 0 && start == 0){
                        start = j;
                    }
                }
            }
        }

        int x = 4;
        int y = X;

        int[] res = new int[5];

        while (x != 0 && y != 0) {
            if (y - coins[x][0] >= 0 && dp[x][y - coins[x][0]] + 1 == dp[x][y]) {
                res[x]++;
                y -= coins[x][0];
            } else {
                x--;
            }
        }

        for (int i = 1; i <= 4; i++) {
            bw.write(res[i] + " ");
        }


        bw.flush();

    }
}