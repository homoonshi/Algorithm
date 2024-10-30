import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        
        int currentWeight = 0;
        Deque<Integer> deque = new ArrayDeque<>();
        int minIndex = 0;
        
        for(int i=0; i<truck_weights.length; i++){
            answer++;
            if(!deque.isEmpty() && deque.peekFirst() == answer){
                currentWeight -= truck_weights[minIndex++];
                deque.pollFirst();
            }

            while(currentWeight + truck_weights[i] > weight){
                currentWeight -= truck_weights[minIndex++];
                answer = deque.pollFirst();
            }
            
            deque.addLast(answer+bridge_length);
            currentWeight += truck_weights[i];
            
        }
        
        if(!deque.isEmpty()){
            answer = deque.pollLast();
        }
        
        return answer;
    }
}