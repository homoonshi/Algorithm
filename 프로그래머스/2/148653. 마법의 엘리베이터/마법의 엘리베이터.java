import java.io.*;
import java.util.*;

class Solution {
    public int solution(int storey) {
        int end = 0;
        
        while((int)(storey/Math.pow(10, end))>0){
            end++;
        }
        
        int[][] dp = new int[end+1][2];
        for(int i=0; i<=end; i++){
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        
        for(int start=1; start<=end; start++){
            int p = (int) Math.pow(10, start);
            int stand = (storey % p) / (p/10);
            if(start==1){
                dp[start][0] = stand;
                dp[start][1] = 10-stand;
                continue;
            }
            for(int i=0; i<2; i++){
                dp[start][0] = Math.min
                                (dp[start][0],
                                 dp[start-1][i] + (stand+i)
                                );
                dp[start][1] = Math.min
                                (dp[start][1],
                                 dp[start-1][i] + (10-(stand+i))
                                );
            }
        }
        
        return Math.min(dp[end][0], dp[end][1]+1);
    }
}