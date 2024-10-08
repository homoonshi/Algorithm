import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<=9; i++){
            set.add(i);
        }
        
        for(int n : numbers){
            set.remove(n);
        }
        
        Iterator<Integer> iter = set.iterator();
        
        while(iter.hasNext()){
            answer += iter.next();
            System.out.println(answer);
        }
        
        return answer;
    }
}