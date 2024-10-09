import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] answer) {     
        
        Deque<Integer>[] supoja = new Deque[3];
        
        for(int i=0; i<3; i++){
            supoja[i] = new ArrayDeque<>();
        }
        
        // number 1 supoja
        int[] su1 = {1,2,3,4,5};
        for(int i=0; i<su1.length; i++){
            supoja[0].addLast(su1[i]);
        }
        
        // number 2 supoja
        int[] su2 = {2,1,2,3,2,4,2,5};
        for(int i=0; i<su2.length; i++){
            supoja[1].addLast(su2[i]);
        }
        
        // number 3 supoja
        int[] su3 = {3,3,1,1,2,2,4,4,5,5};
        for(int i=0; i<su3.length; i++){
            supoja[2].addLast(su3[i]);
        }
        
        int[] answerSupo = new int[3];
        int[] response = new int[3];
        int maxResult = 0;
        
        for(int i=0; i<answer.length; i++){
            
            answerSupo[0] = supoja[0].pollFirst();
            answerSupo[1] = supoja[1].pollFirst();
            answerSupo[2] = supoja[2].pollFirst();
            
            for(int j=0; j<3; j++){
                if(answer[i]==answerSupo[j]){
                    response[j]++;
                    maxResult = Math.max(maxResult, response[j]);
                    
                }
                supoja[j].addLast(answerSupo[j]);
            }
            
        }
        
        supoja[0] = new ArrayDeque<>();
        
        for(int i=0; i<3; i++){
            if(maxResult == response[i]){
                supoja[0].addLast(i+1);
            }
        }
        
        int size = supoja[0].size();
        int[] result = new int[size];
        
        for(int i=0; i<size; i++){
            result[i] = supoja[0].pollFirst();
        }
        
        return result;
    }
}