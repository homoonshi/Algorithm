import java.io.*;
import java.util.*;

class Solution {
    
    static int[] team;
    
    public int solution(int n, int[][] computers) {
        
        int answer = 0;
        
        team = new int[n];
        
        for(int i=0; i<n; i++){
            team[i] = i;
        }
        
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(computers[i][j]==1){
                    union(i, j);
                }
            }
        }
        
        for(int i=0; i<n; i++){
            if(team[i]==i){
                answer++;
            }
        }
        
        return answer;
    
    }
    
    public int find(int a){
        int next = a;
        
        while(team[next]!=next){
            next = team[next];
        }

        return next;
    }
    
    public void union(int a, int b){
        
        int bossA = find(a);
        int bossB = find(b);
        
        if(bossA < bossB){
            team[bossB] = bossA;
        }else{
            team[bossA] = bossB;
        }
        
    }
    
    
}