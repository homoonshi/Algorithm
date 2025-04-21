import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[] money) {
        int answer = 0;
        
        int num = money.length;
        long[] dp = new long[n+1];
        
        for(int i = 0; i<num; i++){
            dp[money[i]]++;
            for(int j=money[i]; j<=n; j++){
                dp[j] += dp[j-money[i]];
            }
        }
            
        answer = (int) dp[n] % 1000000007;
        return answer;
    }
}