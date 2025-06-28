import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static long K;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] input = br.readLine().split(" ");

        N = Integer.parseInt(input[0]);
        K = Long.parseLong(input[1]);

        long[] sum = new long[N];
        input = br.readLine().split(" ");
        long s = 0;

        for(int i=0; i<N; i++){
            s += Integer.parseInt(input[i]);
            sum[i] = s;
        }

        long res = 0;
        Map<Long, Long> map = new HashMap<>();
        map.put(0L, 1L);

        for(int i=0; i<N; i++){

            long search = sum[i] - K;

            if(map.containsKey(search)){
                res += map.get(search);
            }

            map.put(sum[i], map.containsKey(sum[i]) ? map.get(sum[i])+1 : 1L);

        }

        bw.write(res+"");
        bw.flush();

    }
}