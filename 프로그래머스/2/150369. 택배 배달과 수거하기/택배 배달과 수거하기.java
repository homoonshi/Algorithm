import java.io.*;
import java.util.*;

class Solution {
    
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        
        Deque<int[]> delivery = new ArrayDeque<>();
        Deque<int[]> pickup = new ArrayDeque<>();
        
        int totalD = 0;
        int totalP = 0;
        
        for(int i=1; i<=n; i++){
            
            if(deliveries[i-1] != 0){
                int[] d = new int[2];
                d[0] = i; 
                d[1] = deliveries[i-1];
                delivery.addLast(d);
            }
            
            if(pickups[i-1] != 0){
                int[] p = new int[2];
                p[0] = i;
                p[1] = pickups[i-1];
                pickup.addLast(p);
            }
        }
        
        while(!delivery.isEmpty() || !pickup.isEmpty()){
            
            int distance = 0;
            int nextD = 0;
            int nextP = 0;
            
            distance = deliver(delivery, distance, cap);
            distance =deliver(pickup, distance, cap);
            
            answer += (distance*2);
        }
        
        return answer;
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