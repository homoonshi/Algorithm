import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        
        int[][][] map = new int[20000][101][101];
        Deque<int[]> deque = new ArrayDeque<>();
        
        int count = 0;
        
        for(int i=0; i<routes.length; i++){
            int index = routes[i][0]-1;
            if(map[0][points[index][0]][points[index][1]]==1){
                count++;
            }
            map[0][points[index][0]][points[index][1]]++;
            deque.addLast(new int[]{points[index][0], points[index][1], i, 0, 1});
        }
        
        while(!deque.isEmpty()){
            
            int[] temp = deque.pollFirst();
            int index = temp[2];
            int current = temp[4];
            int next = routes[index][current]-1;
            int num = temp[3]+1;
            
            int dx = points[next][0];
            int dy = points[next][1];
            
            int x = temp[0];
            int y = temp[1];
            
            if(dx<x){
                x--;
            }else if(dx>x){
                x++;
            }else{
                if(dy<y){
                    y--;
                }else if(dy>y){
                    y++;
                }
            }
            
            if(map[num][x][y]==1){
                count++;
            }
            
            map[num][x][y]++;
            
            if(dx==x && dy==y){
                if(routes[index].length-1>current){
                    deque.addLast(new int[]{x, y, index, num, current+1});
                }
                continue;
            }
            
            deque.addLast(new int[]{x, y, index, num, current});
        }
        
        return count;
    }
}