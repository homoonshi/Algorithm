import java.io.*;
import java.util.*;

class Solution {
    public int solution(int a, int b, int n) {
        
        int answer = 0;
        
        while(n >= a){
            
            int next = n % a;
            answer += (n / a) * b;
            next += ( n / a ) * b;
            n = next;
            
        }
        
        return answer;
        
    }
}