import java.io.*;
import java.util.*;

class Solution {
    
    int[] answer;
    
    public int[] solution(String s) {
        
        answer = new int[2];
        
        while(!s.equals("1")){
            
            s = removeZero(s);
            s = changeBinary(s);
            answer[0]++;
            
        }
        
        return answer;
    }
    
    public String removeZero(String s){
        
        StringBuilder result = new StringBuilder("");
        int remove = 0;
        
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)=='1'){
                result.append("1");
            }else{
                remove++;
            }
        }
        
        answer[1] += remove;
        return result.toString();
    }
    
    public String changeBinary(String s){
        
        int length = s.length();
        int size = searchBinary(length, 0);
        
        StringBuilder result = new StringBuilder("1");
        length -= Math.pow(2, size);
        
        for(int i=size-1; i>=0; i--){
            
            if(length >= Math.pow(2, i)){
                result.append("1");
                length -= Math.pow(2, i);
            }else{
                result.append("0");
            }
            
        }
        
        return result.toString();
    }
    
    public int searchBinary(int num, int p){
        
        if(num >= Math.pow(2, p+1)){
            p = searchBinary(num, p+1);
        }
        
        return p;
    }
    
}