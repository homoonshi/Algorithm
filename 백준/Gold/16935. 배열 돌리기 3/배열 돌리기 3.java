
import java.io.*;
import java.util.*;

public class Main {

    static int N,M;
    static int[][] map;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        int R = Integer.parseInt(input[2]);

        map = new int[N][M];

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<M; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        input = br.readLine().split(" ");

        for(int i=0; i<R; i++){

            int r = Integer.parseInt(input[i]);
            N = map.length;
            M = map[0].length;

            if(r==1){
                topBottom();
            }else if(r==2){
                leftRight();
            }else if(r==3){
                rightNine();
            }else if(r==4){
                leftNine();
            }else if(r==5){
                clockwise();
            }else if(r==6){
                counterClockwise();
            }

        }

        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[i].length; j++){
                bw.write(map[i][j]+" ");
            }
            bw.write("\n");
        }

        bw.flush();

    }

    static public void topBottom(){

        int[][] res = new int[N][M];

        for(int i=1; i<=N; i++){
            res[N-i] = map[i-1];
        }

        for(int i=0; i<N; i++){
            map[i] = res[i];
        }

    }

    static public void leftRight(){

        int[][] res = new int[N][M];

        for(int i=0; i<N; i++){
            for(int j=1; j<=M; j++){
                res[i][j-1] = map[i][M-j];
            }
        }

        for(int i=0; i<N; i++){
            map[i] = res[i];
        }

    }

    static public void rightNine(){

        int[][] res = new int[M][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                res[j][i] = map[N-i-1][j];
            }
        }

        map = new int[M][N];

        for(int i=0; i<M; i++){
            map[i] = res[i];
        }

    }

    static public void leftNine(){

        int[][] res = new int[M][N];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                res[j][i] = map[i][M-j-1];
            }
        }

        map = new int[M][N];

        for(int i=0; i<M; i++){
            map[i] = res[i];
        }

    }

    static public void clockwise(){

        int[][] res = new int[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(i<N/2){
                    if(j<M/2){
                        res[i][j] = map[(N/2)+i][j];
                    }else{
                        res[i][j] = map[i][j-(M/2)];
                    }
                }else{
                    if(j<M/2){
                        res[i][j] = map[i][j+(M/2)];
                    }else{
                        res[i][j] = map[i-(N/2)][j];
                    }
                }
            }
        }

        for(int i=0; i<N; i++){
            map[i] = res[i];
        }

    }

    static public void counterClockwise(){

        int[][] res = new int[N][M];

        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(i<N/2){
                    if(j<M/2){
                        res[i][j] = map[i][j+(M/2)];
                    }else{
                        res[i][j] = map[i+(N/2)][j];
                    }
                }else{
                    if(j<M/2){
                        res[i][j] = map[i-(N/2)][j];
                    }else{
                        res[i][j] = map[i][j-(M/2)];
                    }
                }
            }
        }

        for(int i=0; i<N; i++){
            map[i] = res[i];
        }


    }

}
