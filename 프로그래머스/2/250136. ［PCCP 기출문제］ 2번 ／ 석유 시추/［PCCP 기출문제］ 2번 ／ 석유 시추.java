
import java.io.*;
import java.util.*;

class Solution {
    
    static int n, m;
    
    public int solution(int[][] land) {
        int answer = 0;
        
        n = land.length;
        m = land[0].length;
        
        int index = 2;
        
        Map<Integer, Integer> map = new HashMap<>();
        
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(land[i][j]==1){
                    Deque<int[]> deque = new ArrayDeque<>();
                    deque.addLast(new int[]{i, j});
                    land[i][j] = index;
                    int count = 1;
                    while(!deque.isEmpty()){
                        int[] temp = deque.pollFirst();
                        
                        for(int k=0; k<4; k++){
                            int nx = temp[0] + dx[k];
                            int ny = temp[1] + dy[k];
                            
                            if(!isIn(nx, ny)){
                                continue;
                            }
                            
                            if(land[nx][ny]==1){
                                land[nx][ny] = index;
                                count++;
                                deque.addLast(new int[]{nx, ny});
                            }
                        }
                    }
                    map.put(index, count);
                    index++;
                }
            }
        }
        
        for(int i=0; i<m; i++){
            boolean[] oil = new boolean[index+1];
            int count = 0;
            for(int j=0; j<n; j++){
                int idx = land[j][i];
                if(idx>1){
                    if(!oil[idx]){
                        count += map.get(land[j][i]);
                        oil[idx] = true;
                    }
                }
            }
            answer = Math.max(answer, count);
        }
        
        return answer;
    }
    
    public static boolean isIn(int x, int y){
        if(x>=0 && x<n && y>=0 && y<m){
            return true;
        }
        return false;
    }
    
}