
import java.util.*;
import java.io.*;

public class Main {

    static int[][] color;
    static int[] gomduri;
    static int res;
    static int N;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        color = new int[N][3];

        String[] input;

        for(int i=0; i<N; i++){
            input = br.readLine().split(" ");
            for(int j=0; j<3; j++){
                color[i][j] = Integer.parseInt(input[j]);
            }
        }

        input = br.readLine().split(" ");
        gomduri = new int[3];

        for(int i=0; i<3; i++){
            gomduri[i] = Integer.parseInt(input[i]);
        }

        res = Integer.MAX_VALUE;

        dfs(0,0,0,0,0);

        bw.write(res+"");
        bw.flush();

    }

    public static void dfs(int num, int r, int g, int b, int pick){

        if(num==N || pick==7){
            if(pick>1) {
                r /= pick;
                g /= pick;
                b /= pick;

                r = Math.abs(r - gomduri[0]);
                g = Math.abs(g - gomduri[1]);
                b = Math.abs(b - gomduri[2]);

                res = Math.min(res, r + g + b);
            }
            return;
        }

        dfs(num+1, r+color[num][0], g+color[num][1], b+color[num][2], pick+1);

        dfs(num+1, r, g, b, pick);

    }

}
