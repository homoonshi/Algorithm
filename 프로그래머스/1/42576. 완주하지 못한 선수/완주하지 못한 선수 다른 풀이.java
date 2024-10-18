import java.util.*;
import java.io.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer;
        
        Set<String> set = new HashSet<>();
        Map<String, Integer> equalName = new HashMap<>();
        
        for(String name : completion) {
            
            if(!set.contains(name)){
                set.add(name);
            }else {
                if(equalName.containsKey(name)){
                    equalName.put(name, equalName.get(name)+1);   
                }else{
                    equalName.put(name, 2);
                }
            }
            
        }
        
        for(String name : participant){
            
            if(!set.contains(name)){
                return name;
            }
            
            if(equalName.containsKey(name)){
                int num = equalName.get(name);
                if(num == 0){
                    return name;
                }else{
                    equalName.replace(name, num-1);
                }
            }else{
                set.remove(name);
            }
            
        }
        
        return "";
    }
}