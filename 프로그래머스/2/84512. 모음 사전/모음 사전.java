import java.io.*;
import java.util.*;

class Solution {
    public int solution(String word) {
        
        int answer = 0;
        int[] index = new int[5];
        
        char[] str = {' ','A','E','I','O','U'};
        
        for(int i=0; i<word.length(); i++){
            for(int j=1; j<=5; j++){
                if(word.charAt(i)==str[j]){
                    index[i]=j;
                    break;
                }
            }
        }
        
        for(int i=1; i<6; i++){
            for(int j=0; j<6; j++){
                
                if(j==0){
                    answer++;
                    
                    if(i==index[0] && j==index[1] &&
                      index[2]==0 && index[3]==0 && index[4]==0){
                        return answer;
                    }
                    
                    continue;
                }
                
                for(int m=0; m<6; m++){
                    
                    if(m==0){
                        answer++;
                        
                        if(i==index[0] && j==index[1] &&
                            index[2]==m & index[3]==0 && index[4]==0){
                            return answer;
                        }
                        
                        continue;
                    }
                    
                    for(int n=0; n<6; n++){
                        
                        if(n==0){
                            answer++;
                            
                            if(i==index[0] && j==index[1] &&
                                index[2]==m & index[3]==n&& index[4]==0){
                                return answer;
                            }
                            
                            continue;
                        }
                        
                        for(int k=0; k<6; k++){
                            
                            answer++;
                            
                            if(i==index[0] && j==index[1] &&
                                index[2]==m & index[3]==n&& index[4]==k){
                                return answer;
                            }
                            
                        }
                    }
                }
            }
        }
        
        return answer;
        
    }
    
    
    
}