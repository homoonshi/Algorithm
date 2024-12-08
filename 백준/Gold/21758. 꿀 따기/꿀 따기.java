
import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] map;
    static int[] sum;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        map = new int[N];
        sum = new int[N];
        int s = 0;

        String[] input = br.readLine().split(" ");

        for(int i=0; i<N; i++){
            map[i] = Integer.parseInt(input[i]);
            s += map[i];
            sum[i] = s;
        }

        int result = Integer.MIN_VALUE;

        for(int i=1; i<N-1; i++){

            // 꿀통이 맨 처음
            s = sum[N-1] - map[N-1] + sum[i] - map[i]*2;
            result = Math.max(result, s);

            // 꿀통이 맨 끝
            s = (sum[N-1]*2) - map[0] - sum[i] - map[i];
            result = Math.max(result, s);

            // 벌이 맨 끝
            s = sum[N-1] - map[N-1] - map[0] + map[i];
            result = Math.max(result, s);

        }

        bw.write(result+"");
        bw.flush();

    }

}
