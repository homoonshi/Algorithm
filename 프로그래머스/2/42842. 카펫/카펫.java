import java.io.*;
import java.util.*;

class Solution {
    
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int width;
        int height;
        
        outer : for(height = 1; height < brown/2; height++){
            
            for(width = 1; width < brown/2; width++){
                
                int[] result = calculate(height, width);
                
                if(result[0]+4 > brown){
                    break;
                }
                
                if(result[0]+4 == brown && result[1] == yellow){
                    answer[0] = width+2;
                    answer[1] = height+2;
                    break outer;
                }
                
            }
            
        }
        
        return answer;
    }
    
    public int[] calculate(int h,int w){
        
        int[] result = new int[2];
        
        int brown = h * 2 + w * 2;
        int yellow = h * w;
        
        result[0] = brown;
        result[1] = yellow;
        
        return result;
        
    }
    
}