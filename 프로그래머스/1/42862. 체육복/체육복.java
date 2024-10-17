import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] lostStudent = new int[n+1];
        int[] cloth = new int[n+1];
        
        for(int i=0; i<lost.length; i++){
            lostStudent[lost[i]] = 1;
        }
        
        for(int i=0; i<reserve.length; i++){
            cloth[reserve[i]] = 1;
        }
        
        for(int i=1; i<=n; i++){
            
            if(lostStudent[i] == 1){
                
                if(cloth[i] == 1){
                    cloth[i] = 0;
                    answer++;
                    continue;
                }
                
                if(cloth[i-1] == 1){
                    cloth[i-1] = 0;
                    answer++;
                    continue;
                }else if( i < n && lostStudent[i+1] == 0 && cloth[i+1] == 1){
                    cloth[i+1] = 0;
                    answer++;
                    continue;
                }
                
            }else{
                answer++;
            }
            
        }
        
        
        return answer;
    }
}