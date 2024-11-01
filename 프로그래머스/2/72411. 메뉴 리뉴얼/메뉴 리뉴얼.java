import java.io.*;
import java.util.*;

class Solution {
    
    static Map<String, Integer> map;
    static int[] count;
    
    public String[] solution(String[] orders, int[] course) {
        
        String[] answer = {};
        count = new int[course[course.length-1]+1];
        
        Set<Integer> set = new HashSet<>();
        
        for(int i=0; i<course.length; i++){
            set.add(course[i]);
        }
        
        map = new HashMap<>();
        
        for(int i=0; i<orders.length; i++){
            char[] sortArr = orders[i].toCharArray();
            Arrays.sort(sortArr);
            orders[i] = new String(sortArr);
            combination(orders[i], 0, 
                        new int[orders[i].length()], 0);
        }
        
        List<String>[] list = new List[course[course.length-1]+1];
        
        for(int i=0; i<course[course.length-1]+1; i++){
            list[i] = new ArrayList<>();
        }
        
        int num = 0;
        
        for(Map.Entry<String, Integer> entry : map.entrySet()){
            if(set.contains(entry.getKey().length())
              && count[entry.getKey().length()] == entry.getValue()){
                list[entry.getKey().length()].add(entry.getKey());
                num++;
            }
            
        }
        
        answer = new String[num];
        int n = 0;
        
        for(int i=0; i<course.length; i++){
            
            for(String str : list[course[i]]){
                answer[n++] = str; 
            }
            
        }
        
        Arrays.sort(answer);
        
        return answer;
    }
    
    public void combination(String str, int index, int[] checked, int checkNum){
        
        if(index==str.length()){
            
            if(checkNum<2 || checkNum>=count.length) return;
            
            StringBuilder sb = new StringBuilder("");
            
            for(int i=0; i<index; i++){
                if(checked[i]==1){
                    sb.append(str.charAt(i));
                }
            }
            
            String menu = sb.toString();
            
            if(map.get(menu)!=null){
                map.put(menu, map.get(menu)+1);
                count[menu.length()] = 
                    Math.max(count[menu.length()], map.get(menu));
            }else{
                map.put(menu, 1);
            }
            
            return;
        }
        
        combination(str, index+1, checked, checkNum);
        checked[index]=1;
        combination(str, index+1, checked, checkNum+1);
        checked[index]=0;
        
    }
    
}