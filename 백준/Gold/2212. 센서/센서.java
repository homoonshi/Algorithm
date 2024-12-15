
import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int K;
    static int[] sensors;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());
        sensors = new int[N];

        String[] input = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            sensors[i] = Integer.parseInt(input[i]);
        }

        Arrays.sort(sensors);

        int[] distance = new int[N-1];

        for(int i=1; i<N; i++){
            distance[i-1] = sensors[i]-sensors[i-1];
        }

        Arrays.sort(distance);
        int result = 0;

        for(int i=0; i<N-K; i++){
            result += distance[i];
        }

        bw.write(result+"");
        bw.flush();

    }

}
