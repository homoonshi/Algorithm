
import java.io.*;
import java.util.*;

class Solution {
    
    static int w, h;
    
    public int[] solution(String[] park, String[] routes) {
        
        int[] position = new int[2];
        
        w = park[0].length();
        h = park.length;
        
        int[][] map = new int[h][w];
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                 if(park[i].charAt(j)=='S'){
                     position[0] = i;
                     position[1] = j;
                     map[i][j] = 0;
                 }else if(park[i].charAt(j)=='O'){
                     map[i][j] = 0;
                 }else{
                     map[i][j] = 1;
                 }
            }
        }
        
        String[] input;
        
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        Map<Character, Integer> direction = new HashMap<>();
        direction.put('N', 0);
        direction.put('S', 1);
        direction.put('W', 2);
        direction.put('E', 3);
        
        for(int i=0; i<routes.length; i++){
            
            input = routes[i].split(" ");
            
            int index = direction.get(input[0].charAt(0));
            int step = Integer.parseInt(input[1]);
            
            if(!isIn(position[0]+dx[index]*step, position[1]+dy[index]*step)){
                continue;
            }
            
            int nx = 0;
            int ny = 0;
            boolean find = false;
            
            for(int j=1; j<=step; j++){
                nx = position[0] + dx[index] * j;
                ny = position[1] + dy[index] * j;
                
                if(map[nx][ny]==1){
                    find = true;
                    break;
                }
                
            }
            
            if(find){
                continue;
            }
            
            position[0] = nx;
            position[1] = ny;
            
        }
        
        return position;
    
    }
    
    public boolean isIn(int x, int y){
        if(x>=0&&x<h&&y>=0&&y<w){
            return true;
        }
        
        return false;
    }
    
}