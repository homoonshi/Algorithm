import java.io.*;
import java.util.*;

public class Main {

    static int N, M;
    static int[] H;
    static int[] A;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        M = Integer.parseInt(input[1]);

        H = new int[N+1];
        A = new int[M+1];

        input = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            H[i+1] = Integer.parseInt(input[i]);
        }

        input = br.readLine().split(" ");

        for(int i=0; i<M; i++){
            A[i+1] = Integer.parseInt(input[i]);
        }

        Arrays.sort(H);
        Arrays.sort(A);

        int min = 1;

        long[] win = new long[N+1];
        long[] draw = new long[N+1];

        long resW = 0;
        long resD = 0;

        for(int i=1; i<=N; i++){

            if(H[i]==H[i-1]){
                win[i] = win[i-1];
                draw[i] = draw[i-1];
                resW += win[i];
                resD += draw[i];
                continue;
            }

            long w = win[i-1] + draw[i-1];
            long d = 0;
            int j = min;

            for( ; j<=M; j++){
                if(H[i]<A[j]){
                    break;
                }else if(H[i]==A[j]){
                    d++;
                }else{
                    w++;
                }
            }

            min = j;
            win[i] = w;
            draw[i] = d;
            resW += win[i];
            resD += draw[i];

        }

        bw.write(resW+" "+(((long) N *M)-resW-resD)+" "+resD);
        bw.flush();

    }
}