import java.io.*;
import java.util.*;

class Solution {
        
    public int[] solution(int[] progresses, int[] speeds) {
        
        List<Integer> answer = new ArrayList<>();
        int num = progresses.length;
        
        int beforeDay = endDay(progresses[0], speeds[0]);
        int endFunc = 1;
        
        for(int i=1; i<num; i++){
            
            int eDay = endDay(progresses[i], speeds[i]);
            
            if(beforeDay<eDay){
                answer.add(endFunc);
                endFunc = 1;
                beforeDay = eDay;
                continue;
            }
            
            endFunc++;
            
        }
        
        answer.add(endFunc);
        
        int[] result = new int[answer.size()];
        int index = 0;
        
        for(Integer day : answer){
            result[index++] = day;
        }
        
        return result;
    }
    
    // 기능 완료 일 리턴
    static public int endDay(int progress, int speed){
        int day = 0;
        while(progress<100){
            progress += speed;
            day++;
        }
        return day;
    }
    
}