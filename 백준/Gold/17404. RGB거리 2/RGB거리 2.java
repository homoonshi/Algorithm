
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][][] dp = new int[3][3][N];
        int[][] paint = new int[N][3];

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            paint[i][0] = Integer.parseInt(input[0]);
            paint[i][1] = Integer.parseInt(input[1]);
            paint[i][2] = Integer.parseInt(input[2]);
        }

        dp[0][0][0] = paint[0][0];
        dp[1][1][0] = paint[0][1];
        dp[2][2][0] = paint[0][2];

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i==j){
                    continue;
                }
                dp[i][j][1] = dp[i][i][0] + paint[1][j];
            }
        }

        for(int i=2; i<N-1; i++){
            for(int j=0; j<3; j++){
                for(int k=0; k<3; k++){
                    int beforeMin = Integer.MAX_VALUE;
                    int another1 = dp[j][(k+1)%3][i-1];
                    int another2 = dp[j][(k+2)%3][i-1];
                    if(another1 == 0){
                        beforeMin = another2;
                    }else if(another2 == 0){
                        beforeMin = another1;
                    }else{
                        beforeMin = Math.min(another1, another2);
                    }
                    dp[j][k][i] = beforeMin + paint[i][k];
                }
            }
        }

        int result = Integer.MAX_VALUE;

        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(i==j){
                    continue;
                }
                for(int k=0; k<3; k++){
                    if(j==k){
                        continue;
                    }
                    if(dp[i][k][N-2] == 0){
                        continue;
                    }
                    dp[i][j][N-1] = dp[i][k][N-2] + paint[N-1][j];
                    result = Math.min(result, dp[i][j][N-1]);
                }
            }
        }

        bw.write(result+"");
        bw.flush();

    }

}
