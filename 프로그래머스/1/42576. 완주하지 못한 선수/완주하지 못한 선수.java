import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Map<String, Integer> completePerson = new HashMap<>();
        
        for(String c : completion){
            completePerson.put(c,completePerson.getOrDefault(c,0)+1);
        }
        
        for(String p : participant){
            
            if(completePerson.containsKey(p)){
                if(completePerson.get(p)>0){
                    completePerson.replace(p,completePerson.get(p)-1);
                    continue;
                }
            }
            
            answer = p;
            break;
            
        }
        
        return answer;
    }
}