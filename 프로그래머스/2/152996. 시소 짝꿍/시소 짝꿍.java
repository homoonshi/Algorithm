import java.io.*;
import java.util.*;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        Arrays.sort(weights);
        HashMap<Long, Long> map = new HashMap<>();
        
        for(int i=0; i<weights.length; i++){
            long num = weights[i];
            
            if(map.containsKey(num)){
                answer += map.get(num);
            }
            if(num % 3 == 0 && map.containsKey((num * 2) / 3)){
                answer += map.get((num * 2) / 3);
            }
            if(num % 2 == 0 && map.containsKey(num / 2)){
                answer += map.get(num / 2);
            }
            if(num % 4 == 0 && map.containsKey((num * 3) / 4)){
                answer += map.get((num * 3) / 4);
            }
            
            long count = 1;
            if(map.containsKey(num)){
                count = map.get(num) + 1;
            }
            map.put(num, count);
        }
        
        return answer;
    }
}