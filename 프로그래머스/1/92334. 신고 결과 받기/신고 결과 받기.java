import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        
        int[] answer = new int[id_list.length];
        
        Map<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<id_list.length; i++){
            map.put(id_list[i], i);
        }
        
        List<Integer>[] sendReport = new List[id_list.length];
        int[] receiveReport = new int[id_list.length];
        
        for(int i=0; i<id_list.length; i++){
            sendReport[i] = new ArrayList<>();
        }
        
        for(int i=0; i<report.length; i++){
            
            String[] rep = report[i].split(" ");
            
            int send = map.get(rep[0]);
            int receive = map.get(rep[1]);
            
            if(!sendReport[send].contains(receive)){
                sendReport[send].add(receive);
                receiveReport[receive]++;
            }
            
        }
        
        for(int i=0; i<id_list.length; i++){
            
            for(Integer index : sendReport[i]){
                if(receiveReport[index]>=k){
                    answer[i]++;
                }
            }
            
        }
        
        
        return answer;
    }
}