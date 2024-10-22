import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        
        StringBuilder answer = new StringBuilder("");
        Map<Character, Integer> map = new HashMap<>();
        
        map.put('R', 0);
        map.put('T', 0);
        map.put('C', 0);
        map.put('F', 0);
        map.put('J', 0);
        map.put('M', 0);
        map.put('A', 0);
        map.put('N', 0);
        
        for(int i=0; i<survey.length; i++){
            selectCharacter(map, survey[i], choices[i]);
        }
        
        if(map.get('R')>=map.get('T')){
            answer.append('R');
        }else {
            answer.append('T');
        }
        
        if(map.get('C')>=map.get('F')){
            answer.append('C');
        }else{
            answer.append('F');
        }
        
        if(map.get('J')>=map.get('M')){
            answer.append('J');
        }else{
            answer.append('M');
        }
        
        if(map.get('A')>=map.get('N')){
            answer.append('A');
        }else{
            answer.append('N');
        }
        
        return answer.toString();
    }
    
    public Map<Character, Integer> selectCharacter(Map<Character, Integer> map, String survey, int choices){
        
        if(choices > 4){
            plusCharacterScore(map, survey.charAt(1), choices);
        }else if(choices < 4) {
            plusCharacterScore(map, survey.charAt(0), choices);
        }
        
        return map;
    }
    
    public Map<Character, Integer> plusCharacterScore(Map<Character, Integer> map, char character, int choices){
        
        int score = map.get(character);
        
        switch(choices){
            case 1: case 7:
                score ++;
            case 2: case 6:
                score ++;
            case 3: case 5:
                score ++;
                break;
        }
        
        map.put(character, score);
        
        return map;
    }
    
}