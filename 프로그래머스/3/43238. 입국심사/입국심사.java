import java.io.*;
import java.util.*;

class Solution {
    
    public long solution(int n, int[] times) {
        
        long answer = 0;
        
        long end = (long) 1000000000 * n;
        long start = 0;
        
        long person = 0;
        
        while (start <= end){
            
            long mid = (long) (start+end) / 2;
            
            person = 0;
            
            for(int i=0; i<times.length; i++){
                
                person += (long) mid / times[i];
                
                if( n < person ){
                    break;
                }
                
            }
            
            if ( n <= person ){
                end = mid-1;
            }else {
                start = mid+1;
            }
            
        }
        
        
        answer = start;
        
        return answer;
    }
}