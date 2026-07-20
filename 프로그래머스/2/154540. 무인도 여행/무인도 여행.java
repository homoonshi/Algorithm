import java.io.*;
import java.util.*;

class Solution {
    static int h, w;
    static boolean[][] visited;
    static int[][] map;
    
    public int[] solution(String[] maps) {
        List<Integer> lists = new ArrayList<>();
        
        h = maps.length;
        w = maps[0].length();
        
        map = new int[h][w];
        visited = new boolean[h][w];
        
        insertMap(maps);
        
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                if(visited[i][j] || map[i][j] == 0) continue;
                visited[i][j] = true;
                lists.add(map[i][j] + visit(-1, i, j));
            }
        }
        
        if(lists.size() == 0){
            return new int[]{-1};
        }
        
        Integer[] answer = lists.toArray(new Integer[lists.size()]);
        Arrays.sort(answer);
        
        return Arrays.stream(answer).mapToInt(i -> i).toArray();
    }
    
    private void insertMap(String[] maps){
        for(int i=0; i<h; i++){
            for(int j=0; j<w; j++){
                char c = maps[i].charAt(j);
                if(c == 'X') continue;
                map[i][j] = c - '0';
            }
        }
    }
    
    private int visit(int direction, int x, int y){
        int[] dx = {0, 1, -1, 0};
        int[] dy = {1, 0, 0, -1};
        
        int r = 0;
            
         if(direction == -1){
            for(int i=0; i<4; i++){
                r += visit(i, x, y);
            }
            return r;
        }
        
        int nx = x + dx[direction];
        int ny = y + dy[direction];
        
        if(!isIn(nx, ny) || 
           map[nx][ny] == 0 || 
           visited[nx][ny]) return r;
        
        visited[nx][ny] = true;

        for(int i=0; i<4; i++){
            r += visit(i, nx, ny);
        }
        
        return r + map[nx][ny];
    }
    
    private boolean isIn(int x, int y){
        if(x>=0 && x<h && y>=0 && y<w){
            return true;
        }
        return false;
    }
    
}