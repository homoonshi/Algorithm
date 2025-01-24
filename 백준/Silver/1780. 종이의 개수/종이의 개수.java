
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] map;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[] result = sliceSquare(new int[]{0,0}, new int[]{N,N}, N/3);

        for (int i : result) {
            bw.write(i+"\n");
        }

        bw.flush();

    }

    public static int[] sliceSquare(int[] start, int[] end, int num){

        int[] res = new int[3];

        if(num!=0) {
            for (int i = start[0]; i < end[0]; i += num) {
                for (int j = start[1]; j < end[1]; j += num) {
                    int count = 0;
                    int[] temp = sliceSquare(new int[]{i,j}, new int[]{i+num, j+num}, num/3);
                    res[0] += temp[0];
                    res[1] += temp[1];
                    res[2] += temp[2];
                }
            }
            boolean isSquare = true;
            int c = 3;
            for (int j=0; j<3; j++) {
                if(res[j]==0){
                    continue;
                }
                if(c!=3 && c!=j){
                    isSquare = false;
                    break;
                }
                c = j;
            }
            if(isSquare){
               res[0] /= 9;
               res[1] /= 9;
               res[2] /= 9;
            }
        }else {
            int n = map[start[0]][start[1]];
            res[n+1]++;
        }

        return res;
    }

}