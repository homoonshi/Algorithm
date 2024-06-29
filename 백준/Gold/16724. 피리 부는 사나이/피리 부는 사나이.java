import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static char[][] map;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] inputs = br.readLine().split(" ");
        String input;

        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);

        map = new char[N][M];

        for(int i=0; i<N; i++){
            input = br.readLine();
            for(int j=0; j<M; j++){
                map[i][j] = input.charAt(j);
            }
        }

        int result = BFS();

        bw.write(result+"\n");
        bw.flush();
    }

    public static int BFS(){

        int result = 0;
        int[][] visit = new int[N][M];

        Deque<int[]> deque = new ArrayDeque<>();
        int[] temp;

        int x, y;
        int count = 1;
        boolean create;

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                create = false;
                if(visit[i][j]==1) continue;
                deque.addLast(new int[]{i,j});
                visit[i][j] = count;
                while(!deque.isEmpty()){
                    temp = deque.pollFirst();
                    x = temp[0];
                    y = temp[1];

                    if(map[x][y]=='D'){
                        x += 1;
                    }else if(map[x][y]=='U'){
                        x -= 1;
                    }else if(map[x][y]=='L'){
                        y -= 1;
                    }else{
                        y += 1;
                    }

                    if(visit[x][y]==0){
                        deque.addLast(new int[]{x, y});
                        visit[x][y]=count;
                    }else if(visit[x][y]<count){
                        break;
                    }else if(visit[x][y]==count){
                        create = true;
                    }
                }
                count++;
                if(create){
                    result++;
                }
            }
        }

        return result;
    }

}