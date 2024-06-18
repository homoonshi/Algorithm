import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    static int N;
    static long[] weight;

    public static void main(String[] args) throws Exception{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        weight = new long[N];
        long sumWeight=0;

        String[] input = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            weight[i] = Long.parseLong(input[i]);
        }

        Arrays.sort(weight);

        for(int i=0; i<N; i++){
            if(sumWeight+1 < weight[i]) {
                break;
            }
            sumWeight += weight[i];
        }

        bw.write(sumWeight+1+"");
        bw.flush();

    }

}