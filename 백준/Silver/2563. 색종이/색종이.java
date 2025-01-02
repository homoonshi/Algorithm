
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[101][101];
        int result = 0;

        for(int i=0; i<N; i++){

            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int m = Integer.parseInt(input[1]);

            for(int j=1; j<=10; j++){
                for(int k=1; k<=10; k++){
                    if(map[n+j][m+k]==0){
                        map[n+j][m+k]=1;
                        result++;
                    }
                }
            }

        }

        bw.write(result+"");
        bw.flush();

    }

}
