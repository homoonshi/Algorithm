import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] stones, int k) {
        
        int answer = Integer.MAX_VALUE;
        
        int max = 0;
        int maxIndex = 0;
        int nextMaxIndex = 0;
        int endIndex = 0;
        
        for(int i=0; i<stones.length; ){
            
            max = stones[nextMaxIndex];
            maxIndex = nextMaxIndex;
            nextMaxIndex = i+1;
            
            if(i+k <= stones.length){
                for(int j=endIndex+1; j<i+k; j++){
                    endIndex = j;
                    if(max<=stones[j]){
                        max = stones[j];
                        maxIndex = j;
                        nextMaxIndex = j+1;
                    }
                    if(nextMaxIndex < j && stones[nextMaxIndex] <= stones[j]){
                        nextMaxIndex = j;
                    }
                    if(max>=answer){
                        break;
                    }
                }      
                if(max>=answer){
                    i = maxIndex+1;
                    nextMaxIndex = maxIndex+1;
                    continue;
                }
            }else{
                break;
            }
            
            answer = Math.min(answer, max);
            i = maxIndex+1;

        }
        
        return answer;
    }
}