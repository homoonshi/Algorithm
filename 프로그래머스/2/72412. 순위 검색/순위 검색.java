import java.io.*;
import java.util.*;

class Solution {
    
    class Developer implements Comparable<Developer>{
        
        int score;
        
        public Developer(int score){
            this.score = score;
        }
        
        int getScore(){
            return this.score;
        }
        
        public int compareTo(Developer o){
            return this.score - o.score;
        }
        
    }
    
    static Map<String, Integer> map = new HashMap<>();
    static List<Developer>[][][][] develop = new List[3][2][2][2];
    
    public int[] solution(String[] info, String[] query) {
        
        setMap();
        
        int[] answer = new int[query.length];
        
        for(int i=0; i<3; i++){
            for(int j=0; j<2; j++){
                for(int m=0; m<2; m++){
                    for(int n=0; n<2; n++){
                        develop[i][j][m][n] = new ArrayList<>();
                    }
                }
            }
        }
        
        int language, part, career, food, score;
        
        for(String inputs : info){
            
            String[] input = inputs.split(" ");
            
            language = map.get(input[0]);
            part = map.get(input[1]);
            career = map.get(input[2]);
            food = map.get(input[3]);
            score = Integer.parseInt(input[4]);
            
            Developer d = new Developer(score);
            
            develop[language][part][career][food].add(d);
            
        }
        
        for(int i=0; i<3; i++){
            for(int j=0; j<2; j++){
                for(int m=0; m<2; m++){
                    for(int n=0; n<2; n++){
                        Collections.sort(develop[i][j][m][n]);
                    }
                }
            }
        }
        
        for(int i=0; i<query.length; i++){
            answer[i] = getScorePerson(query[i]);
        }
        
        return answer;
    }
    
    public int getScorePerson(String query){
        
        String[] command = query.split(" ");
        
        int language = map.get(command[0]);
        int part = map.get(command[2]);
        int career = map.get(command[4]);
        int food = map.get(command[6]);
        int score = Integer.parseInt(command[7]);
        
        int result = 0;
        
        for(int i=0; i<3; i++){
            if(language != 99 && language != i){
                continue;
            }
            for(int j=0; j<2; j++){
                if(part != 99 && part != j){
                    continue;
                }
                for(int m=0; m<2; m++){
                    if(career != 99 && career != m){
                        continue;
                    }
                    for(int n=0; n<2; n++){
                        if(food != 99 && food != n){
                            continue;
                        }
                        
                        int size = develop[i][j][m][n].size();
                        
                        int start = 0;
                        int end = size-1;
                        
                        while ( start <= end ){
                            
                            int mid = ( start + end ) / 2;
                            
                            if(develop[i][j][m][n].get(mid)!=null){
                                if(develop[i][j][m][n].get(mid).getScore() < score){
                                    start = mid + 1;
                                } else {
                                    end = mid - 1;
                                }
                            }else{
                                break;
                            }
                            
                        }
                        
                        result += size - start;
                        
                        
                    }
                }
            }
        }
        
        return result;
    }
    
    public void setMap(){
        
        map.put("cpp",0);
        map.put("java",1);
        map.put("python",2);
        
        map.put("backend",0);
        map.put("frontend",1);
        
        map.put("junior",0);
        map.put("senior",1);
        
        map.put("chicken",0);
        map.put("pizza",1);
        
        map.put("-", 99);
        
    }
}