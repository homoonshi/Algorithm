import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        int count = 0;
        int[] map = new int[gems.length];
        Map<String, Integer> dic = new HashMap<>();
        int n = gems.length;
        
        for(int i=0; i<n; i++){
            if(dic.containsKey(gems[i])){
                int index = dic.get(gems[i]);
                map[i] = index;
                continue;
            }
            dic.put(gems[i], count);
            map[i] = count;
            count++;
        }
        
        int full = 0;
        int[] has = new int[count];
        answer[0] = 1;
        answer[1] = n;
        
        int start = 0;
        int current = 0;
        int end = n;
        
        while(current<=end){
            if(full==count){
                if(answer[1]-answer[0] >
                        (current - (start+1))){
                    answer[0] = start+1;
                    answer[1] = current;
                }
                has[map[start]]--;
                if(has[map[start]]==0){
                    full--;
                }
                start++;
                continue;
            }
            if(current==n) break;
            if(has[map[current]]==0){
                full++;
            }
            has[map[current]]++;
            current++;
        }
        
        return answer;
    }
}