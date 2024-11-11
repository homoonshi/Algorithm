import java.io.*;
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        Set<String> set = new HashSet<>();
        
        for(int i=0; i<phone_book.length; i++){
            set.add(phone_book[i]);
        }
        
        for(int i=0; i<phone_book.length; i++){
            for(int j=0; j<phone_book[i].length(); j++){
                String phone = phone_book[i].substring(0,j);
                if(set.contains(phone)){
                    return false;
                }
            }
        }
        
        return answer;
    }
}