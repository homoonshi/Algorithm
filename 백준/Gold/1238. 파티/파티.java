import java.util.*;
import java.io.*;

public class Main {

    static int N,M,X;
    static int[][] map;
    static int[] visit;
    static Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int start,end,time;

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        X = Integer.parseInt(input[2]);

        map = new int[N+1][N+1];
        visit = new int[N+1];

        for(int i=1; i<=N; i++){
            Arrays.fill(map[i],99999999);
        }

        for(int i=0; i<M; i++){

            input = br.readLine().split(" ");

            start = Integer.parseInt(input[0]);
            end = Integer.parseInt(input[1]);
            time = Integer.parseInt(input[2]);

            if(time < map[start][end]) {
                map[start][end] = time;
            }

        }

        dijkstra();
        Arrays.fill(visit,0);
        reverse_dijkstra();

        int result=0;

        for(int i=1; i<=N; i++){
            if(i==X) continue;
            result = Math.max(result,map[i][X]+map[X][i]);
        }

        bw.write(result+"");
        bw.flush();
    }

    public static int getSmallIndex(int num){

        int min = 99999999;
        int minIndex = 0;

        if(num==0) {
            for (int i = 1; i <= N; i++) {
                if ( i!=X && map[X][i] < min && visit[i] == 0) {
                    min = map[X][i];
                    minIndex = i;
                }
            }
        }else{
            for (int i = 1; i <= N; i++) {
                if ( i!=X && map[i][X] < min && visit[i] == 0) {
                    min = map[i][X];
                    minIndex = i;
                }
            }
        }

        return minIndex;
    }

    public static void dijkstra(){

        int distance;
        int index;

        for(int i=1; i<N; i++){

            index = getSmallIndex(0);
            visit[index]=1;

            for(int j=1; j<=N; j++){

                if(j==X||j==index) continue;

                distance = map[X][index];
                distance += map[index][j];
                map[X][j] = Math.min(map[X][j],distance);

            }

        }

    }

    public static void reverse_dijkstra(){
        int distance;
        int index;

        for(int i=1; i<N; i++){

            index = getSmallIndex(1);
            visit[index]=1;

            for(int j=1; j<=N; j++){

                if(j==X||j==index) continue;

                distance = map[index][X];
                distance += map[j][index];
                map[j][X] = Math.min(map[j][X],distance);

            }

        }
    }

}
