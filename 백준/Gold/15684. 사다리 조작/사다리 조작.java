
import java.io.*;
import java.util.*;

public class Main {

    static int N,M,H;
    static int[][] width;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);
        H = Integer.parseInt(input[2]);

        width = new int[H + 1][N + 1];
        int res = 0;

        for (int i = 0; i < M; i++) {

            input = br.readLine().split(" ");

            int h = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            width[h][b] = 1;
            width[h][b + 1] = -1;

        }
        
        int r = 0;
        
        for(int i=1; i<=N; i++){
            if(find(i)){
               r++; 
            }
        }

        if(M==0 || r==N){
            bw.write("0");
            bw.flush();
            return;
        }

        for(int i = 1; i <= ((N-1)*H-M); i++){
            if(i>=4){
                break;
            }
            if(install(0, i, 1)){
                bw.write(i+"");
                bw.flush();
                return;
            }
        }

        bw.write("-1");
        bw.flush();
    }

    public static boolean install(int w, int limit, int n){
        if(w==limit){
            for(int i=1; i<=N; i++){
                if(!find(i)){
                    return false;
                }
            }
            return true;
        }

        for(int i=n; i<=H; i++){
            for(int j=1; j<=(N-1); j++){
                if(width[i][j]!=0 || width[i][j+1]!=0){
                    continue;
                }
                width[i][j] = 1;
                width[i][j+1] = -1;
                if(install(w+1, limit, i)){
                   return true;
                }
                width[i][j] = 0;
                width[i][j+1] = 0;
            }
        }
        return false;
    }

    public static boolean find(int n){
        int x = n;

        for(int i=1; i<=H; i++){

            int d = width[i][x];

            if(d==1){
                x++;
            }else if(d==-1){
                x--;
            }

        }

        return x == n;
    }

}