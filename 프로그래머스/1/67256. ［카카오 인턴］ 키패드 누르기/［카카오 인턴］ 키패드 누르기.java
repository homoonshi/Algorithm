import java.io.*;
import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder("");
        
        int[][] map = {
            {3, 1},
            {0, 0},
            {0, 1},
            {0, 2},
            {1, 0},
            {1, 1},
            {1, 2},
            {2, 0},
            {2, 1},
            {2, 2}
        };
        
        int[] left = {3, 0};
        int[] right = {3, 2};
        
        for(int num : numbers){
            
            if(num == 1 || num == 4 || num == 7){
                sb.append("L");
                left[0] = map[num][0];
                left[1] = map[num][1];
                continue;
            }
            
            if(num == 3 || num == 6 || num == 9){
                sb.append("R");
                right[0] = map[num][0];
                right[1] = map[num][1];
                continue;
            }
            
            int leftDistance = Math.abs(left[0]-map[num][0]) 
                + Math.abs(left[1]-map[num][1]);
            
            int rightDistance = Math.abs(right[0]-map[num][0])
                + Math.abs(right[1]-map[num][1]);
            
            if(leftDistance == rightDistance){
                if(hand.equals("right")){
                    sb.append("R");
                    right[0] = map[num][0];
                    right[1] = map[num][1];
                    continue;
                }else{
                    sb.append("L");
                    left[0] = map[num][0];
                    left[1] = map[num][1];
                    continue;
                }
            }
            
            if(leftDistance > rightDistance){
                sb.append("R");
                right[0] = map[num][0];
                right[1] = map[num][1];
                continue;
            }else{
                sb.append("L");
                left[0] = map[num][0];
                left[1] = map[num][1];
                continue;
            }
            
        }
        
        answer = sb.toString();
        return answer;
    }
}