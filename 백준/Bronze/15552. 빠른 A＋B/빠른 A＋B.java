import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++){
            String[] input = br.readLine().split(" ");
            int res = 0;
            for(int j=0; j<2; j++){
                res += Integer.parseInt(input[j]);
            }
            bw.write(res+"\n");
        }
        
        bw.flush();

    }

}