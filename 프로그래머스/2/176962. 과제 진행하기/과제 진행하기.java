import java.io.*;
import java.util.*;

class Solution {
    
    static class Plan implements Comparable<Plan> {
        
        String name;
        int start;
        int play;
        
        public Plan(String name, int start, int play){
            this.name = name;
            this.start = start;
            this.play = play;
        }
        
        public int compareTo(Plan o){
            return this.start - o.start;
        }
        
    }
    
    public String[] solution(String[][] plans) {
        
        int len = plans.length;
        String[] answer = new String[len];
        
        Deque<int[]> deque = new ArrayDeque<>();
        int ansLen = 0;
        Plan[] p = new Plan[len];
        
        for(int i=0; i<len; i++){
            p[i] = new Plan(plans[i][0], changeTime(plans[i][1]), Integer.parseInt(plans[i][2]));
        }
        
        Arrays.sort(p);
        
        for(int i=1; i<len; i++){
            int before = p[i-1].start;
            int current = p[i].start;
            
            int playTime = p[i-1].play;
            
            if(before+playTime>current){
                deque.addLast(new int[]{i-1, playTime - (current-before)});
            }else if(before+playTime==current){
                answer[ansLen++] = p[i-1].name;
                continue;
            }else{
                answer[ansLen++] = p[i-1].name;
                int remainTime = current - (before+playTime);
                while(!deque.isEmpty()){
                    int[] temp = deque.pollLast();
                    
                    if(temp[1]>remainTime){
                        deque.addLast(new int[]{temp[0], temp[1]-remainTime});
                        break;
                    }else if(temp[1]==remainTime){
                        answer[ansLen++] = p[temp[0]].name;
                        break;
                    }else{
                        answer[ansLen++] = p[temp[0]].name;
                        remainTime -= temp[1];
                    }
                }
            }
        }
        
        answer[ansLen++] = p[len-1].name;
        
        while(!deque.isEmpty()){
            int[] temp = deque.pollLast();
            answer[ansLen++] = p[temp[0]].name;
        }
        
        return answer;
    }
    
    public static int changeTime(String time){
        String[] t = time.split(":");
        int res = Integer.parseInt(t[0])*60;
        res += Integer.parseInt(t[1]);
        return res;
    }
}