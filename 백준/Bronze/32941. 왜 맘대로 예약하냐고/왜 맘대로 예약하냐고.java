
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        int T = Integer.parseInt(input[0]);
        int X = Integer.parseInt(input[1]);

        int N = Integer.parseInt(br.readLine());

        int result = 0;

        for(int i=0; i<N; i++){
            int K = Integer.parseInt(br.readLine());
            input = br.readLine().split(" ");
            for(int j=0; j<K; j++){

                int n = Integer.parseInt(input[j]);

                if(n==X){
                    result++;
                    break;
                }

            }
        }

        if(result==N){
            bw.write("YES");
        }else{
            bw.write("NO");
        }

        bw.flush();

    }

}
