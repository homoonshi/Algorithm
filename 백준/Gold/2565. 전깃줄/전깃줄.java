
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[][] electric;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        electric = new int[N][2];

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            electric[i][0] = Integer.parseInt(input[0]);
            electric[i][1] = Integer.parseInt(input[1]);
        }

        Arrays.sort(electric, Comparator.comparingInt(o -> o[1]));

        int result = lis();

        bw.write(result+"");
        bw.flush();
        br.close();
        bw.close();

    }

    public static int lis(){

        int[] dp = new int[N];
        int len = 0;

        for(int i=0; i<N; i++){
            int pos = Arrays.binarySearch(dp, 0, len, electric[i][0]);
            if ( pos < 0 ){
                pos = -(pos+1);
            }
            dp[pos] = electric[i][0];
            if( pos == len){
                len++;
            }
        }

        return N-len;
    }

}