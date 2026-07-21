import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);
        int t = 0;
        
        for(int[] temp : targets){
            if(t<=temp[0]){
                t = temp[1];
                answer++;
            }
        }
        
        return answer;
    }
}