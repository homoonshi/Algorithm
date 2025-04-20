import java.io.*;
import java.util.*;

class Solution {
    
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        Deque<Integer> servers = new ArrayDeque<>();
        
        for(int i=0; i<players.length; i++){
            
            int size = servers.size();
            
            for(int j=0; j<size; j++){
                int time = servers.pollFirst();
                if(time==i){
                    continue;
                }else{
                    servers.addFirst(time);
                    break;
                }
            }
            
            int take = players[i]/m;
            size = servers.size();
            
            if(take > size){
                for(int j=0; j<(take-size); j++){
                    servers.addLast(i+k);
                    answer++;
                }
            }
            
        }
        
        return answer;
    }
}