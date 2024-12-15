
import java.io.*;
import java.util.*;

public class Main {

    static int N, K;
    static int[] student;
    static int[] distance;
    static int result;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Integer.parseInt(input[1]);

        student = new int[N];
        distance = new int[N-1];

        input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            student[i] = Integer.parseInt(input[i]);
            if(i>0){
                distance[i-1] = student[i]-student[i-1];
            }
        }

        Arrays.sort(distance);

        for(int i=0; i<N-K; i++){
            result += distance[i];
        }

        bw.write(result+"");
        bw.flush();

    }

}
