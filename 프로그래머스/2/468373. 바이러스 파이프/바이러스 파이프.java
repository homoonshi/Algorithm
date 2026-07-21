import java.io.*;
import java.util.*;

class Solution {
    
    static int answer;
    static int k, n;
    static List<Integer>[][] e;
    
    public int solution(int n, int infection, int[][] edges, int k) {
        answer = 0;
        this.k = k;
        this.n = n;
        
        e = new List[4][n+1];
        
        for(int i=1; i<=3; i++){
            for(int j=1; j<=n; j++){
                e[i][j] = new ArrayList<>();
            }
        }
        
        for(int i=0; i<edges.length; i++){
            int index = edges[i][2];
            int a = edges[i][0];
            int b = edges[i][1];
            e[index][a].add(b);
            e[index][b].add(a);
        }
        
        Set<Integer> infect = new HashSet<>();
        infect.add(infection);
        
        for(int i=1; i<=3; i++){
            search(0, i, infect);
        }
        
        return answer;
    }
    
    private void search(int depth, int pipe, Set<Integer> infect){
        
        if(depth == k){
            answer = Math.max(answer, infect.size());
            return;
        }
        
        int count = 0;
        Set<Integer> infectCopy = new HashSet<>(infect);
        Deque<Integer> deque = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        
        
        for(Integer i : infect){
            if(visited[i]) continue;
            visited[i] = true;
            deque.add(i);
            while(!deque.isEmpty()){
                int virus = deque.pollFirst();
                for(Integer go : e[pipe][virus]){
                    if(!infectCopy.contains(virus) &&
                       !infectCopy.contains(go)) continue;
                    if(visited[go]) continue;
                    visited[go] = true;
                    deque.addLast(go);
                    if(!infectCopy.contains(go)){
                        infectCopy.add(go);
                    }
                }
            }
        }
        
        for(int i=1; i<=3; i++){
            search(depth+1, i, infectCopy);
        }
        
    } 
    
}