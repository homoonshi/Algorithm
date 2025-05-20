
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        int[] B = new int[N];

        String[] input1 = br.readLine().split(" ");
        String[] input2 = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            A[i] = Integer.parseInt(input1[i]);
            B[i] = Integer.parseInt(input2[i]);
        }

        Arrays.sort(A);
        Arrays.sort(B);

        int index = N-1;
        int S = 0;

        for(int i=0; i<N; i++){
            S += A[i] * B[index-i];
        }

        bw.write(S+"");
        bw.flush();

    }
}