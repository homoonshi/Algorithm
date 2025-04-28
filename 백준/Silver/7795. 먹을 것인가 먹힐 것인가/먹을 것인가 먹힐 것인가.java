
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 0; test_case<T; test_case++){

            String[] input = br.readLine().split(" ");

            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            int[] A = new int[N];
            int[] B = new int[M];

            input = br.readLine().split(" ");

            for(int i=0; i<N; i++){
                A[i] = Integer.parseInt(input[i]);
            }

            input = br.readLine().split(" ");

            for(int i=0; i<M; i++){
                B[i] = Integer.parseInt(input[i]);
            }

            Arrays.sort(A);
            Arrays.sort(B);

            int aEnd = N-1;
            int bEnd = M-1;

            int res = 0;

            for(int i=aEnd; i>=0; i--){

                while(bEnd >= 0 && A[i]<=B[bEnd]){
                    bEnd--;
                }

                if(bEnd<0){
                    break;
                }

                res += (bEnd+1);

            }

            bw.write(res+"\n");

        }

        bw.flush();

    }
}