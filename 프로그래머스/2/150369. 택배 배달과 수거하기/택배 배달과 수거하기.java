import java.io.*;
import java.util.*;

class Solution {
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        Deque<int[]> delivery = new ArrayDeque<>();
        Deque<int[]> pickup = new ArrayDeque<>();
        
        for(int i=1; i<=n; i++){
            setMap(delivery, deliveries[i-1], i);
            setMap(pickup, pickups[i-1], i);
        }
        
        while(!delivery.isEmpty() || !pickup.isEmpty()){
            int distance = 0;            
            distance = deliver(delivery, distance, cap);
            distance = deliver(pickup, distance, cap);
            answer += (distance*2);
        }
        
        return answer;
    }
    
    private void setMap(Deque<int[]> map,int count,int index){
        if(count != 0){
            int[] temp = new int[2];
            temp[0] = index; 
            temp[1] = count;
            map.addLast(temp);
        }
    }
    
    private int deliver(Deque<int[]> map, int distance, int cap){
        int next = 0;
        while(!map.isEmpty()){
                int[] temp = map.pollLast();
                distance = Math.max(distance, temp[0]);
                if(next == 0){
                    temp[1] -= cap;
                }else{
                    temp[1] += next;
                }
                if(temp[1]>=0){
                    if(temp[1]>0){
                        map.addLast(temp);
                    }
                    break;
                }
                next = temp[1];
        }
        return distance;
    }
    
}