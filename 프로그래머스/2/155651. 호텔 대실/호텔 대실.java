import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[][] book_time) {
        int answer = 0;
        
        Arrays.sort(book_time, (o1, o2) -> o1[0].compareTo(o2[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i=0; i<book_time.length; i++){
            
            int startTime = Integer.parseInt(
                        book_time[i][0].replace(":",""));
            int endTime = Integer.parseInt(
                        book_time[i][1].replace(":",""));
            
            int size = pq.size();
            
            for(int j=0; j<size; j++){
                int end = pq.poll();
                if(startTime<end){
                    pq.add(end);
                    break;
                }
            }
            
            endTime = (endTime+10)%100 >= 60 ? (endTime+50) : endTime+10;
            
            pq.add(endTime);
            
            answer = Math.max(answer, pq.size());
        }
        
        return answer;
    }
}