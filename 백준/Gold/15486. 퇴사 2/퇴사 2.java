
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] input;

        long[] totalCost = new long[N+2];
        int[][] schedule = new int[N+1][2];

        for(int i=1; i<=N; i++){

            input = br.readLine().split(" ");

            schedule[i][0] = Integer.parseInt(input[0]);
            schedule[i][1] = Integer.parseInt(input[1]);

            totalCost[i] = Math.max(totalCost[i], totalCost[i-1]);
            int completeDay = i + schedule[i][0];

            if(completeDay <= N+1){
                long cost = schedule[i][1] + totalCost[i];
                totalCost[completeDay] = Math.max(totalCost[completeDay], cost);
            }

        }

        long result = Math.max(totalCost[N], totalCost[N+1]);

        bw.write(result+"");
        bw.flush();

    }

}
