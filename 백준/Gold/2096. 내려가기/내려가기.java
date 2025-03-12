
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][3];
        int[][] max = new int[N][3];
        int[][] min = new int[N][3];

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<3; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
            Arrays.fill(max[i], Integer.MIN_VALUE);
            Arrays.fill(min[i], Integer.MAX_VALUE);
        }

        for(int i=0; i<3; i++){
            max[0][i] = map[0][i];
            min[0][i] = map[0][i];
        }

        for(int i=1; i<N; i++){

            for(int j=0; j<3; j++){

                int current = map[i][j];

                max[i][j] = Math.max(max[i][j], max[i-1][j] + current);
                min[i][j] = Math.min(min[i][j], min[i-1][j] + current);

                if(j-1 >= 0){
                    max[i][j] = Math.max(max[i][j], max[i-1][j-1] + current);
                    min[i][j] = Math.min(min[i][j], min[i-1][j-1] + current);
                }

                if(j+1 < 3){
                    max[i][j] = Math.max(max[i][j], max[i-1][j+1] + current);
                    min[i][j] = Math.min(min[i][j], min[i-1][j+1] + current);
                }

            }

        }

        int maxResult = Integer.MIN_VALUE;
        int minResult = Integer.MAX_VALUE;

        for(int i=0; i<3; i++){
            maxResult = Math.max(maxResult, max[N-1][i]);
            minResult = Math.min(minResult, min[N-1][i]);
        }

        bw.write(maxResult+" "+minResult);
        bw.flush();

    }

}
