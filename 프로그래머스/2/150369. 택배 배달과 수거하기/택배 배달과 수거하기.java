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
            
            while(!delivery.isEmpty()){
                int[] d = delivery.pollLast();
                distance = Math.max(distance, d[0]);
                if(nextD == 0){
                    d[1] -= cap;
                }else{
                    d[1] += nextD;
                }
                if(d[1]>=0){
                    if(d[1]>0){
                        delivery.addLast(d);
                    }
                    break;
                }
                nextD = d[1];
            }
            
            while(!pickup.isEmpty()){
                int[] p = pickup.pollLast();
                distance = Math.max(distance, p[0]);
                if(nextP == 0){
                    p[1] -= cap;
                }else{
                    p[1] += nextP;
                }
                if(p[1]>=0){
                    if(p[1]>0){
                        pickup.addLast(p);
                    }
                    break;
                }
                nextP = p[1];
            }
            
            answer += (distance*2);
        }
        
        return answer;
    }
}