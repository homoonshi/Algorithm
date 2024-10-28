import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        boolean answer = true;

        Deque<Character> deque = new ArrayDeque<>();
        
        for(int i=0; i<s.length(); i++){
            deque.addLast(s.charAt(i));
        }
        
        int left = 0;
        int right = 0;
        
        while(!deque.isEmpty()){
            Character c = deque.pollFirst();
            if(c=='('){
                left++;
            }else{
                right++;
            }
            
            if(left<right){
                answer=false;
                break;
            }
        }
        
        if(left!=right){
            answer=false;
        }

        return answer;
    }
}