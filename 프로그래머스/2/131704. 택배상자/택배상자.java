import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] order) {
        int answer = 0;
        Deque<Integer> container = new ArrayDeque<>();
        
        for(int i=1; i<=order.length; i++){
            
            container.addLast(i);
            
            while(!container.isEmpty() &&
                  container.peekLast()==order[answer]){
                container.pollLast();
                answer++;
            }
        
        }
        
        return answer;
    }
}