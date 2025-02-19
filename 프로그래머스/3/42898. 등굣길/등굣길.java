import java.io.*;
import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        
        int dp[][] = new int[m+1][n+1];
        int map[][] = new int[m+1][n+1];
        
        for(int i=0; i<puddles.length; i++){
            int x = puddles[i][0];
            int y = puddles[i][1];
            map[x][y] = 1;
        }
        
        dp[1][1] = 1;
        
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                if(map[i][j]==1){
                    continue;
                }
                dp[i][j] = Math.max(dp[i][j], dp[i-1][j] + dp[i][j-1]) % 1000000007;
            }
        }
        
        answer = dp[m][n];
        return answer;
    }
}