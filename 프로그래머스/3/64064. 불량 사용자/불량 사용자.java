import java.util.*;
import java.io.*;

class Solution {
    
    static Deque<Integer>[] user;
    static Set<Integer> set = new HashSet<>();
    static int[] banlist;
    static boolean[] isvisited;
    
    public int solution(String[] user_id, String[] banned_id) {
        
        int answer = 0;
        
        user = new ArrayDeque[user_id.length];
        banlist = new int[banned_id.length];
        isvisited = new boolean[banned_id.length];
        
        boolean isBanned;
        int userSize, banSize;
        char banCur, userCur;
        
        for(int i=0; i<user_id.length; i++){
            
            userSize = user_id[i].length();
            user[i] = new ArrayDeque<>();
            
            for(int j=0; j<banned_id.length; j++){
                
                isBanned = true;
                banSize = banned_id[j].length();
                if(userSize!=banSize) continue;
                
                for(int k=0; k<banSize; k++){
                    
                    banCur = banned_id[j].charAt(k);
                    userCur = user_id[i].charAt(k);
                    
                    if(banCur=='*')continue;
                    if(banCur!=userCur){
                        isBanned = false;
                        break;
                    }
                    
                }
                
                if(isBanned){
                    user[i].addLast(j);
                }
                
            }
        }
        
        combination(0, banned_id.length, 0);
        answer = set.size();
        
        return answer;
    }
    
    static public void combination (int cnt, int end, int index){
        
        if(cnt==end){
            
            Integer[] banlistArray = Arrays.stream(banlist).boxed().toArray(Integer[]::new);
            int h = Arrays.deepHashCode(banlistArray);
            set.add(h);
        
            return;
        }
        
        if(index==user.length) return;
        
        for(int i=0, size=user[index].size(); i<size; i++){
            
            int num = user[index].pollFirst();
            if(isvisited[num]==false){
                isvisited[num]=true;
                banlist[cnt] = index;
                combination(cnt+1, end, index+1);
                isvisited[num]=false;
            }
            user[index].addLast(num);
            
        }
        
        combination(cnt, end, index+1);
        
    } 
    
    
}