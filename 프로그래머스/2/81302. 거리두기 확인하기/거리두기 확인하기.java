import java.io.*;
import java.util.*;

class Solution {
    
    static char[][] currentMap;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int i=0; i<places.length; i++){
            currentMap = new char[5][5];
            answer[i] = confirmDistance(places[i]);
        }
        
        return answer;
    }
    
    public int confirmDistance(String[] place){
        
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                currentMap[i][j] = place[i].charAt(j);
            }
        }
        
        for(int i=0; i<5; i++){
            for(int j=0; j<5; j++){
                if(currentMap[i][j]=='P'){
                    if(confirmPerson(i, j) == -1){
                        return 0;
                    }
                }
            }
        }
        
        return 1;
    }
    
    public int confirmPerson(int x, int y){
        int[] dx = {0,0,1};
        int[] dy = {-1,1,0};
        
        int[][] ddx = {{1},{0,1},{1,1,2}};
        int[][] ddy = {{-1},{2,1},{-1,1,0}};
        
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{0,0}); // 멘해튼거리-1 , 멘해튼거리2 일 때 인덱스 값
        
        while(!deque.isEmpty()){
            int[] temp = deque.pollFirst();
            
            if(temp[0]==0){
                
                for(int i=0; i<3; i++){
                    int nx = x + dx[i];
                    int ny = y + dy[i];
                    
                    if(!isIn(nx, ny)){
                        continue;
                    }

                    if(currentMap[nx][ny]=='P'){
                        return -1;
                    }else if(currentMap[nx][ny]=='O'){
                        deque.addLast(new int[]{1,i});
                    }
                }
                
            }else {
                
                for(int i=0; i<ddx[temp[1]].length; i++){
                    int nx = x + ddx[temp[1]][i];
                    int ny = y + ddy[temp[1]][i];
                    
                    if(!isIn(nx, ny)){
                        continue;
                    }
                    
                    if(currentMap[nx][ny] == 'P'){
                        return -1;
                    }
                }
                
            }
        }
        
        return 0;
    }
    
    public boolean isIn(int x,int y){
        if(x>=0 && y>=0 && x<5 && y<5){
            return true;
        }
        return false;
    }
    
}