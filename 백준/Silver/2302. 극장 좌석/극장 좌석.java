
import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] dp; // 0 본인자리, 1 왼쪽, 2 오른쪽
    static int[] off;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        dp = new int[N+1][3];
        off = new int[N+1];

        for(int i=0; i<M; i++){
            int vip = Integer.parseInt(br.readLine());
            off[vip] = 1;
        }

        int result = position(1, 0);
        if(off[1] == 0){
            result += position(1, 2);
        }

        bw.write(result+"");
        bw.flush();

    }

    public static int position(int p, int d){

        if(p == N){
            if(d==0 || d==1) {
                return 1;
            }
            return 0;
        }

        if(d==0){
            if(dp[p+1][0]!=0){
                dp[p][0] += dp[p+1][0];
            }else{
                dp[p][0] += position(p+1, 0);
            }
            if(dp[p+1][2]!=0){
                dp[p][0] += dp[p+1][2];
            }else{
                if(off[p+1]!=1) {
                    dp[p][0] += position(p + 1, 2);
                }
            }
            return dp[p][0];
        }

        if(d==1){
            if(dp[p+1][0]!=0){
                dp[p][1] += dp[p+1][0];
            }else{
                dp[p][1] += position(p+1, 0);
            }
            if(dp[p+1][2]!=0){
                dp[p][1] += dp[p+1][2];
            }else{
                if(off[p+1]!=1) {
                    dp[p][1] += position(p+1, 2);
                }
            }
            return dp[p][1];
        }

        if(d==2){
            if(dp[p+1][1]!=0){
                dp[p][2] += dp[p+1][1];
            }else{
                if(off[p+1]!=1) {
                    dp[p][2] += position( p+1, 1);
                }
            }
            return dp[p][2];
        }

        return 0;
    }

}
