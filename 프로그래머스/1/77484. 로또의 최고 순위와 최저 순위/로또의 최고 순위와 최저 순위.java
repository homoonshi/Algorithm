import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = {};
        
        Map<Integer, Integer> map = new HashMap<>();
        
        map.put(6,1);
        map.put(5,2);
        map.put(4,3);
        map.put(3,4);
        map.put(2,5);
        map.put(1,6);
        map.put(0,6);
        
        Arrays.sort(win_nums);
        Arrays.sort(lottos);
        
        int match = 0;
        int none = 0;
        
        for(int i=0; i<6; i++){
            
            int checkNum = lottos[i];
            
            if(checkNum == 0){
                none++;
                continue;
            }
            
            int min = 1;
            int mid = 3;
            int max = 6;
            
            while(min<=max){
                
                if(checkNum==win_nums[mid-1]){
                    match++;
                    break;
                }
                
                if(checkNum<win_nums[mid-1]){
                    max = mid-1;
                    mid = (max+min)/2;
                }else{
                    min = mid+1;
                    mid = (max+min)/2;
                }
                
            }
        }
        
        answer = new int[2];
        
        answer[0] = map.get(match+none);
        answer[1] = map.get(match);
        
        return answer;
    }
}