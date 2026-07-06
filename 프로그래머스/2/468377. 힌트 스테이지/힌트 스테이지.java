import java.io.*;
import java.util.*;

class Solution {
    
    static int[] saveHint;
    static int n;
    static int answer;
    
    public int solution(int[][] cost, int[][] hint) {
        answer = Integer.MAX_VALUE;
        n = cost.length;
        
        saveHint = new int[n+1];
        
        recursion(cost, hint, 0, 0);
        
        return answer;
    }
    
    public void recursion(int[][] cost, int[][] hint, int depth, int coin){
          
        if(depth == n){
            answer = Math.min(answer, coin);
            return;
        }
        
        int ticket = saveHint[depth] >= n ? n-1 : saveHint[depth];
        
        coin += cost[depth][ticket];
        recursion(cost, hint, depth+1, coin);
        
        if(depth == n-1){
            return;
        }
        
        coin += hint[depth][0];
        for(int i=1; i<hint[depth].length; i++){
            saveHint[hint[depth][i]-1]++;
        }
        recursion(cost, hint, depth+1, coin);
        
        for(int i=1; i<hint[depth].length; i++){
            saveHint[hint[depth][i]-1]--;
        }
        coin -= hint[depth][0];
        
    }
}