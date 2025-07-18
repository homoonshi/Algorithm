import java.io.*;
import java.util.*;

class Solution {
    
    static List<Integer>[] top;
    static boolean[] visit;
    static int num;
    
    public int solution(int n, int[][] wires) {
        int answer = 1000;
        num = n;
        top = new List[n+1];
        
        for(int i=1; i<=n; i++){
            top[i] = new ArrayList<>();
        }
        
        for(int i=0; i<wires.length; i++){
            top[wires[i][0]].add(wires[i][1]);
            top[wires[i][1]].add(wires[i][0]);
        }
        
        for(int i=0; i<wires.length; i++){
            visit = new boolean[n+1];
            visit[wires[i][0]] = true;
            visit[wires[i][1]] = true;
            int a = wireCount(wires[i][0], wires[i][1]);
            int b = wireCount(wires[i][1], wires[i][0]);
            if(a==-1 || b==-1){
                continue;
            }
            answer = Math.min(answer, Math.abs(a-b));
        }
        
        return answer;
    }
    
    public static int wireCount(int start, int ban){
        
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addLast(start);
        
        boolean[] v = new boolean[num+1];
        v[start] = true;
        int count = 1;
        
        while(!deque.isEmpty()){
            int index = deque.pollFirst();
            
            for(Integer next : top[index]){
                if(next==ban || v[next]) continue;
                if(next!=ban && !v[next] && visit[next]) return -1;
                deque.addLast(next);
                v[next] = true;
                visit[next] = true;
                count++;
            }
        }
        
        return count;
    }
}