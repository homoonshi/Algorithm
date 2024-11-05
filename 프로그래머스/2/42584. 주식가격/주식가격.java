import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<int[]> deque = new ArrayDeque<>();
        
        for(int i=0; i<prices.length; i++){
            
            while(!deque.isEmpty() && prices[i]<deque.peekLast()[1]){
                
                int[] temp = deque.pollLast();
                answer[temp[0]] = i-temp[0];
                
            }
            
            deque.addLast(new int[]{i, prices[i]});
            
        }
        
        while(!deque.isEmpty()){
            int[] temp = deque.pollLast();
            answer[temp[0]] = prices.length-temp[0]-1;
        }
        
        return answer;
    }
}