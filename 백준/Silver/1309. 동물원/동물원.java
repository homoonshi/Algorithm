
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        int[][][] map = new int[3][n][2];

        map[0][0][0] = 1;
        map[1][0][0] = 0;
        map[2][0][0] = 1;

        map[0][0][1] = 1;
        map[1][0][1] = 1;
        map[2][0][1] = 1;

        for(int i=1; i<n; i++){
            for(int j=0; j<2; j++){
                if(j==0) {
                    map[0][i][j] = map[0][i-1][1] + map[1][i-1][1] % 9901;
                    map[1][i][j] = map[2][i-1][1] % 9901;
                    map[2][i][j] = map[0][i-1][1] + map[2][i-1][1] % 9901;
                }else if(j==1){
                    map[0][i][j] = map[0][i][j-1] + map[1][i][j-1] % 9901;
                    map[1][i][j] = map[2][i][j-1] % 9901;
                    map[2][i][j] = map[0][i][j-1] % 9901;
                }
            }
        }

        int result = map[0][n-1][1] + map[1][n-1][1] + map[2][n-1][1];
        result %= 9901;

        bw.write(result+"");
        bw.flush();

    }

}
