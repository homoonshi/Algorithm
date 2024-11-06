import java.io.*;
import java.util.*;

class Solution {
    
    static int result;
    static int[] number;
    static int tar;
    
    public int solution(int[] numbers, int target) {
        
        result = 0;
        number = new int[numbers.length];
        tar = target;
        
        for(int i=0; i<numbers.length; i++){
            number[i] = numbers[i];
        }
        
        DFS(numbers.length-1, new int[numbers.length]);
        
        return result;
    }
    
    public void DFS(int count, int[] nums){
        
        if(count == -1){
            
            int res = 0;
            
            for(int i=0; i<nums.length; i++){
                res += nums[i];
            }
            
            if(res==tar){
                result++;
            }
            
            return;
        }
        
        nums[count] = (-1) * number[count];
        
        DFS(count-1, nums);
        
        nums[count] = number[count];
        
        DFS(count-1, nums);
        
    } 
    
}